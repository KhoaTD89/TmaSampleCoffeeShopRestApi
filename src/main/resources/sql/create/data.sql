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
values ('21:00', 'test desc', 'img/store1.jpg', 'CFH 84 Hoang Sa', '09:00', '123123123'),
       ('21:00', 'test desc', 'img/store2.jpg', '23 Han Thuyen', '09:00', '123123123');

insert into customer(first_name, username)
values ('Khoa tran', 'KhoaTD'),
       ('Duy', 'DuySD');


insert into address(building, description, gate, ward_id, customer_id)
values ('bitecco', '60 floors', 'A', 1, 1);
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
       (true, 'drink 3');

insert into product_detail(is_active, price, size, product_id)
values (true, 30, 'S', 1),
       (true, 40, 'M', 1),
       (true, 60, 'L', 1),
       (true, 50, 'XL', 1),
       (true, 30, 'S', 2),
       (true, 40, 'M', 2),
       (true, 60, 'L', 2);


