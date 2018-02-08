--liquibase formatted sql
--changeset dima:dima_02_create_posts_table

CREATE TABLE my_schema.posts(
  p_uuid VARCHAR(32) NOT NULL UNIQUE ,
  p_message text NOT NULL ,
  p_likes INTEGER DEFAULT 0 ,
  p_user_id INTEGER REFERENCES my_schema.users(u_id) ,
  p_created_at TIMESTAMP DEFAULT NOW() ,
  p_updated_at TIMESTAMP DEFAULT NOW() ,
  CONSTRAINT posts_pk PRIMARY KEY (p_uuid)
);

--rollback DROP TABLE IF EXISTS my_schema.posts CASCADE;
