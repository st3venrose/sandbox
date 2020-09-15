package com.example.jpademo.controller;

import com.example.jpademo.entity.Tribe;
import com.example.jpademo.service.TribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TribeController {

	@Autowired
	private TribeService tribeServiceImpl;

	@GetMapping("/tribes")
	public List<Tribe> getAllTribe() {
		return tribeServiceImpl.getAllTribe();
	}

	@GetMapping("/tribes/{id}")
	public Tribe getById(@PathVariable Long id) {
		return tribeServiceImpl.getById(id);
	}

	@PostMapping("/tribes")
	public void getAllTribe(@RequestBody Tribe tribe) {
		tribeServiceImpl.saveTribe(tribe);
	}
}
