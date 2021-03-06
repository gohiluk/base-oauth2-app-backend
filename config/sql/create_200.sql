CREATE TABLE CAR (
  id NUMBER NOT NULL PRIMARY KEY,
  user_id NUMBER NOT NULL,
  name VARCHAR(50) NOT NULL,
  picture BLOB,
  mileage NUMBER(10,2) DEFAULT 0,
  FOREIGN KEY (user_id) REFERENCES USERS (id)
 );

CREATE SEQUENCE CAR_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

CREATE TABLE SERVICE (
  id NUMBER NOT NULL PRIMARY KEY,
  car_id NUMBER NOT NULL,
  description VARCHAR(50),
  price NUMBER(5,2),
  mileage NUMBER(10,2),
  service_date DATE,
  picture BLOB,
  FOREIGN KEY (car_id) REFERENCES CAR (id)
 );

CREATE SEQUENCE SERVICE_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;

