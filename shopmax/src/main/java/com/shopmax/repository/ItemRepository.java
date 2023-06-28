package com.shopmax.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopmax.constant.ItemSellStatus;
import com.shopmax.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> { // 해당 repository에서 사용할 Entity, Entity클래스의 기본키 타입
	// select * from item where item_nm = ?
	List<Item> findByItemNm(String itemNm);

	// select * from item where item_nm = ? and item_sell_status = ?
	List<Item> findByItemNmAndItemSellStatus(String itemNm, ItemSellStatus itemSellStatus);

	List<Item> findByPriceBetween(int price1, int price2);

	List<Item> findByRegTimeAfter(LocalDateTime localDateTime);

	List<Item> findByItemSellStatusIsNotNull();

	List<Item> findByItemDetailLike(String itemDetail);

	List<Item> findByItemNmOrItemDetail(String itemNm, String itemDetail);

	List<Item> findByPriceLessThanOrderByPriceDesc(int price);
}
