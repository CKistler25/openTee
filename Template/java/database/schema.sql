BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, teams, players, positions, player_position CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

  CREATE TABLE teams
(
   team_id serial,
   name varchar(25) NOT NULL,

   constraint pk_team_id primary key (team_id)
);

CREATE TABLE players
(
  player_id serial,
  firstName varchar(25) NOT NULL,
  lastName varchar(25) NOT NULL,
  jerseyNumber int NOT NULL,
  salary NUMERIC(12,2) NOT NULL,
  team_id int,
  image_url varchar(500),
  
  constraint pk_player_id primary key (player_id),
  constraint fk_team_id foreign key (team_id) references teams (team_id)
 	
);

CREATE TABLE positions 
(
  position_id serial,
  positionName VARCHAR(25),

  constraint pk_position_id primary key (position_id) 
);

CREATE TABLE player_position
(
	player_id int,
    position_id int, 
	
    constraint pk_player_id_position_id primary key (player_id, position_id),
	constraint fk_player_id foreign key (player_id) references players (player_id),
    constraint fk_position_id foreign key (position_id) references positions (position_id)
);


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

COMMIT TRANSACTION;
