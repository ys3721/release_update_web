SET CHARACTER_SET_CLIENT=utf8;
SET CHARACTER_SET_CONNECTION=utf8;

create database `wg_lj_probe` default character set utf8 collate utf8_general_ci;

use `wg_lj_probe`;

CREATE TABLE `t_server_status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `server_id` int(10) unsigned NOT NULL,
  `online_count` int(10) unsigned NOT NULL,
  `memory` int(11) unsigned NOT NULL,
  `disk_use` int(11) NOT NULL default 0,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=557 DEFAULT CHARSET=utf8;
