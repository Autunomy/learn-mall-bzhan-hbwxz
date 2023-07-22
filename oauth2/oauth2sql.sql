CREATE SCHEMA IF NOT EXISTS `oauth` DEFAULT CHARACTER SET utf8 ;
USE `oauth` ;

CREATE TABLE IF NOT EXISTS `oauth`.`clientdetails` (
    `appId` VARCHAR(128) NOT NULL,
    `resourceIds` VARCHAR(256) NULL DEFAULT NULL,
    `appSecret` VARCHAR(256) NULL DEFAULT NULL,
    `scope` VARCHAR(256) NULL DEFAULT NULL,
    `grantTypes` VARCHAR(256) NULL DEFAULT NULL,
    `redirectUrl` VARCHAR(256) NULL DEFAULT NULL,
    `authorities` VARCHAR(256) NULL DEFAULT NULL,
    `access_token_validity` INT(11) NULL DEFAULT NULL,
    `refresh_token_validity` INT(11) NULL DEFAULT NULL,
    `additionalInformation` VARCHAR(4096) NULL DEFAULT NULL,
    `autoApproveScopes` VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`appId`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oauth`.`oauth_access_token` (
    `token_id` VARCHAR(256) NULL DEFAULT NULL,
    `token` BLOB NULL DEFAULT NULL,
    `authentication_id` VARCHAR(128) NOT NULL,
    `user_name` VARCHAR(256) NULL DEFAULT NULL,
    `client_id` VARCHAR(256) NULL DEFAULT NULL,
    `authentication` BLOB NULL DEFAULT NULL,
    `refresh_token` VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`authentication_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oauth`.`oauth_approvals` (
    `userId` VARCHAR(256) NULL DEFAULT NULL,
    `clientId` VARCHAR(256) NULL DEFAULT NULL,
    `scope` VARCHAR(256) NULL DEFAULT NULL,
    `status` VARCHAR(10) NULL DEFAULT NULL,
    `expiresAt` DATETIME NULL DEFAULT NULL,
    `lastModifiedAt` DATETIME NULL DEFAULT NULL)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oauth`.`oauth_client_details` (
    `client_id` VARCHAR(128) NOT NULL,
    `resource_ids` VARCHAR(256) NULL DEFAULT NULL,
    `client_secret` VARCHAR(256) NULL DEFAULT NULL,
    `scope` VARCHAR(256) NULL DEFAULT NULL,
    `authorized_grant_types` VARCHAR(256) NULL DEFAULT NULL,
    `web_server_redirect_uri` VARCHAR(256) NULL DEFAULT NULL,
    `authorities` VARCHAR(256) NULL DEFAULT NULL,
    `access_token_validity` INT(11) NULL DEFAULT NULL,
    `refresh_token_validity` INT(11) NULL DEFAULT NULL,
    `additional_information` VARCHAR(4096) NULL DEFAULT NULL,
    `autoapprove` VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`client_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oauth`.`oauth_client_token` (
    `token_id` VARCHAR(256) NULL DEFAULT NULL,
    `token` BLOB NULL DEFAULT NULL,
    `authentication_id` VARCHAR(128) NOT NULL,
    `user_name` VARCHAR(256) NULL DEFAULT NULL,
    `client_id` VARCHAR(256) NULL DEFAULT NULL,
    PRIMARY KEY (`authentication_id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;


CREATE TABLE IF NOT EXISTS `oauth`.`oauth_code` (
    `code` VARCHAR(256) NULL DEFAULT NULL,
    `authentication` BLOB NULL DEFAULT NULL)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `oauth`.`oauth_refresh_token` (
    `token_id` VARCHAR(256) NULL DEFAULT NULL,
    `token` BLOB NULL DEFAULT NULL,
    `authentication` BLOB NULL DEFAULT NULL)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` int NOT NULL,
    `passwd` varchar(265) COLLATE utf8mb4_general_ci NOT NULL,
    `user_name` varchar(256) COLLATE utf8mb4_general_ci NOT NULL,
    `user_role` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
    `user_email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `user_idcard` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `user_phone` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `user_province` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `vip_epoch` int NOT NULL,
    `vip_buy_date` datetime DEFAULT NULL,
    `vip_end_date` datetime DEFAULT NULL,
    `vip_status` int NOT NULL,
    `user_real_name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;