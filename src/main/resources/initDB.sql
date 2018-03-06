USE hibernate;


CREATE TABLE skills (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE developers (
  id INT NOT NULL AUTO_INCREMENT,
  firstName varchar(255) NOT NULL,
  lastName varchar(255) NOT NULL,
  specialty varchar(255) NOT NULL,
  salary decimal(10,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE teams (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE projects (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE companies (
  id INT NOT NULL AUTO_INCREMENT,
  name varchar(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE customers (
  id INT NOT NULL AUTO_INCREMENT,
  firstName varchar(225) NOT NULL,
  lastName varchar(225) NOT NULL,
  address varchar(225) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE developer_skills (
  dev_id INT NOT NULL,
  skill_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE team_developers (
  team_id INT NOT NULL,
  dev_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE project_teams (
  project_id INT NOT NULL,
  team_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE company_projects (
  company_id INT NOT NULL,
  project_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE customer_projects (
  customer_id INT NOT NULL,
  project_id INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;