CREATE TABLE batch_master
(
  batch_id serial NOT NULL,
  passout_year numeric(4,0),
  course_id numeric(11,0),
  CONSTRAINT batch_master_pkey PRIMARY KEY (batch_id)
);
CREATE TABLE course_master
(
  course_id serial NOT NULL,
  abbr character(20),
  title character(50),
  CONSTRAINT course_master_pkey PRIMARY KEY (course_id)
);

CREATE TABLE customer_master
(
  customer_id serial NOT NULL,
  title character(50),
  address character(50),
  CONSTRAINT customer_master_pkey PRIMARY KEY (customer_id)
);

CREATE TABLE event_master
(
  event_id serial NOT NULL,
  event_name character varying(255),
  event_description character varying(255),
  event_year numeric(4,0),
  CONSTRAINT event_master_pkey PRIMARY KEY (event_id)
);
CREATE TABLE participant_master
(
  participant_id serial NOT NULL,
  event_id numeric(11,0),
  student_id numeric(11,0),
  batch_id numeric(11,0),
  course_id numeric(11,0),
  CONSTRAINT participant_master_pkey PRIMARY KEY (participant_id)
);
CREATE TABLE qualification
(
  entry_id serial NOT NULL,
  qualification character(50),
  percentage numeric(3,2),
  institute character(50),
  university character(50),
  description character(50),
  student_id numeric(11,0),
  CONSTRAINT qualifications_pkey PRIMARY KEY (entry_id)
);
CREATE TABLE staff_master
(
  staff_id serial NOT NULL,
  fname character(50),
  lname character(50),
  designation character(50),
  email character(50),
  phone character(25),
  user_id numeric(11,0),
  CONSTRAINT staff_master_pkey PRIMARY KEY (staff_id)
);
CREATE TABLE student_master
(
  student_id serial NOT NULL,
  fname character(50),
  lname character(50),
  phone character(25),
  email character(50),
  temporary_address character(200),
  permenant_address character(200),
  user_id numeric(11,0),
  batch_id numeric(11,0),
  CONSTRAINT student_master_pkey PRIMARY KEY (student_id)
);

CREATE TABLE user_master
(
  user_id serial NOT NULL,
  ufname character(50),
  ulname character(50),
  uname character(50),
  pwd character(50),
  customer_id numeric(10),
  CONSTRAINT user_master_pkey PRIMARY KEY (user_id)
);

CREATE TABLE work_experience
(
  entry_id serial NOT NULL,
  organization character(200),
  designation character(50),
  role_description character(200),
  months numeric(2,0),
  years numeric(2,0),
  student_id numeric(11,0) NOT NULL,
  CONSTRAINT work_experience_pkey PRIMARY KEY (student_id)
);