-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cragdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cragdb` ;

-- -----------------------------------------------------
-- Schema cragdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cragdb` DEFAULT CHARACTER SET utf8 ;
USE `cragdb` ;

-- -----------------------------------------------------
-- Table `skill_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill_level` ;

CREATE TABLE IF NOT EXISTS `skill_level` (
  `id` INT NOT NULL,
  `lead_climb` TINYINT(1) NOT NULL DEFAULT 1,
  `recent_grade` VARCHAR(20) NOT NULL,
  `climbing_type_id` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gear`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gear` ;

CREATE TABLE IF NOT EXISTS `gear` (
  `id` INT NOT NULL,
  `name` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(16) NOT NULL,
  `favorite_beer` VARCHAR(45) NULL,
  `has_dog` TINYINT(1) NULL DEFAULT 1,
  `profile_pic` VARCHAR(100) NULL,
  `other_pics` VARCHAR(1400) NULL,
  `climbing_since` INT NULL,
  `goals` VARCHAR(200) NULL,
  `availability` VARCHAR(400) NULL,
  `created_at` DATETIME NULL,
  `last_login` DATETIME NULL,
  `skill_level_id` INT NULL,
  `gear_id` INT NULL,
  `other_hobbies` VARCHAR(150) NULL,
  `age` INT NULL,
  `password` VARCHAR(200) NULL,
  `security_answer` VARCHAR(45) NULL,
  `security_answer1` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_skill_level_idx` (`skill_level_id` ASC),
  INDEX `fk_user_gear1_idx` (`gear_id` ASC),
  CONSTRAINT `fk_user_skill_level`
    FOREIGN KEY (`skill_level_id`)
    REFERENCES `skill_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_gear1`
    FOREIGN KEY (`gear_id`)
    REFERENCES `gear` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `climbing_area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `climbing_area` ;

CREATE TABLE IF NOT EXISTS `climbing_area` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location_id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `location` ;

CREATE TABLE IF NOT EXISTS `location` (
  `id` INT NOT NULL,
  `city` VARCHAR(45) NULL,
  `state` CHAR(2) NULL,
  `zip` INT NULL,
  `user_id` INT NOT NULL,
  `climbing_area_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_location_user1_idx` (`user_id` ASC),
  INDEX `fk_location_climbing_area1_idx` (`climbing_area_id` ASC),
  CONSTRAINT `fk_location_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_location_climbing_area1`
    FOREIGN KEY (`climbing_area_id`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `events` ;

CREATE TABLE IF NOT EXISTS `events` (
  `id` INT NOT NULL,
  `event_name` VARCHAR(100) NOT NULL,
  `climbing_area_id` INT NOT NULL,
  `description` VARCHAR(300) NULL,
  `photo` VARCHAR(300) NULL,
  `location_id` INT NOT NULL,
  `climbing_area_id1` INT NOT NULL,
  `event_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`, `location_id`, `climbing_area_id1`),
  INDEX `fk_events_location1_idx` (`location_id` ASC),
  INDEX `fk_events_climbing_area1_idx` (`climbing_area_id1` ASC),
  CONSTRAINT `fk_events_location1`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_events_climbing_area1`
    FOREIGN KEY (`climbing_area_id1`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `message` ;

CREATE TABLE IF NOT EXISTS `message` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message_body` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorited_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorited_user` ;

CREATE TABLE IF NOT EXISTS `favorited_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorited_area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorited_area` ;

CREATE TABLE IF NOT EXISTS `favorited_area` (
  `id` INT NOT NULL,
  `enabled` TINYINT(1) NULL,
  `climbing_area_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_favorite_area_climbing_area1_idx` (`climbing_area_id` ASC),
  CONSTRAINT `fk_favorite_area_climbing_area1`
    FOREIGN KEY (`climbing_area_id`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_message`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_message` ;

CREATE TABLE IF NOT EXISTS `user_has_message` (
  `user_id` INT NOT NULL,
  `message_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `message_id`),
  INDEX `fk_user_has_message_message1_idx` (`message_id` ASC),
  INDEX `fk_user_has_message_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_message_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_message_message1`
    FOREIGN KEY (`message_id`)
    REFERENCES `message` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_favorite_area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_favorite_area` ;

CREATE TABLE IF NOT EXISTS `user_has_favorite_area` (
  `user_id` INT NOT NULL,
  `favorite_area_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `favorite_area_id`),
  INDEX `fk_user_has_favorite_area_favorite_area1_idx` (`favorite_area_id` ASC),
  INDEX `fk_user_has_favorite_area_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_favorite_area_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_favorite_area_favorite_area1`
    FOREIGN KEY (`favorite_area_id`)
    REFERENCES `favorited_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_favorite_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_favorite_user` ;

CREATE TABLE IF NOT EXISTS `user_has_favorite_user` (
  `user_id` INT NOT NULL,
  `favorite_user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `favorite_user_id`),
  INDEX `fk_user_has_favorite_user_favorite_user1_idx` (`favorite_user_id` ASC),
  INDEX `fk_user_has_favorite_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_favorite_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_favorite_user_favorite_user1`
    FOREIGN KEY (`favorite_user_id`)
    REFERENCES `favorited_user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_events`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_events` ;

CREATE TABLE IF NOT EXISTS `user_has_events` (
  `user_id` INT NOT NULL,
  `events_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `events_id`),
  INDEX `fk_user_has_events_events1_idx` (`events_id` ASC),
  INDEX `fk_user_has_events_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_events_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_events_events1`
    FOREIGN KEY (`events_id`)
    REFERENCES `events` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `climbing_area_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `climbing_area_has_user` ;

CREATE TABLE IF NOT EXISTS `climbing_area_has_user` (
  `climbing_area_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`climbing_area_id`, `user_id`),
  INDEX `fk_climbing_area_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_climbing_area_has_user_climbing_area1_idx` (`climbing_area_id` ASC),
  CONSTRAINT `fk_climbing_area_has_user_climbing_area1`
    FOREIGN KEY (`climbing_area_id`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_climbing_area_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `password_recovery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `password_recovery` ;

CREATE TABLE IF NOT EXISTS `password_recovery` (
  `id` INT NOT NULL,
  `security_quesiton` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO crag@localhost;
 DROP USER crag@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'crag'@'localhost' IDENTIFIED BY 'crag';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'crag'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `favorite_beer`, `has_dog`, `profile_pic`, `other_pics`, `climbing_since`, `goals`, `availability`, `created_at`, `last_login`, `skill_level_id`, `gear_id`, `other_hobbies`, `age`, `password`, `security_answer`, `security_answer1`) VALUES (1, 'Timothy ', 'Laughlin', 'shakawithme', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;
