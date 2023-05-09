-- shop_db.delivery definition

CREATE TABLE `tb_delivery` (
                            `delivery_id` bigint(20) NOT NULL,
                            `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `zipcode` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.item definition

CREATE TABLE `tb_item` (
                        `dtype` varchar(31) COLLATE utf8mb4_unicode_ci NOT NULL,
                        `item_id` bigint(20) NOT NULL,
                        `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `price` int(11) NOT NULL,
                        `stock_quantity` int(11) NOT NULL,
                        `artist` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `etc` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `author` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `isbn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `actor` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        `director` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                        PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.`member` definition

CREATE TABLE `tb_member` (
                          `member_id` bigint(20) NOT NULL,
                          `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `street` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `zipcode` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.category definition

CREATE TABLE `tb_category` (
                            `category_id` bigint(20) NOT NULL,
                            `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `parent_id` bigint(20) DEFAULT NULL,
                            PRIMARY KEY (`category_id`),
                            KEY `FK2y94svpmqttx80mshyny85wqr` (`parent_id`),
                            CONSTRAINT `FK2y94svpmqttx80mshyny85wqr` FOREIGN KEY (`parent_id`) REFERENCES `tb_category` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.category_item definition

CREATE TABLE `tb_category_item` (
                                 `category_id` bigint(20) NOT NULL,
                                 `item_id` bigint(20) NOT NULL,
                                 KEY `FKu8b4lwqutcdq3363gf6mlujq` (`item_id`),
                                 KEY `FKcq2n0opf5shyh84ex1fhukcbh` (`category_id`),
                                 CONSTRAINT `FKcq2n0opf5shyh84ex1fhukcbh` FOREIGN KEY (`category_id`) REFERENCES `tb_category` (`category_id`),
                                 CONSTRAINT `FKu8b4lwqutcdq3363gf6mlujq` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.orders definition

CREATE TABLE `tb_orders` (
                          `order_id` bigint(20) NOT NULL,
                          `order_date` datetime(6) DEFAULT NULL,
                          `status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `delivery_id` bigint(20) DEFAULT NULL,
                          `member_id` bigint(20) DEFAULT NULL,
                          PRIMARY KEY (`order_id`),
                          KEY `FKtkrur7wg4d8ax0pwgo0vmy20c` (`delivery_id`),
                          KEY `FKpktxwhj3x9m4gth5ff6bkqgeb` (`member_id`),
                          CONSTRAINT `FKpktxwhj3x9m4gth5ff6bkqgeb` FOREIGN KEY (`member_id`) REFERENCES `tb_member` (`member_id`),
                          CONSTRAINT `FKtkrur7wg4d8ax0pwgo0vmy20c` FOREIGN KEY (`delivery_id`) REFERENCES `tb_delivery` (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- shop_db.order_item definition

CREATE TABLE `tb_order_item` (
                              `order_item_id` bigint(20) NOT NULL,
                              `count` int(11) NOT NULL,
                              `order_price` int(11) NOT NULL,
                              `item_id` bigint(20) DEFAULT NULL,
                              `order_id` bigint(20) DEFAULT NULL,
                              PRIMARY KEY (`order_item_id`),
                              KEY `FKija6hjjiit8dprnmvtvgdp6ru` (`item_id`),
                              KEY `FKt4dc2r9nbvbujrljv3e23iibt` (`order_id`),
                              CONSTRAINT `FKija6hjjiit8dprnmvtvgdp6ru` FOREIGN KEY (`item_id`) REFERENCES `tb_item` (`item_id`),
                              CONSTRAINT `FKt4dc2r9nbvbujrljv3e23iibt` FOREIGN KEY (`order_id`) REFERENCES `tb_orders` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;