CREATE TABLE Student (
    sno VARCHAR2(9 BYTE) NOT NULL, -- 6/2 * 3 学号
    sname VARCHAR2(12 BYTE) NOT NULL, -- 8/2 * 3 姓名
    ssex  VARCHAR2(3 BYTE) NOT NULL, -- 2/2 * 3 性别
    sbirthday  DATE NOT NULL, -- 出生日期
    speciality  VARCHAR2(18 BYTE), -- 12/2 * 3 专业
    sclass  VARCHAR2(9 BYTE), -- 6/2 * 3 班号
    tc  INT, -- 总学分
    PRIMARY KEY (sno)
);

CREATE TABLE Course (
    cno VARCHAR2(6 BYTE) NOT NULL, -- 4/2 * 3 课程号
    cname VARCHAR2(24 BYTE) NOT NULL, -- 16/2 * 3 课程名
    credit  INT, -- 学分
    tno VARCHAR2(9 BYTE), -- 6/2 * 3 教师编号
    PRIMARY KEY (cno)
);

CREATE TABLE Score (
    sno VARCHAR2(9 BYTE) NOT NULL, -- 6/2 * 3 学号
    cno VARCHAR2(6 BYTE) NOT NULL, -- 4/2 * 3 课程号
    grade  INT, -- 成绩
   PRIMARY KEY (sno,cno)
);

-- select * from Student;
-- select * from Course;
-- select * from Score;

INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0001', 'TEST1', '男', to_date('2018-12-14', 'YYYY-MM-DD') ,'math', '001', 101);
INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0002', 'TEST2', '男', to_date('2018-12-15', 'YYYY-MM-DD') ,'english', '002', '102');
INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0003', 'TEST3', '女', to_date('2018-12-16', 'YYYY-MM-DD') ,'computer', '003', '103');
INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0004', 'TEST4', '女', to_date('2018-12-17', 'YYYY-MM-DD') ,'language', '004', '104');
INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0005', 'TEST5', '女', to_date('2018-12-18', 'YYYY-MM-DD') ,'physical', '005', '105');
INSERT INTO Student (sno, sname, ssex, sbirthday, speciality, sclass, tc) VALUES ('0006', 'TEST6', '女', to_date('2018-12-19', 'YYYY-MM-DD') ,'music', '006', '106');

INSERT INTO Course (cno, cname, credit, tno) VALUES ('C01', 'CN-01', '1', 'T001');
INSERT INTO Course (cno, cname, credit, tno) VALUES ('C02', 'CN-02', '2', 'T002');
INSERT INTO Course (cno, cname, credit, tno) VALUES ('C03', 'CN-03', '3', 'T003');
INSERT INTO Course (cno, cname, credit, tno) VALUES ('C04', 'CN-04', '4', 'T004');
INSERT INTO Course (cno, cname, credit, tno) VALUES ('C05', 'CN-05', '5', 'T005');

INSERT INTO Score (sno, cno, grade) VALUES ('0001', 'C01', '61');
INSERT INTO Score (sno, cno, grade) VALUES ('0002', 'C02', '62');
INSERT INTO Score (sno, cno, grade) VALUES ('0003', 'C03', '63');
INSERT INTO Score (sno, cno, grade) VALUES ('0004', 'C04', '64');
INSERT INTO Score (sno, cno, grade) VALUES ('0005', 'C05', '65');