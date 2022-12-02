package com.ty.Hospital.HospitalBoot_prc.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.Hospital.HospitalBoot_prc.dto.Items;
import com.ty.Hospital.HospitalBoot_prc.repositery.ItemsRepository;

@Repository
public class ItemsDao {

	@Autowired
	ItemsRepository itemsRepository;

	public Items saveItems(Items items) {
		return itemsRepository.save(items);
	}

	public Items updateItems(Items items) {
		return itemsRepository.save(items);
	}

	public Items getItemsById(int id) {
		Optional<Items> optional = itemsRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public String deleteItemsById(int id) {
		itemsRepository.deleteById(id);
		return "deleted";
	}
}
