package com.example.jpademo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tribe")
public class Tribe extends BaseEntity {

	@Builder
	public Tribe(Long id, String name, List<Squad> squads) {
		super(id, name);
		this.squads = squads;
	}

	@OneToMany(mappedBy = "tribe", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Squad> squads = new ArrayList<>();
}


