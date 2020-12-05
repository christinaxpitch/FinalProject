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
  `profile_pic` VARCHAR(5000) NULL,
  `climbing_since` INT NULL,
  `goals` VARCHAR(200) NULL,
  `availability` VARCHAR(400) NULL,
  `created_at` DATETIME NULL,
  `last_login` DATETIME NULL,
  `other_hobbies` VARCHAR(150) NULL,
  `birthdate` DATE NULL,
  `password` VARCHAR(200) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `climb_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `climb_type` ;

CREATE TABLE IF NOT EXISTS `climb_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(50) NULL,
  `description` VARCHAR(5000) NULL,
  `img_url` VARCHAR(5000) NULL,
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
  `street_address` VARCHAR(45) NULL,
  `hike_to_access` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  INDEX `fk_location_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_location_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
  `description` VARCHAR(5000) NULL,
  `img_url` VARCHAR(5000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_climbing_area_location_idx` (`location_id` ASC),
  CONSTRAINT `fk_climbing_area_location`
    FOREIGN KEY (`location_id`)
    REFERENCES `location` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `event` ;

CREATE TABLE IF NOT EXISTS `event` (
  `id` INT NOT NULL,
  `event_name` VARCHAR(100) NOT NULL,
  `description` TEXT NULL,
  `img_url` VARCHAR(5000) NULL,
  `climbing_area_id` INT NOT NULL,
  `event_date` DATETIME NOT NULL,
  `user_id` INT NOT NULL,
  `created_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_events_climbing_area1_idx` (`climbing_area_id` ASC),
  INDEX `fk_event_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_events_climbing_area1`
    FOREIGN KEY (`climbing_area_id`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_event_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
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
  `created_at` DATETIME NULL,
  `sender_id` INT NOT NULL,
  `receiver_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_message_user1_idx` (`sender_id` ASC),
  INDEX `fk_message_user2_idx` (`receiver_id` ASC),
  CONSTRAINT `fk_message_user1`
    FOREIGN KEY (`sender_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_user2`
    FOREIGN KEY (`receiver_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gear`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gear` ;

CREATE TABLE IF NOT EXISTS `gear` (
  `id` INT NOT NULL,
  `name` VARCHAR(1000) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_gear_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_gear_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_event`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_event` ;

CREATE TABLE IF NOT EXISTS `user_has_event` (
  `user_id` INT NOT NULL,
  `event_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `event_id`),
  INDEX `fk_user_has_events_events1_idx` (`event_id` ASC),
  INDEX `fk_user_has_events_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_events_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_events_events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `event` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_user` ;

CREATE TABLE IF NOT EXISTS `favorite_user` (
  `user_id` INT NOT NULL,
  `favorite_user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `favorite_user_id`),
  INDEX `fk_user_has_user_user2_idx` (`favorite_user_id` ASC),
  INDEX `fk_user_has_user_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_user_user2`
    FOREIGN KEY (`favorite_user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_climb_type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_climb_type` ;

CREATE TABLE IF NOT EXISTS `user_climb_type` (
  `user_id` INT NOT NULL,
  `climb_type_id` INT NOT NULL,
  `recent_grade` VARCHAR(20) NULL,
  `lead_climb` TINYINT(1) NULL DEFAULT 1,
  PRIMARY KEY (`user_id`, `climb_type_id`),
  INDEX `fk_user_has_climb_type_climb_type1_idx` (`climb_type_id` ASC),
  INDEX `fk_user_has_climb_type_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_climb_type_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_climb_type_climb_type1`
    FOREIGN KEY (`climb_type_id`)
    REFERENCES `climb_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `favorite_area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `favorite_area` ;

CREATE TABLE IF NOT EXISTS `favorite_area` (
  `user_id` INT NOT NULL,
  `climbing_area_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `climbing_area_id`),
  INDEX `fk_user_has_climbing_area_climbing_area1_idx` (`climbing_area_id` ASC),
  INDEX `fk_user_has_climbing_area_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_climbing_area_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_climbing_area_climbing_area1`
    FOREIGN KEY (`climbing_area_id`)
    REFERENCES `climbing_area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `media`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `media` ;

CREATE TABLE IF NOT EXISTS `media` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `media_url` VARCHAR(5000) NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_media_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_media_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
INSERT INTO `user` (`id`, `first_name`, `last_name`, `username`, `favorite_beer`, `has_dog`, `profile_pic`, `climbing_since`, `goals`, `availability`, `created_at`, `last_login`, `other_hobbies`, `birthdate`, `password`) VALUES (1, 'Timothy ', 'Laughlin', 'shakawithme', 'pink wine', 1, NULL, 2012, 'I am trying to climb once a week. Indoors or outdoors.', 'Sundays', NULL, NULL, 'Reading sci fi books, dancing to boy bands, and cooking spaghettios.', '1991-01-13', 'cooper');

COMMIT;


-- -----------------------------------------------------
-- Data for table `climb_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `climb_type` (`id`, `name`, `description`, `img_url`) VALUES (1, 'sport', 'Sport climbing is a form of rock climbing that may rely on permanent anchors fixed to the rock for protection, in which a rope that is attached to the climber is clipped into the anchors to arrest a fall, or that involves climbing short distances with a crash pad underneath as protection', 'https://uploads-ssl.webflow.com/5732511283fb5b4c17492b27/597926a1ed093500015cd8ab_FL_Mirsky_Rifle.png');

COMMIT;


-- -----------------------------------------------------
-- Data for table `location`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `location` (`id`, `city`, `state`, `zip`, `user_id`, `street_address`, `hike_to_access`) VALUES (1, 'Boulder', 'CO', 80302, 1, 'Gregory Canyon Trailhead, Gregory Canyon Rd', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `climbing_area`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `climbing_area` (`id`, `name`, `location_id`, `description`, `img_url`) VALUES (1, 'Gregory Canyon', 1, 'This is the northern-most section of the the Flatirons which may be lumped together to help you find your way here. Included in the area is the better known Amphitheatre and some of the less-well known crags here (like 3rd, 4th, 5th pinnacles). Apparently, according to Rossiter, there is even a granite crag in this canyon. One route from this canyon even made the cover shot of a Boulder non-climber publication.\n\nSome shade can be found at some of the crags for those seeking cooler cragging in the hotter months. None of these routes are long here.\n\nAccess can be most readily obtained by parking in or near the Gregory Canyon Trailhead. Parking is popular here and, as a result, limited. Note, parking here does cost for non-Boulder County registered vehicles. 2006 was still $3/day and $25/year. However, street parking nearby and parking at Chataqua (0.6 mi) is free.\n\nAlso, for those wandering around with little kids, this is bear and mountain lion territory. Be careful.\n\nThere is also significant poison ivy in the area for the sensitive.', 'https://cdn2.apstatic.com/photos/climb/111418381_medium_1494361874_topo.jpg');

COMMIT;


-- -----------------------------------------------------
-- Data for table `event`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `event` (`id`, `event_name`, `description`, `img_url`, `climbing_area_id`, `event_date`, `user_id`, `created_at`) VALUES (1, 'Crags and Brews', 'A saturday morning group climb in Gregory Canyon. Post climb cooldown at Avery Brewery Company!', NULL, 1, '2021-05-01 08:30:00', 1, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `gear`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `gear` (`id`, `name`, `user_id`) VALUES (1, 'Grigri, 9.5mm Rope, chalk, helmet, 10 quickdraws, 120 cm sling, 5 locking carabiners, crash pad', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_climb_type`
-- -----------------------------------------------------
START TRANSACTION;
USE `cragdb`;
INSERT INTO `user_climb_type` (`user_id`, `climb_type_id`, `recent_grade`, `lead_climb`) VALUES (1, 1, '5.11a', 1);

COMMIT;
