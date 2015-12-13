CREATE TABLE USERS (
  id NUMBER NOT NULL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(50),
  password VARCHAR(500),
  activated NUMBER(1) DEFAULT 0,
  activationkey VARCHAR(50) DEFAULT NULL,
  resetpasswordkey VARCHAR(50) DEFAULT NULL.
  CONSTRAINT usersUniqueConstraint UNIQUE(username,email)
 );

CREATE SEQUENCE USERS_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE authority (
  id NUMBER NOT NULL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  CONSTRAINT authorityUniqueConstraint UNIQUE(name)
 );

CREATE SEQUENCE AUTHORITY_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

  CREATE TABLE user_authority (
   user_id NUMBER NOT NULL,
   authority_id NUMBER NOT NULL,
   FOREIGN KEY (user_id) REFERENCES users (id),
   FOREIGN KEY (authority_id) REFERENCES authority (id)
 );

  CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL
 );


 CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
 );