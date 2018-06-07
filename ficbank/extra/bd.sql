-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ficbank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ficbank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ficbank` DEFAULT CHARACTER SET utf8 ;
USE `ficbank` ;

-- -----------------------------------------------------
-- Table `ficbank`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ficbank`.`cliente` (
  `cl_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NOT NULL,
  `telefone` VARCHAR(14) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `estado` VARCHAR(30) NOT NULL,
  `cidade` VARCHAR(50) NOT NULL,
  `logradouro` VARCHAR(50) NOT NULL,
  `numero` VARCHAR(6) NOT NULL,
  `bairro` VARCHAR(50) NOT NULL,
  `cpf` VARCHAR(11) NOT NULL,
  `ativo` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`cl_id`, `cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ficbank`.`conta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ficbank`.`conta` (
  `co_id` INT(11) NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `saldo` DOUBLE NULL DEFAULT NULL,
  `ativo` TINYINT(1) NULL DEFAULT NULL,
  `cl_id` INT(11) NOT NULL,
  PRIMARY KEY (`co_id`, `user`),
  INDEX `fk_conta_cliente1_idx` (`cl_id` ASC),
  CONSTRAINT `fk_conta_cliente1`
    FOREIGN KEY (`cl_id`)
    REFERENCES `ficbank`.`cliente` (`cl_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ficbank`.`operacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ficbank`.`operacao` (
  `op_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`op_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ficbank`.`tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ficbank`.`tag` (
  `ta_id` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ta_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ficbank`.`Requisicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ficbank`.`Requisicao` (
  `re_id` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `dia` VARCHAR(11) NOT NULL,
  `aprovado` TINYINT NULL,
  `visualizado` TINYINT NULL,
  `op_id` INT(11) NOT NULL,
  `ta_id` INT(11) NULL,
  `co_idRemetente` INT NOT NULL,
  `co_idDestino` INT(11) NOT NULL,
  PRIMARY KEY (`re_id`, `valor`),
  INDEX `fk_Requisicao_op1_idx` (`op_id` ASC),
  INDEX `fk_Requisicao_tag1_idx` (`ta_id` ASC),
  INDEX `fk_Requisicao_conta1_idx` (`co_idRemetente` ASC),
  INDEX `fk_Requisicao_conta2_idx` (`co_idDestino` ASC),
  CONSTRAINT `fk_Requisicao_op1`
    FOREIGN KEY (`op_id`)
    REFERENCES `ficbank`.`operacao` (`op_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Requisicao_tag1`
    FOREIGN KEY (`ta_id`)
    REFERENCES `ficbank`.`tag` (`ta_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Requisicao_conta1`
    FOREIGN KEY (`co_idRemetente`)
    REFERENCES `ficbank`.`conta` (`co_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Requisicao_conta2`
    FOREIGN KEY (`co_idDestino`)
    REFERENCES `ficbank`.`conta` (`co_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
