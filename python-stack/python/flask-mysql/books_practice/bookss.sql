-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bookslists
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bookslists` ;

-- -----------------------------------------------------
-- Schema bookslists
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bookslists` DEFAULT CHARACTER SET utf8mb3 ;
USE `bookslists` ;

-- -----------------------------------------------------
-- Table `bookslists`.`authors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookslists`.`authors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookslists`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookslists`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `num_of_pages` INT NULL DEFAULT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `bookslists`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bookslists`.`favorites` (
  `book_id` INT NOT NULL,
  `author_id` INT NOT NULL,
  PRIMARY KEY (`book_id`, `author_id`),
  INDEX `fk_books_has_authors_authors1_idx` (`author_id` ASC) VISIBLE,
  INDEX `fk_books_has_authors_books_idx` (`book_id` ASC) VISIBLE,
  CONSTRAINT `fk_books_has_authors_authors1`
    FOREIGN KEY (`author_id`)
    REFERENCES `bookslists`.`authors` (`id`),
  CONSTRAINT `fk_books_has_authors_books`
    FOREIGN KEY (`book_id`)
    REFERENCES `bookslists`.`books` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
