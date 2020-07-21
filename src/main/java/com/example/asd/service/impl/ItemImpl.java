package com.example.asd.service.impl;

import com.example.asd.dao.ItemBtoMapper;
import com.example.asd.entity.ItemBto;
import com.example.asd.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemImpl implements ItemService {

    @Resource
    ItemBtoMapper itemBtoMapper;
    @Override
    public ItemBto getItemById(String itemId) {
        return itemBtoMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int addItem(ItemBto ItemBto) {
        return itemBtoMapper.insert(ItemBto);
    }

    @Override
    public int updateItem(ItemBto ItemBto) {
        return itemBtoMapper.updateByPrimaryKey(ItemBto);
    }

    @Override
    public int deleteItem(String itemId) {
        return itemBtoMapper.deleteByPrimaryKey(itemId);
    }
}
