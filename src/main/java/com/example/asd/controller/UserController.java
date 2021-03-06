package com.example.asd.controller;

import com.example.asd.common.ResponseBean;
import com.example.asd.common.constant.Constant;
import com.example.asd.config.helper.ValidateHelper;
import com.example.asd.config.jwt.AuthToken;
import com.example.asd.config.jwt.BcrptTokenGenerator;
import com.example.asd.config.redis.JedisUtil;
import com.example.asd.entity.base.LoginOutResponse;
import com.example.asd.entity.MeunBto;
import com.example.asd.entity.UserBto;
import com.example.asd.entity.base.LoginResponse;
import com.example.asd.entity.base.UserRequest;
import com.example.asd.exception.CustomException;
import com.example.asd.service.impl.MeunImpl;
import com.example.asd.service.impl.UserServiceImpl;
import com.example.asd.util.BCrypt;
import com.example.asd.util.CheckPwd;


import com.example.asd.util.common.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = {"用户登陆/登出/注册接口"})
public class UserController {
    @Autowired
    BcrptTokenGenerator bcrptTokenGenerator;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    MeunImpl meunImpl;

    /**
     * 用户登录
     *
     * @param userRequest
     * @return
     */
    @ApiOperation("用户登录接口")
    @RequestMapping(value = "/infota/product/inLogin", method = RequestMethod.POST)
    public ResponseBean inLogin(@RequestBody UserRequest userRequest) {
        UserBto userBto = userService.getUserByname(userRequest.getUserName());
        if (userBto == null) {
            throw new CustomException("查询失败,该账号未注册(Query Failure)");
        }
        String userName = userRequest.getUserName();
        String password = userRequest.getPassword();
        if (!StringUtils.isNotEmptyStr(userName) && !StringUtils.isNotEmptyStr(password)) {
            throw new CustomException("账户、密码不能为空(Query Failure)");
        }
        int accountStatus = userBto.getAccountStatus();
        if (accountStatus == 0) {
            throw new CustomException("账户被冻结，请联系管理员(Account Failure)");
        }
        int errorNumber = userBto.getPasswordRetryCount();
        String sqlPassworld = userBto.getLoginPassword();
        if (!BCrypt.checkpw(password, sqlPassworld)) {
            errorNumber -= 1;
            if (errorNumber == 0) {
                userBto.setAccountStatus((short) 0);
            }
            userBto.setPasswordRetryCount(errorNumber);
            userService.updateUser(userBto);
            return new ResponseBean(1, "密码错误(Passworld Failure)", new LoginResponse(2, "", errorNumber, null));
        }
        userBto.setPasswordRetryCount(5);
        userService.updateUser(userBto);
        List<MeunBto> meunBtoList = meunImpl.getMeun();
        List<LoginResponse.MenusItemBean> menus = new ArrayList<>();
        for (MeunBto meunBto : meunBtoList) {
            LoginResponse.MenusItemBean menusItemBean = new LoginResponse.MenusItemBean();
            menusItemBean.setId(meunBto.getMenuId());
            menusItemBean.setPage(meunBto.getIspage() == 1 ? true : false);
            menusItemBean.setShow(meunBto.getIsshow() == 1 ? true : false);
            menusItemBean.setLink(meunBto.getMenulink());
            menusItemBean.setpId(meunBto.getFkMenuId());
            menusItemBean.setPermissionId("");
            menusItemBean.setText(meunBto.getMenudisplayname());
            List<LoginResponse.MenusItemBean> children = new ArrayList<>();
            if (StringUtils.isNotEmptyStr(meunBto.getFkMenuId())) {
                for (MeunBto meunBto2 : meunBtoList) {
                    if (meunBto.getFkMenuId().equals(meunBto2.getMenuId())) {
                        LoginResponse.MenusItemBean fatherItemBean = new LoginResponse.MenusItemBean();
                        fatherItemBean.setId(meunBto2.getMenuId());
                        fatherItemBean.setPage(meunBto2.getIspage() == 1 ? true : false);
                        fatherItemBean.setShow(meunBto2.getIsshow() == 1 ? true : false);
                        fatherItemBean.setLink(meunBto2.getMenulink());
                        fatherItemBean.setpId(meunBto2.getFkMenuId());
                        fatherItemBean.setPermissionId("");
                        fatherItemBean.setChildren(new ArrayList<>());
                        fatherItemBean.setText(meunBto2.getMenudisplayname());
                        children.add(fatherItemBean);
                    }
                }
            } else {
                menusItemBean.setChildren(children);
            }
            menusItemBean.setChildren(children);
            menus.add(menusItemBean);
        }

        if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userName)) {
            Object token = JedisUtil.getObject(Constant.PREFIX_SHIRO_CACHE + userName);
            return new ResponseBean(1, "登陆成功", new LoginResponse(1, token + "", 0, menus));
        } else {
            String token = bcrptTokenGenerator.generate(userName);
            JedisUtil.setObject(Constant.PREFIX_SHIRO_CACHE + userName, token, Constant.EXRP_DAY);
            JedisUtil.setObject(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token, userName, Constant.EXRP_DAY);
            return new ResponseBean(1, "登陆成功", new LoginResponse(1, token, 0, menus));
        }
    }


    /**
     * 用户登出
     *
     * @return
     */
    @ApiOperation("用户登出接口")
    @AuthToken
    @RequestMapping(value = "/infota/product/exitLogin", method = RequestMethod.GET)
    public ResponseBean exitLogin(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (JedisUtil.exists(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token)) {
            Object userName = JedisUtil.getObject(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token);
            JedisUtil.delKey(Constant.PREFIX_SHIRO_ACCESS_TOKEN + token);
            JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userName);
            return new ResponseBean(1, "成功退出登陆", new LoginOutResponse(1));
        } else {
            return new ResponseBean(0, "登出失败", new LoginOutResponse(2));
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
        ValidateHelper.validateNull(userBto, new String[]{"loginName", "loginPassword", "accountKind", "accountStatus", "isdelete", "createby"});
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