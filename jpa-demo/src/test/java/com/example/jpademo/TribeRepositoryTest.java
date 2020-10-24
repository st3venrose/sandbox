package com.example.jpademo;

import com.example.jpademo.entity.Member;
import com.example.jpademo.entity.Squad;
import com.example.jpademo.entity.Tribe;
import com.example.jpademo.repository.TribeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@TestPropertySource(properties = {
		"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
public class TribeRepositoryTest {

	private static final String TRIBE_NAME = "tribe_1";
	private static final String SQUAD_NAME = "squad_1";
	private static final String MEMBER_NAME = "member_1";
	private static final Long ID_1 = 1l;
	private static final Long ID_2 = 2l;

	@Autowired
	private TribeRepository tribeRepository;

	private Tribe tribe;

	@BeforeEach
	void setUp() {
		Member member = Member.builder().name(MEMBER_NAME).build();
		Squad squad = Squad.builder().name(SQUAD_NAME).members(List.of(member, member)).build();
		tribe = Tribe.builder().name(TRIBE_NAME)
				.squads(List.of(squad, squad))
				.build();
	}

	@Test
	public void saveTribeTest() {
		Tribe savedTribe = tribeRepository.save(tribe);

		assertNotNull(savedTribe);
		assertEquals(2, savedTribe.getSquads().size());
		assertEquals(2, savedTribe.getSquads().get(0).getMembers().size());
	}


	@Test
	@Sql("/test-data.sql")
	public void listTribeTest() {
		Tribe foundedTribe = tribeRepository.findById(ID_1).get();

		assertNotNull(foundedTribe);
		assertEquals(TRIBE_NAME, foundedTribe.getName());
		assertEquals(1, foundedTribe.getSquads().size());
		assertEquals(2, foundedTribe.getSquads().get(0).getMembers().size());
		assertEquals(ID_1, foundedTribe.getSquads().get(0).getMembers().get(0).getId());
		assertEquals(ID_2, foundedTribe.getSquads().get(0).getMembers().get(1).getId());
	}
}
