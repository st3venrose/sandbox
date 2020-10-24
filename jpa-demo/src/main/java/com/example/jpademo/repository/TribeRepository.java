package com.example.jpademo.repository;

import com.example.jpademo.entity.Tribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TribeRepository extends JpaRepository<Tribe, Long> {

	@Query(value = "SELECT t FROM Tribe t")
	List<Tribe> getAllTribe();

	@Query(value = "SELECT t FROM Tribe t where t.id = :id")
	Optional<Tribe> findById(Long id);
}
