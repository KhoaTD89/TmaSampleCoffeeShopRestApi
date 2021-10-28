insert into city(id, name)
values (1, 'Ho Chi Minh'),
       (2, 'Quy Nhon');

insert into district(id, name, city_id)
values (1, 'District 1', 1),
       (2, 'District 2', 1),
       (3, 'District 3', 1),
       (4, 'District 4', 1),
       (5, 'District 5', 1),
       (6, 'District 6', 1),
       (20, 'QuyNhon', 2);

insert into ward(id, name, district_id)
values (1, 'Ben Nghe', 1),
       (2, 'Cau Kho', 1),
       (3, 'Co Giang', 1),
       (4, 'Hai cang', 20),
       (5, 'Xuan Dieu', 20),
       (6, 'ghenh Rang', 20);

insert
into store(close_time, description, image_path, name, open_time, phone)
values ('21:00', 'com.tma.sample.coffeeshop desc', 'img/store1.jpg', 'CFH 84 Hoang Sa', '09:00', '123123123'),
       ('21:00', 'store2', 'img/store2.jpg', 'store2_name', '09:00', 'store2-phone'),
       ('21:00', 'store3', 'img/store3.jpg', 'store3_name', '09:00', 'store3-phone'),
       ('21:00', 'store4', 'img/store4.jpg', 'store4_name', '09:00', 'store4-phone'),
       ('21:00', 'store5', 'img/store5.jpg', 'store5_name', '09:00', 'store5-phone'),
       ('21:00', 'store6', 'img/store6.jpg', 'store6_name', '09:00', 'store6-phone'),
       ('21:00', 'store7', 'img/store7.jpg', 'store7_name', '09:00', 'store7-phone'),
       ('21:00', 'store8', 'img/store8.jpg', 'store8_name', '09:00', 'store8-phone')
;

insert into customer(first_name, username)
values ('Khoa tran', 'KhoaTD'),
       ('Duy', 'DuySD'),
       ('FirstName customer_3 ', 'username customer_3 '),
       ('FirstName customer_4 ', 'username customer_4 '),
       ('FirstName customer_5 ', 'username customer_5 '),
       ('FirstName customer_6 ', 'username customer_6 '),
       ('FirstName customer_7 ', 'username customer_7 '),
       ('FirstName customer_8 ', 'username customer_8 '),
       ('FirstName customer_9 ', 'username customer_9 ')
;


insert into address(building, description, gate, ward_id, customer_id)
values ('A', '60 floors', 'A', 1, 1),
       ('B', '23 floors', 'A', 1, 1),
       ('C', '43 floors', 'A', 1, 1),
       ('D', '45 floors', 'A', 1, 2),
       ('E', '213 floors', 'A', 1, 2),
       ('F', '12 floors', 'A', 1, 2),
       ('G', '12 floors', 'A', 1, 3),
       ('H', '43 floors', 'A', 1, 3),
       ('I', '54 floors', 'A', 1, 1),
       ('J', '87 floors', 'A', 1, 1),
       ('K', '90 floors', 'A', 1, 1);
insert into address(building, description, gate, ward_id, store_id)
values ('bitecco', '60 floors', 'A', 1, 1);

insert into category(name)
values ('coffee'),
       ('coktail'),
       ('smoothy'),
       ('icream');

insert into extra_option(description, price)
VALUES ('topping 1', 10),
       ('topping 2', 20),
       ('topping 3', 15);


insert into product(is_active, name)
values (true, 'drink 1'),
       (true, 'drink 2'),
       (true, 'drink 3'),
       (true, 'drink 4'),
       (true, 'drink 5'),
       (true, 'drink 6'),
       (true, 'drink 7'),
       (true, 'drink 8'),
       (true, 'drink 9'),
       (true, 'drink 10');

insert into product_detail(is_active, price, size, product_id,created_date,description)
values (true, 30, 'S', 1,CURRENT_TIMESTAMP,'1S'),
       (true, 40, 'M', 1,CURRENT_TIMESTAMP,'1S'),
       (true, 60, 'L', 1,CURRENT_TIMESTAMP,'1S'),
       (true, 50, 'XL', 1,CURRENT_TIMESTAMP,'1S'),
       (true, 30, 'S', 2,CURRENT_TIMESTAMP,'1S'),
       (true, 40, 'M', 2,CURRENT_TIMESTAMP,'1S'),
       (true, 60, 'L', 2,CURRENT_TIMESTAMP,'1S');

insert into menu(is_active, product_id, store_id)
values (true, 1, 1),
       (true, 2, 1),
       (true, 3, 1),
       (true, 4, 1),
       (true, 5, 1),
       (true, 6, 1),
       (true, 7, 1);