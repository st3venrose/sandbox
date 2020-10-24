package com.example.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member")
public class Member extends BaseEntity {

	@Builder
	public Member(Long id, String name) {
		super(id, name);
	}

	@ManyToOne
	@JoinColumn(name = "squad_id")
	@JsonIgnore
	private Squad squad;
}
