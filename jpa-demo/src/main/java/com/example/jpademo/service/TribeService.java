package com.example.jpademo.service;

import com.example.jpademo.entity.Tribe;

import java.util.List;

public interface TribeService {

	List<Tribe> getAllTribe();

	void saveTribe(Tribe tribe);

	Tribe getById(Long id);
}
