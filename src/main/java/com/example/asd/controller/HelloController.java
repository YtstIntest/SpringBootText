package com.example.asd.controller;

import com.example.asd.entity.PersonBean;
import com.example.asd.entity.SelectorBean;
import com.example.asd.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Api(produces = "选项卡API接口")
@RestController
public class HelloController {
    private static int ExpireTime = 10;   // redis中存储的过期时间60s

    @Resource
    private RedisUtil redisUtil;


    @ApiOperation(value="111111", notes="选项卡选项", produces="application/json")
    @RequestMapping(value = "/fota/zt/selector", method = RequestMethod.POST)
    public SelectorBean selector(){
        SelectorBean bean=new SelectorBean();
        List<SelectorBean.DataBean> listD= new ArrayList<>();
        SelectorBean.DataBean dataBean =new SelectorBean.DataBean();
        SelectorBean.DataBean dataBean2 =new SelectorBean.DataBean();
        List<SelectorBean.DataBean.RowListBean> listR= new ArrayList<>();
        SelectorBean.DataBean.RowListBean rowListBean = new SelectorBean.DataBean.RowListBean();
        List<SelectorBean.DataBean.RowListBean.ListOfFilterBean> listL= new ArrayList<>();
        SelectorBean.DataBean.RowListBean.ListOfFilterBean listOfFilterBean=new SelectorBean.DataBean.RowListBean.ListOfFilterBean();
        SelectorBean.DataBean.RowListBean.ListOfFilterBean listOfFilterBean2=new SelectorBean.DataBean.RowListBean.ListOfFilterBean();

        dataBean.setId(111);
        dataBean.setChecked(false);

        rowListBean.setRowId(1113);
        rowListBean.setTitle("地址");
        rowListBean.setRowOrder("1");
        rowListBean.setSortOrder(null);
        rowListBean.setChecked(true);
        rowListBean.setValue("'Joe'");
        rowListBean.setWidth("300px");

        listOfFilterBean.setText("'Joe'");
        listOfFilterBean.setValue("'Joe'");
        listOfFilterBean.setChecked(false);

        listOfFilterBean2.setText("'Joe'");
        listOfFilterBean2.setValue("'Joe'");
        listOfFilterBean2.setChecked(false);

        listL.add(listOfFilterBean);
        listL.add(listOfFilterBean2);

        listR.add(rowListBean);

        listD.add(dataBean);


        dataBean2=dataBean;
        listD.add(dataBean2);

        rowListBean.setListOfFilter(listL);
        dataBean.setRowList(listR);
        bean.setData(listD);

        return bean;
    }

    @RequestMapping(value = "/fota/zt/set", method = RequestMethod.POST)
    public boolean redisset(String key, String value){
        PersonBean userEntity =new PersonBean();

        userEntity.setName("zhangsan");
        userEntity.setAge(String.valueOf(20));
        userEntity.setCreatTime("2012:20:20");

        //return redisUtil.set(key,userEntity,ExpireTime);

        return redisUtil.set("bean",userEntity,ExpireTime);
    }
    @RequestMapping(value = "/fota/zt/get", method = RequestMethod.POST)
    public Object redisget(String key){
        return redisUtil.get(key);
    }
    @RequestMapping(value = "/fota/zt/expire", method = RequestMethod.POST)
    public boolean expire(String key){
        return redisUtil.expire(key,ExpireTime);
    }
}