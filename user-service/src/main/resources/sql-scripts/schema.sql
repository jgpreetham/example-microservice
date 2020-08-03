CREATE TABLE USER_DETAILS (
  USER_ID bigint(20) NOT NULL AUTO_INCREMENT,
  TITLE varchar(255) NOT NULL,
  FIRST_NAME varchar(255) NOT NULL,
  LAST_NAME varchar(255) NOT NULL,
  GENDER varchar(255) NOT NULL,
  STREET varchar(255) NOT NULL,
  CITY varchar(255) NOT NULL,
  STATE varchar(255) NOT NULL,
  POSTCODE varchar(255) NOT NULL,
  PRIMARY KEY (USER_ID)
);