-- INSERT tribe
insert into tribe(name) values('tribe_1');

-- INSERT squad
insert into squad(name, tribe_id) values('squad_1', 1);

-- INSERT member
insert into member(name, squad_id) values('member_1', 1);
insert into member(name, squad_id) values('member_2', 1);

