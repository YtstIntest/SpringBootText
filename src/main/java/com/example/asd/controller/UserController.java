package com.example.asd.controller;

import com.example.asd.common.ResponseBean;
import com.example.asd.common.constant.Constant;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.config.jwt.BcrptTokenGenerator;
import com.example.asd.config.redis.JedisUtil;
import com.example.asd.dto.LoginDto;
import com.example.asd.dto.LoginOutDto;
import com.example.asd.entity.UserBto;
import com.example.asd.exception.CustomException;
import com.example.asd.service.UserServiceImpl;
import com.example.asd.util.BCrypt;
import com.example.asd.util.CheckPwd;


import com.example.asd.util.common.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.UUID;

@RestController
@Api(tags={"用户登陆/登出/注册接口"})
public class UserController {
    @Autowired
    BcrptTokenGenerator bcrptTokenGenerator;

    @Autowired
    UserServiceImpl userService;

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return
     */
    @ApiOperation("用户登录接口")
    @RequestMapping(value = "/infota/product/inLogin", method = RequestMethod.POST)
    public ResponseBean inLogin(@ApiParam(value = "账号", required = true) String userName, @ApiParam(value = "密码", required = true)String password) {
        if (!StringUtils.isNotEmptyStr(userName) && !StringUtils.isNotEmptyStr(password)) {
            throw new CustomException("账户、密码不能为空(Query Failure)");
        }
        UserBto userBto = userService.getUserByname(userName);
        if (userBto == null) {
            throw new CustomException("查询失败,该账号未注册(Query Failure)");
        }
        int accountStatus = userBto.getAccountStatus();
        if (accountStatus == 0) {
            throw new CustomException("账户被冻结，请联系管理员(Account Failure)");
        }
        int errorNumber = userBto.getPasswordRetryCount();
        String sqlPassworld = userBto.getLoginPassword();
        if (!BCrypt.checkpw(password, sqlPassworld)) {
            errorNumber -= 1;
            if(errorNumber==0){
                userBto.setAccountStatus((short) 0);
            }
            userBto.setPasswordRetryCount(errorNumber);
            userService.updateUser(userBto);
            return new ResponseBean(1, "密码错误(Passworld Failure)", new LoginDto(2, "", errorNumber));
        }
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userName)) {
            throw new CustomException("登陆失败,该账号已登陆(Login Failure)");
        } else {
            String token = bcrptTokenGenerator.generate(userName);
            JedisUtil.setObject(Constant.PREFIX_SHIRO_CACHE + userName, token, Constant.EXRP_DAY);
            JedisUtil.setObject(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token, userName, Constant.EXRP_DAY);
            userBto.setPasswordRetryCount(5);
            userService.updateUser(userBto);
            return new ResponseBean(1, "登陆成功", new LoginDto(1, token, 0));
        }
    }

    /**
     * 用户登出
     *
     * @param userName
     * @return
     */
    @ApiOperation("用户登出接口")
    @RequestMapping(value = "/infota/product/exitLogin", method = RequestMethod.POST)
    public ResponseBean exitLogin(@ApiParam(value = "账号", required = true)String userName) {
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userName)) {
            Object token = JedisUtil.getObject(Constant.PREFIX_SHIRO_CACHE + userName);
            JedisUtil.delKey(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token);
            JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userName);
            return new ResponseBean(1, "成功退出登陆", new LoginOutDto(1));
        } else {
            return new ResponseBean(0, "登出失败", new LoginOutDto(2));
        }

    }

    /**
     * 用户注册
     *
     * @param userBto
     * @return
     */
    @ApiOperation("用户注册接口")
    @RequestMapping(value = "/infota/product/inRegister", method = RequestMethod.POST)
    public ResponseBean inRegister(@RequestBody UserBto userBto) {
        String account = userBto.getLoginName();
        String passworld = userBto.getLoginPassword();
        ValidateHelper.validateNull(userBto, new String[]{"loginName", "loginPassword", "accountKind", "isdelete", "createby"});
        if (account.equals(passworld)) {
            throw new CustomException("密码不可与用户名一致");
        }

        if (CheckPwd.checkLateralKeyboardSite(passworld) || CheckPwd.checkSequentialChars(passworld)) {
            throw new CustomException("密码不能连续3位或3位以上字母或数字");
        }

        if (CheckPwd.checkSequentialSameChars(passworld)) {
            throw new CustomException("密码不能相同连续3位或3位以上字母或数字");
        }

        if (!CheckPwd.checkPasswordLength(passworld)) {
            throw new CustomException("密码长度必须8-16位");
        }

        if (userService.getUserByname(account) != null) {
            throw new CustomException("已存在相同用户名，请重新修改用户名");
        }

        if (CheckPwd.checkContainDigit(passworld) && CheckPwd.checkContainCase(passworld) && CheckPwd.checkContainSpecialChar(passworld)) {
            UUID uuid = UUID.randomUUID();
            userBto.setUserId(uuid + "");
            String yan = BCrypt.gensalt();
            userBto.setCsprng(yan);
            String hashd = BCrypt.hashpw(passworld, yan);
            userBto.setLoginPassword(hashd);
            userBto.setCreateat(new Date());
            if (userService.addUser(userBto) == 1) {
                return new ResponseBean(1, "注册成功", null);
            } else {
                throw new CustomException("注册失败");
            }
        } else {
            throw new CustomException("密码必须由字母、数字、特殊符号组成");
        }
    }
}