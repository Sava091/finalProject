-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema fitnesstracking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fitnesstracking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fitnesstracking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `fitnesstracking` ;

-- -----------------------------------------------------
-- Table `fitnesstracking`.`coefficients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesstracking`.`coefficients` (
  `idCoefficients` INT(11) NOT NULL,
  `coef0` DOUBLE NULL DEFAULT NULL,
  `coef1` DOUBLE NULL DEFAULT NULL,
  `coef2` DOUBLE NULL DEFAULT NULL,
  `coef3` DOUBLE NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  PRIMARY KEY (`idCoefficients`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fitnesstracking`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesstracking`.`clients` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `age` INT(11) NULL DEFAULT NULL,
  `height` DOUBLE NULL DEFAULT NULL,
  `weight` DOUBLE NULL DEFAULT NULL,
  `activity` VARCHAR(45) NULL DEFAULT NULL,
  `sex` VARCHAR(10) NULL DEFAULT NULL,
  `coef_id` INT(11) NULL DEFAULT NULL,
  `client_meal_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_coef`
    FOREIGN KEY (`coef_id`)
    REFERENCES `fitnesstracking`.`coefficients` (`idCoefficients`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE INDEX `fk_coef_idx` ON `fitnesstracking`.`clients` (`coef_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `fitnesstracking`.`products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesstracking`.`products` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `fat` DOUBLE NULL DEFAULT NULL,
  `protein` DOUBLE NULL DEFAULT NULL,
  `carbohydrate` DOUBLE NULL DEFAULT NULL,
  `caloriesPer100gr` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `fitnesstracking`.`meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesstracking`.`meals` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `productId` INT(11) NOT NULL,
  `meal_client_id` INT(11) NULL DEFAULT NULL,
  `quantityOf100grPortions` DOUBLE NULL DEFAULT NULL,
  `meal_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_product_id`
    FOREIGN KEY (`productId`)
    REFERENCES `fitnesstracking`.`products` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

CREATE INDEX `fk_product_id_idx` ON `fitnesstracking`.`meals` (`productId` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `fitnesstracking`.`client_meals`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `fitnesstracking`.`client_meals` (
  `ID` INT(11) NOT NULL,
  `clientid` INT(11) NOT NULL,
  `mealid` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_client_id`
    FOREIGN KEY (`clientid`)
    REFERENCES `fitnesstracking`.`clients` (`id`),
  CONSTRAINT `fk_meal_id`
    FOREIGN KEY (`mealid`)
    REFERENCES `fitnesstracking`.`meals` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `fk_client_id_idx` ON `fitnesstracking`.`client_meals` (`clientid` ASC) VISIBLE;

CREATE INDEX `fk_meal_id_idx` ON `fitnesstracking`.`client_meals` (`mealid` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
