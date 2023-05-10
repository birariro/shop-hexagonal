
INSERT INTO shop_db.tb_member (member_id,city,street,zipcode,name) VALUES
    (1,'서울','테헤란로','56011','김또깡'),
    (2,'서울','홍대','52543','하칫솔'),
    (3,'서울','명동','91332','이땡땡'),
    (4,'서울','상수동','77821','수사사'),
    (5,'서울','압구정','82732','박하사탕'),
    (6,'서울','동대문','43234','최잇몸'),
    (7,'인천','남구','13434','최치약'),
    (8,'인천','동구','55323','이거리');



INSERT INTO shop_db.tb_item (dtype,item_id,name,price,stock_quantity,artist,etc,author,isbn,actor,director) VALUES
	 ('A',1,'album_name_1',10000,450,'artist_name_1','hi',NULL,NULL,NULL,NULL),
	 ('A',2,'album_name_2',10500,500,'artist_name_2','row',NULL,NULL,NULL,NULL),
	 ('B',3,'album_name_3',15000,30,NULL,NULL,'author_name_1','IB1101',NULL,NULL),
	 ('B',4,'album_name_4',3000,730,NULL,NULL,'author_name_2','IB1109',NULL,NULL),
	 ('M',5,'album_name_5',900000,5,NULL,NULL,NULL,NULL,'actor_name_1','director_1'),
	 ('M',6,'album_name_6',1900000,3,NULL,NULL,NULL,NULL,'actor_name_2','director_2');
