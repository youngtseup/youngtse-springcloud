create database if not exists youngtse default character set utf8 default COLLATE utf8_unicode_ci;
use youngtse;
drop table if exists `system_user`;
CREATE TABLE `system_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_subject` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色:要求英文小写',
  `role_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL COMMENT '角色名称',
  `role_remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色描述',
  `enabled` int(1) DEFAULT '1' COMMENT '是否可用:0不可用,1可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `create_time_idx` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色表';
drop table if exists `system_role`;
CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '密码',
  `account_non_expired` int(1) DEFAULT '1' COMMENT '账户是否过期:0已过期,1未过期',
  `account_non_locked` int(1) DEFAULT '1' COMMENT '账户是否锁定:0已锁定,1未锁定',
  `credentials_non_expired` int(1) DEFAULT '1' COMMENT '密码是否过期:0已过期,1未过期',
  `enabled` int(1) DEFAULT '1' COMMENT '账户是否可用:0不可用,1可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色表id',
  `personal_info_id` bigint(20) DEFAULT NULL COMMENT '个人信息表id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_idx` (`username`),
  KEY `create_time_idx` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='用户表';
drop table if exists `system_menu`;
CREATE TABLE `system_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '菜单名称',
  `menu_icon` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单图标',
  `router_url` varchar(255) COLLATE utf8_unicode_ci NOT NULL COMMENT '路由url',
  `menu_remark` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '菜单描述',
  `pid` bigint(20) NOT NULL COMMENT '上一级菜单id',
  `sort_no` int(3) NOT NULL COMMENT '菜单序号',
  `menu_level` int(2) NOT NULL COMMENT '菜单等级',
  `enabled` int(1) DEFAULT '1' COMMENT '是否可用:0不可用,1可用',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `create_time_idx` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单表';
drop table if exists `role_menu_mapping`;
CREATE TABLE `role_menu_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '菜单id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色菜单映射表';