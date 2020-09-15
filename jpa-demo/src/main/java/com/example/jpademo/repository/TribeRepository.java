package com.example.jpademo.repository;

import com.example.jpademo.entity.Tribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TribeRepository extends JpaRepository<Tribe, Long> {
}
