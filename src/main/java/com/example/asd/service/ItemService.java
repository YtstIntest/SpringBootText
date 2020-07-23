package com.example.asd.service;

import com.example.asd.entity.ItemBto;

import java.util.List;

public interface ItemService {

    List<ItemBto> getAllItem();

    ItemBto getItemById(String itemId);

    int addItem(ItemBto ItemBto);

    int updateItem(ItemBto ItemBto);

    int deleteItem(String itemId);
}
