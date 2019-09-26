CREATE TABLE menu_list (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  price int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY index_id (id)
)
CREATE TABLE cart_item (
  id int(11) NOT NULL AUTO_INCREMENT,
  menu_id int(11) NOT NULL,
  quantity int(11) NOT NULL,
  in_cart tinyint(1) DEFAULT NULL,
  in_cart_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  KEY menu_id (menu_id),
  CONSTRAINT cart_item_key_1 FOREIGN KEY (menu_id) REFERENCES menu_list (id)
)

