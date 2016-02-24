SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `uengine`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_unicode_ci;
USE `uengine`;

-- -----------------------------------------------------
-- Table `uengine`.`jira_client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS uengine.jira_client (
  id                       INT(11)      NOT NULL AUTO_INCREMENT,
  addonkey                 VARCHAR(255) NOT NULL,
  clientkey                VARCHAR(255) NOT NULL,
  publickey                VARCHAR(255) NOT NULL,
  sharedsecret             VARCHAR(255) NOT NULL,
  serverversion            VARCHAR(255)          DEFAULT NULL,
  pluginsversion           VARCHAR(255)          DEFAULT NULL,
  baseurl                  VARCHAR(255)          DEFAULT NULL,
  producttype              VARCHAR(255)          DEFAULT NULL,
  description              VARCHAR(255)          DEFAULT NULL,
  serviceentitlementnumber VARCHAR(255)          DEFAULT NULL,
  status                   VARCHAR(255)          DEFAULT NULL,
  PRIMARY KEY (ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table `uengine`.`jira_client_lifecycle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS uengine.jira_client_lifecycle (
  id             INT(11) NOT NULL AUTO_INCREMENT,
  jira_client_id INT(11) NOT NULL,
  eventdate      TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
  eventtype      VARCHAR(255)     DEFAULT 'installed',
  payload        LONGTEXT,
  PRIMARY KEY (ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table `uengine`.`jira_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS uengine.jira_project (
  id             INT(11)      NOT NULL AUTO_INCREMENT,
  instance_id    INT(11)      NOT NULL,
  jira_client_id INT(11)      NOT NULL,
  project_id     VARCHAR(255) NOT NULL,
  initiator      VARCHAR(255) NOT NULL,
  reg_dt         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- -----------------------------------------------------
-- Table `uengine`.`jira_issue`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS uengine.jira_issue (
  id             INT(11)      NOT NULL AUTO_INCREMENT,
  instance_id    INT(11)      NOT NULL,
  tracing_tag    INT(11)      NOT NULL,
  jira_client_id INT(11)      NOT NULL,
  project_id     VARCHAR(255) NOT NULL,
  issue_id       VARCHAR(255) NOT NULL,
  reg_dt         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (ID)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;