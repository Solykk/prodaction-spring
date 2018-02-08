--liquibase formatted sql
--changeset dima:dima_01_create_core_tables

CREATE TABLE my_schema.additional_information(
  ai_id SERIAL NOT NULL ,
  ai_address text ,
  ai_age INTEGER ,
  ai_sex BOOLEAN ,
  ai_created_at TIMESTAMP DEFAULT NOW() ,
  ai_updated_at TIMESTAMP DEFAULT NOW() ,
  CONSTRAINT additional_information_pk PRIMARY KEY (ai_id)
);

CREATE TABLE my_schema.statuses (
  st_id SERIAL NOT NULL ,
  st_code VARCHAR(32) NOT NULL ,
  st_description text NOT NULL ,
  st_created_at TIMESTAMP DEFAULT NOW() ,
  st_updated_at TIMESTAMP DEFAULT NOW() ,
  CONSTRAINT statuses_pk PRIMARY KEY (st_id) ,
  CONSTRAINT statuses_code_key UNIQUE (st_code)
);

CREATE TABLE my_schema.areas (
  ar_id SERIAL NOT NULL ,
  ar_code VARCHAR(32) NOT NULL ,
  ar_description text NOT NULL ,
  ar_count INTEGER NOT NULL ,
  ar_created_at TIMESTAMP DEFAULT NOW() ,
  ar_updated_at TIMESTAMP DEFAULT NOW() ,
  CONSTRAINT areas_pk PRIMARY KEY (ar_id) ,
  CONSTRAINT areas_code_key UNIQUE (ar_code)
);

CREATE TABLE my_schema.users(
  u_id SERIAL NOT NULL ,
  u_name VARCHAR(32) NOT NULL ,
  u_email VARCHAR(128) NOT NULL ,
  u_status INTEGER REFERENCES my_schema.statuses(st_id) ,
  u_is_enabled BOOLEAN DEFAULT TRUE ,
  u_additional_information_id INTEGER REFERENCES my_schema.additional_information(ai_id) ,
  u_created_at TIMESTAMP DEFAULT NOW() ,
  u_updated_at TIMESTAMP DEFAULT NOW() ,
  CONSTRAINT users_pk PRIMARY KEY (u_id) ,
  CONSTRAINT users_name_key UNIQUE (u_name) ,
  CONSTRAINT users_email_key UNIQUE (u_email)
);

CREATE TABLE my_schema.user_areas(
  user_id INTEGER REFERENCES my_schema.users(u_id) ,
  area_id INTEGER REFERENCES my_schema.areas(ar_id)
);

CREATE TABLE my_schema.user_friends(
  user_id INTEGER REFERENCES my_schema.users(u_id) ,
  user_friend_id INTEGER REFERENCES my_schema.users(u_id)
);

--rollback DROP TABLE IF EXISTS my_schema.user_friends CASCADE;
--rollback DROP TABLE IF EXISTS my_schema.user_areas CASCADE;
--rollback DROP TABLE IF EXISTS my_schema.users CASCADE;
--rollback DROP TABLE IF EXISTS my_schema.areas CASCADE;
--rollback DROP TABLE IF EXISTS my_schema.statuses CASCADE;
--rollback DROP TABLE IF EXISTS my_schema.additional_information CASCADE;
