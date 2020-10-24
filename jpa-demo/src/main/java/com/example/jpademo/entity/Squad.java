package com.example.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "squad")
public class Squad extends BaseEntity {

	@Builder
	public Squad(Long id, String name, List<Member> members) {
		super(id, name);
		this.members = members;
	}

	@ManyToOne
	@JoinColumn(name = "tribe_id")
	@JsonIgnore
	private Tribe tribe;

	@OneToMany(mappedBy = "squad", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
	private List<Member> members = new ArrayList<>();
}
