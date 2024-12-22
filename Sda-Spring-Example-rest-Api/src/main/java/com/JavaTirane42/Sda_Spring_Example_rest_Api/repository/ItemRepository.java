package com.JavaTirane42.Sda_Spring_Example_rest_Api.repository;

import com.JavaTirane42.Sda_Spring_Example_rest_Api.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

}
