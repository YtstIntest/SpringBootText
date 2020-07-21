package com.example.asd.service;

import com.example.asd.entity.ItemBto;

public interface ItemService {
    ItemBto getItemById(String itemId);

    int addItem(ItemBto ItemBto);

    int updateItem(ItemBto ItemBto);

    int deleteItem(String itemId);
}
