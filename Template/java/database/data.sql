BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--populate team table
INSERT INTO teams (name) VALUES ('Java Juggernauts');

--populate players table
INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Derek', 'Jeter', 2, 220000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190470/1_cxwinb.webp');

INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Mariano', 'Rivera', 42, 150000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/2_hqe0ky.webp');

INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Alex', 'Rodriguez', 13, 250000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/3_mgphn7.webp');

INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Kelly', 'Johnson', 3, 1991000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/5_dm97cw.webp');

INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Babe', 'Ruth', 4, 800000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/6_mdkfoj.webp');

INSERT INTO players (firstName, lastName, jerseyNumber, salary, team_id, image_url) VALUES ('Natalie', 'Smith', 19, 1800000.00, 1, 'https://res.cloudinary.com/drr6cwmiz/image/upload/v1701190469/7_omvz9t.webp');


--populate positions
INSERT INTO positions (positionName) VALUES ('Pitcher');
INSERT INTO positions (positionName) VALUES ('Catcher');
INSERT INTO positions (positionName) VALUES ('First Baseman');
INSERT INTO positions (positionName) VALUES ('Second Baseman');
INSERT INTO positions (positionName) VALUES ('Shortstop');
INSERT INTO positions (positionName) VALUES ('Third Baseman');
INSERT INTO positions (positionName) VALUES ('Outfielder');
INSERT INTO positions (positionName) VALUES ('Designated Hitter');
INSERT INTO positions (positionName) VALUES ('Relief Pitcher');


-- Link player 1 to position 1 (Pitcher)
INSERT INTO player_position (player_id, position_id) VALUES (1, 1);

-- Link player 2 to position 2 (Catcher)
INSERT INTO player_position (player_id, position_id) VALUES (2, 2);

-- Link player 3 to position 3 (First Baseman)
INSERT INTO player_position (player_id, position_id) VALUES (3, 3);

-- Link player 4 to position 4 (Second Baseman)
INSERT INTO player_position (player_id, position_id) VALUES (4, 4);

-- Link player 5 to position 5 (Shortstop)
INSERT INTO player_position (player_id, position_id) VALUES (5, 5);

-- Link player 5 to position 5 (Outfielder)
INSERT INTO player_position (player_id, position_id) VALUES (6, 7);


COMMIT TRANSACTION;
