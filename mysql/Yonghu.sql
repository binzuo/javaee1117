CREATE DATABASE IF NOT EXISTS Yonghu;
DROP TABLE IF EXISTS Yonghu.message;
CREATE TABLE Yonghu.message(
  id INT AUTO_INCREMENT PRIMARY KEY ,
  email VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  cities VARCHAR(255),
  hobbies VARCHAR(255)
)COMMENT '用户信息表';
SELECT *
FROM Yonghu.message;
DROP TABLE IF EXISTS Yonghu.book;
CREATE TABLE Yonghu.book(
  id      INT AUTO_INCREMENT PRIMARY KEY,
  title   VARCHAR(255) COMMENT '',
  author  VARCHAR(255) COMMENT '',
  publish VARCHAR(255) COMMENT '',
  date    DATE COMMENT '',
  price   DECIMAL(5,2) COMMENT '',
  amount  INT COMMENT ''
);
SELECT *
FROM Yonghu.book;

SELECT *
FROM Yonghu.message;
