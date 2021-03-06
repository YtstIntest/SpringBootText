package com.example.asd.service.impl;

import com.example.asd.dao.ItemBtoMapper;
import com.example.asd.entity.ItemBto;
import com.example.asd.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemImpl implements ItemService {

    @Resource
    ItemBtoMapper itemBtoMapper;

    @Override
    public List<ItemBto> getAllItem() {
        return itemBtoMapper.selectAll();
    }

    @Override
    public ItemBto getItemById(String itemId) {
        return itemBtoMapper.selectByPrimaryKey(itemId);
    }

    @Override
    public int addItem(ItemBto itemBto) {
        return itemBtoMapper.insert(itemBto);
    }

    @Override
    public int updateItem(ItemBto itemBto) {
        return itemBtoMapper.updateByPrimaryKey(itemBto);
    }

    @Override
    public int deleteItem(String itemId) {
        return itemBtoMapper.deleteByPrimaryKey(itemId);
    }
}
