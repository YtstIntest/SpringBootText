package com.example.asd.controller;

import com.example.asd.entity.SelectorBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

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

}