--liquibase formatted sql
--changeset dima:dima_01_create_core_tables

CREATE TABLE my_schema.statuses (
  st_id SERIAL PRIMARY KEY ,
  st_code VARCHAR(32) NOT NULL UNIQUE ,
  st_description text NOT NULL ,
  st_created_at TIMESTAMP DEFAULT NOW() ,
  st_updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE my_schema.areas (
  ar_id SERIAL PRIMARY KEY ,
  ar_code VARCHAR(32) NOT NULL UNIQUE ,
  ar_description text NOT NULL ,
  ar_count INTEGER NOT NULL ,
  ar_created_at TIMESTAMP DEFAULT NOW() ,
  ar_updated_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE my_schema.users(
  u_id SERIAL PRIMARY KEY ,
  u_name VARCHAR(32) NOT NULL UNIQUE ,
  u_email VARCHAR(128) NOT NULL UNIQUE ,
  u_address text ,
  u_age INTEGER ,
  u_sex BOOLEAN ,
  u_status INTEGER REFERENCES my_schema.statuses(st_id) ,
  u_is_enabled BOOLEAN DEFAULT TRUE ,
  u_created_at TIMESTAMP DEFAULT NOW() ,
  u_updated_at TIMESTAMP DEFAULT NOW()
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
