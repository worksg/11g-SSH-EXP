CREATE DATABASE `studev` /*!40100 COLLATE 'utf8mb4_general_ci' */;

USE `studev`;

CREATE TABLE `Student` (
    `sno` VARCHAR(9) NOT NULL, -- 6/2 * 3 学号
    `sname` VARCHAR(12) NOT NULL, -- 8/2 * 3 姓名
    `ssex`  VARCHAR(3) NOT NULL, -- 2/2 * 3 性别
    `sbirthday`  DATE NOT NULL, -- 出生日期
    `speciality`  VARCHAR(18), -- 12/2 * 3 专业
    `sclass`  VARCHAR(9), -- 6/2 * 3 班号
    `tc`  INT, -- 总学分
    PRIMARY KEY (`sno`)
);

CREATE TABLE `Course` (
    `cno` VARCHAR(6) NOT NULL, -- 4/2 * 3 课程号
    `cname` VARCHAR(24) NOT NULL, -- 16/2 * 3 课程名
    `credit`  INT, -- 学分
    `tno` VARCHAR(9), -- 6/2 * 3 教师编号
    PRIMARY KEY (`cno`)
);

CREATE TABLE `Score` (
    `sno` VARCHAR(9) NOT NULL, -- 6/2 * 3 学号
    `cno` VARCHAR(6) NOT NULL, -- 4/2 * 3 课程号
    `grade`  INT, -- 成绩
   PRIMARY KEY (`sno`,`cno`)
);
