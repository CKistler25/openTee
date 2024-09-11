BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--populate courses table
INSERT INTO courses (course_name, thumbnail) VALUES ('Golf Club of Dublin', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070339/GCOD_Thumbnail_dqlntu.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Bent Tree', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070135/Bent_Tree_Thumbnail_vdi5hu.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Clover Valley', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069918/Clover_Valley_Thumbnail_iitrbl.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Glenross', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070294/Glenross_Thumbnail_vllvej.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('New Albany Links', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069916/New_Albany_Links_Thumbnail_nrtlrf.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Royal American', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070257/Royal_American_Thumbnail_ij8dqp.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Airport', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070388/Airport_Thumbnail_urqa07.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Champions', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069913/Champions_Thumbnail_qeyy5p.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Mentel Memorial', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069915/Mentel_Memorial_Thumbnail_vrxcsq.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Raymond Memorial', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069917/Raymond_Memorial_Thumbnail_n54afn.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Wilson Road', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069916/Wilson_Road_Thumbnail_amxoua.jpg');
INSERT INTO courses (course_name, thumbnail) VALUES ('Turnberry', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726070195/Turnberry_Thumbnail_dwcfez.jpg');
-- INSERT INTO courses (course_name, thumbnail) VALUES ('Cumberland Trail', );
-- INSERT INTO courses (course_name, thumbnail) VALUES ('Delaware Golf Club', );
INSERT INTO courses (course_name, thumbnail) VALUES ('Safari Golf Club', 'https://res.cloudinary.com/drtlz85pc/image/upload/c_crop,ar_1:1/v1726069913/Safari_Thumbnail_dzfvdg.jpg');


--populate links
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19276/1389#/teetimes', 1);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19275/1391#/teetimes', 2);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19770/2457#/teetimes', 3);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19277/1390#/teetimes', 4);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19278/1376#/teetimes', 5);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/19279/1377#/teetimes', 6);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21528/8164#teetimes', 7);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21523/8148#teetimes', 8);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21527/8209#teetimes', 9);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21526/8135#teetimes', 10);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21525/8204#teetimes', 11);
--INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/21524/8253#/teetimes', 12);
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/22036/9668#/teetimes', 13);






COMMIT TRANSACTION;
