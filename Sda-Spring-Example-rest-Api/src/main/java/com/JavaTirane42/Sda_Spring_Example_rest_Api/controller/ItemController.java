package com.JavaTirane42.Sda_Spring_Example_rest_Api.controller;

import com.JavaTirane42.Sda_Spring_Example_rest_Api.service.ItemService;
import com.JavaTirane42.Sda_Spring_Example_rest_Api.entity.Item;
import com.JavaTirane42.Sda_Spring_Example_rest_Api.model.ItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getItemByID(@PathVariable Long id) {
        return itemService.getItemById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("create")
    public ResponseEntity<Item> createItem(@RequestBody ItemDTO itemDto) {
        return ResponseEntity.ok(itemService.createItem(itemDto));
    }

    @PutMapping("update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        return itemService.updateItem(item)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //if Else other way
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        return itemService.deleteItem(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }
//   ME if Else
//     if (itemService.deleteItem(id)) {
//        return ResponseEntity.ok("Item deleted");
//    } else {
//        return ResponseEntity.status(BAD_REQUEST).body("Item not deleted");
//    }
}


