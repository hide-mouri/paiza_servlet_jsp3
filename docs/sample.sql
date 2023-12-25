CREATE SCHEMA `mydb` ;

CREATE TABLE players (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(32),
  level INT,
  jobId INT
);

CREATE TABLE jobs (
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  jobName VARCHAR(10),
  vitality INT,
  strength INT,
  agility INT,
  intelligence INT,
  luck INT
);

INSERT INTO players(name,level,jobId)
VALUES
  ("Java",12,6),
  ("ケン",7,2),
  ("リン",1,1),
  ("ユウ",3,3),
  ("クレア",10,4),
  ("ショウ",5,2),
  ("さくら",7,1),
  ("ジャック",5,4),
  ("ロック",12,6),
  ("じゅん",1,NULL);

INSERT INTO jobs(jobName, vitality, strength, agility, intelligence, luck)
VALUES
  ("戦士",8,8,4,4,3),
  ("盗賊",3,3,8,5,7),
  ("狩人",5,5,7,5,4),
  ("魔法使い",3,2,6,8,6),
  ("僧侶",5,5,3,7,5),
  ("勇者",10,10,10,10,10);
