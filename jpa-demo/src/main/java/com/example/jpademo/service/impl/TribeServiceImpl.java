package com.example.jpademo.service.impl;

import com.example.jpademo.entity.Tribe;
import com.example.jpademo.repository.TribeRepository;
import com.example.jpademo.service.TribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TribeServiceImpl implements TribeService {

	@Autowired
	private TribeRepository tribeRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Tribe> getAllTribe() {
		return tribeRepository.getAllTribe();
	}

	@Override
	@Transactional
	public void saveTribe(Tribe tribe) {
		tribeRepository.save(mapRelationOwners(tribe));
	}

	@Override
	@Transactional(readOnly = true)
	public Tribe getById(Long id) {
		return tribeRepository.findById(id).orElseThrow(() -> new RuntimeException("Tribe not found!"));
	}

	private Tribe mapRelationOwners(Tribe tribe) {
		tribe.getSquads().forEach(squad -> {
			squad.setTribe(tribe);
			squad.getMembers().forEach(member -> member.setSquad(squad));
		});

		return tribe;
	}
}
