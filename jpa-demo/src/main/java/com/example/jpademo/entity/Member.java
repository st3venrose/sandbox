package com.example.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
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
