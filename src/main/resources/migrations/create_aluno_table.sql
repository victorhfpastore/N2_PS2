--liquibase formatted sql

--changeset taiza:4
CREATE TABLE `controlepresença`.`aluno` (
  `tia` INT NOT NULL,
  `nome` VARCHAR(30) NOT NULL,
  `auladia` DATE NOT NULL,
  `presenca` TINYINT NOT NULL,
  PRIMARY KEY (`tia`));
