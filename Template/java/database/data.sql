BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


--populate courses table
INSERT INTO courses (course_name) VALUES ('Golf Club of Dublin');
INSERT INTO courses (course_name) VALUES ('Bent Tree');
INSERT INTO courses (course_name) VALUES ('Clover Valley');
INSERT INTO courses (course_name) VALUES ('Glenross');
INSERT INTO courses (course_name) VALUES ('New Albany Links');
INSERT INTO courses (course_name) VALUES ('Royal American');
INSERT INTO courses (course_name) VALUES ('Airport');
INSERT INTO courses (course_name) VALUES ('Champions');
INSERT INTO courses (course_name) VALUES ('Mentel Memorial');
INSERT INTO courses (course_name) VALUES ('Raymond Memorial');
INSERT INTO courses (course_name) VALUES ('Wilson Road');
INSERT INTO courses (course_name) VALUES ('Turnberry');
INSERT INTO courses (course_name) VALUES ('Cumberland Trail');
INSERT INTO courses (course_name) VALUES ('Deleware Golf Club');
INSERT INTO courses (course_name) VALUES ('Safari Golf Club');


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
INSERT INTO links (link_url, course_id) VALUES ('https://foreupsoftware.com/index.php/booking/22036/9668#/teetimes', 15);






COMMIT TRANSACTION;
