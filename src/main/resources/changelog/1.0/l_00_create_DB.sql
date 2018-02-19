CREATE role prod_user_role;
ALTER role prod_user_role PASSWORD 'prod_pass';
--
CREATE DATABASE prod_db WITH OWNER prod_user_role;
Alter user prod_user_role with superuser login;
--
CREATE SCHEMA my_schema;
ALTER SCHEMA my_schema OWNER TO prod_user_role;