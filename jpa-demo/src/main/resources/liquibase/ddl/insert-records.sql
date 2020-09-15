-- INSERT tribe
insert into tribe(name) values('tribe_1');

-- INSERT squads
insert into squad(name, tribe_id) values('squad_1', 1);
insert into squad(name, tribe_id) values('squad_2', 1);

-- INSERT members
insert into member(name, squad_id) values('member_1', 1);
insert into member(name, squad_id) values('member_2', 1);
