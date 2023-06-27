package com.shopmax.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmax.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{ //해당 repository에서 사용할 Entity, Entity클래스의 기본키 타입
	
}
