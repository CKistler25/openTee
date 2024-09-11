BEGIN TRANSACTION;

DROP TABLE IF EXISTS courses, links, users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE courses
(
  course_id serial,
  course_name varchar(100) NOT NULL,
  thumbnail varchar(150) NOT NULL,

  constraint pk_course_id primary key (course_id)

);



  CREATE TABLE links
(
   link_id serial,
   link_url varchar(500) NOT NULL,
   course_id int,

   constraint pk_link_id primary key (link_id),
   constraint fk_course_id foreign key (course_id) references courses (course_id)
);





CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
--ROLLBACK;
COMMIT TRANSACTION;