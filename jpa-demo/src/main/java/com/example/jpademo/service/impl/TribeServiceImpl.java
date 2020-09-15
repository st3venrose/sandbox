package com.example.jpademo.service.impl;

import com.example.jpademo.entity.Tribe;
import com.example.jpademo.repository.TribeRepository;
import com.example.jpademo.service.TribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TribeServiceImpl implements TribeService {

	@Autowired
	private TribeRepository tribeRepository;

	@Override
	public List<Tribe> getAllTribe() {
		return tribeRepository.findAll();
	}

	@Override
	public void saveTribe(Tribe tribe) {
		tribeRepository.save(tribe);
	}

	@Override
	public Tribe getById(Long id) {
		return tribeRepository.findById(id).orElseThrow(() -> new RuntimeException("Tribe not found!"));
	}
}
