CREATE TABLE IF NOT EXISTS tribe (
  id SERIAL,
  name VARCHAR(200) NOT NULL,
  PRIMARY KEY (id));

 CREATE TABLE IF NOT EXISTS squad (
  id SERIAL,
  name VARCHAR(200) NOT NULL,
  tribe_id BIGINT,
  PRIMARY KEY (id),
  CONSTRAINT tribe_id_squad_id_fk FOREIGN KEY (tribe_id) REFERENCES tribe (id));
  
CREATE TABLE IF NOT EXISTS member(
  id SERIAL,
  name VARCHAR(200) NOT NULL,
  squad_id BIGINT,
  PRIMARY KEY(id),
  CONSTRAINT squad_id_member_id_fk FOREIGN KEY (squad_id) REFERENCES squad (id));


CREATE INDEX tribe_id_index ON squad (tribe_id);
CREATE INDEX squad_id_index ON member (squad_id);

