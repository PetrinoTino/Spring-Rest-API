package com.JavaTirane42.Sda_Spring_Example_rest_Api.service;

import com.JavaTirane42.Sda_Spring_Example_rest_Api.repository.ItemRepository;
import com.JavaTirane42.Sda_Spring_Example_rest_Api.entity.Item;
import com.JavaTirane42.Sda_Spring_Example_rest_Api.model.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public List<Item> getAllItems(){
        return  itemRepository.findAll();
    }
    public Optional<Item> getItemById(Long id){
        return itemRepository.findById(id);
    }

    public Item createItem(ItemDTO itemDTO){
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        item.setCategory(itemDTO.getCategory());
        item.setPrice(itemDTO.getPrice());
        return itemRepository.save(item);
    }
    public Optional<Item> updateItem(Item item){
        Optional<Item> existingItem = itemRepository.findById(item.getId());
        if (existingItem.isEmpty()){
            return Optional.empty();
        }
        Item updatedItem = existingItem.get();
        updatedItem.setName(item.getName());
        updatedItem.setDescription(item.getDescription());
        updatedItem.setCategory(item.getCategory());
        updatedItem.setPrice(item.getPrice());
        return Optional.of(itemRepository.save(updatedItem));
    }

    public boolean deleteItem(Long id){
        Optional<Item> existingItem = itemRepository.findById(id);
        if (existingItem.isEmpty()){
            return false;
        }
        itemRepository.deleteById(id);
        return true;
    }
}
