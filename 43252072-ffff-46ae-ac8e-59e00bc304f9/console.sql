create database Session06_DB;
use Session06_DB;

create table Books
(
    id       varchar(255) unique not null,
    title    varchar(255)        not null,
    author   varchar(255)        not null,
    type     varchar(255)        not null,
    quantity int                 not null
);

delimiter \\

create procedure add_new_book(
    id_in varchar(255),
    title_in varchar(255),
    author_in varchar(255),
    type_in varchar(255),
    quantity_in int
)
begin
    insert into Books(id, title, author, type, quantity)
    values (id_in, title_in, author_in, type_in, quantity_in);
end \\

create procedure find_book_to_id_or_title(valueFind varchar(255))
begin
    select *
    from Books
    where id like concat('%', valueFind, '%')
       or title like concat('%', valueFind, '%');
end \\

create procedure get_all_books(offset_in int, size_in int)
begin
    select * from Books limit offset_in, size_in;
end \\

create procedure edit_book_by_id(
    id_in varchar(255),
    title_in varchar(255),
    author_in varchar(255),
    type_in varchar(255),
    quantity_in int
)
begin
    update Books
    set title    = title_in,
        author   = author_in,
        type     = type_in,
        quantity = quantity_in
    where id = id_in;
end \\

create procedure delete_book_by_id(id_in varchar(255))
begin
    delete from Books where id = id_in;
end \\

delimiter ;
create table users
(
    id       int auto_increment primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    email    varchar(255) not null unique,
    phone    varchar(255) not null unique
);
delimiter \\
create procedure add_new_account(
    name_in varchar(255), pass_in varchar(255), e_in varchar(255), phone_in varchar(255)
)
begin
    insert into users (username, password, email, phone)
    values (name_in, pass_in, e_in, phone_in);
end \\
create procedure get_acount(name_in varchar(255), pass_in varchar(255))
begin
    select *from users where username = name_in;
end \\
delimiter \\;
create table products
(
    id       int primary key auto_increment,
    name     varchar(255)   not null,
    price    decimal(10, 2) not null,
    imageurl varchar(10000)
);
create table product_carts
(
    id        int primary key auto_increment,
    userid    int not null,
    productid int not null,
    quantity  int not null check (quantity > 0),
    foreign key (productid) references products (id)
);
insert into products (name, price, imageurl)
values ('Áo thun nam basic', 199000,
        'https://www.google.com/imgres?q=%C3%81o%20thun%20nam%20basic&imgurl=https%3A%2F%2Fproduct.hstatic.net%2F1000360022%2Fproduct%2Fid-005732a_7dcd441b2c36492eaf3fb09341f3ceab_master.jpg&imgrefurl=https%3A%2F%2Ficondenim.com%2Fproducts%2Fao-thun-nam-tron-basic-and-beyond-form-slim&docid=Pu7YV8WZrKWOhM&tbnid=K0SfcQN7enPMPM&vet=12ahUKEwix86nP1J6NAxW03zQHHa8gMjwQM3oECBkQAA..i&w=2048&h=2048&hcb=2&ved=2ahUKEwix86nP1J6NAxW03zQHHa8gMjwQM3oECBkQAA'),
       ('Quần jean nữ rách gối', 399000,
        'https://www.google.com/imgres?q=Qu%E1%BA%A7n%20jean%20n%E1%BB%AF%20r%C3%A1ch%20g%E1%BB%91i&imgurl=https%3A%2F%2Fbizweb.dktcdn.net%2F100%2F386%2F478%2Fproducts%2Fb51051-2-1662368371930.jpg%3Fv%3D1662542475103&imgrefurl=https%3A%2F%2Fwww.loren.vn%2Fquan-jean-skinny-loren-lung-rach-goi-b51051&docid=fMCfMarHDuZG0M&tbnid=RGSOdxZBDkPTEM&vet=12ahUKEwjUq7XX1J6NAxWOsFYBHZnlFmUQM3oECBoQAA..i&w=768&h=1024&hcb=2&ved=2ahUKEwjUq7XX1J6NAxWOsFYBHZnlFmUQM3oECBoQAA'),
       ('Áo khoác gió unisex', 499000,
        'https://www.google.com/imgres?q=%C3%81o%20kho%C3%A1c%20gi%C3%B3%20unisex&imgurl=https%3A%2F%2Fbizweb.dktcdn.net%2F100%2F415%2F697%2Fproducts%2Fak046.png%3Fv%3D1701405178907&imgrefurl=https%3A%2F%2Fteelab.vn%2Fao-khoac-gio-unisex-nam-nu-teelab-design-studio-jacket-ak046&docid=YgbhSb6OsxCP0M&tbnid=8V-774TaCu7FhM&vet=12ahUKEwjLooPa1J6NAxUjlFYBHfrhI1cQM3oECB4QAA..i&w=1080&h=1080&hcb=2&ved=2ahUKEwjLooPa1J6NAxUjlFYBHfrhI1cQM3oECB4QAA'),
       ('Giày sneaker trắng', 599000,
        'https://www.google.com/imgres?q=Gi%C3%A0y%20sneaker%20tr%E1%BA%AFng&imgurl=https%3A%2F%2Fwww.vascara.com%2Fuploads%2Fcms_productmedia%2F2024%2FAugust%2F30%2Fgiay-sneaker-de-chunky---snk-0064---mau-trang__77542__1725000213-medium%402x.jpg&imgrefurl=https%3A%2F%2Fwww.vascara.com%2Fgiay-sneaker%2Fgiay-sneaker-de-chunky-snk-0064-mau-trang&docid=Le-giu5pLsFMzM&tbnid=KkTrsTi5K7nT9M&vet=12ahUKEwiUwena1J6NAxVnsVYBHYuqFRUQM3oECBwQAA..i&w=900&h=1228&hcb=2&ved=2ahUKEwiUwena1J6NAxVnsVYBHYuqFRUQM3oECBwQAA'),
       ('Túi xách thời trang nữ', 359000,
        'https://www.google.com/imgres?q=T%C3%BAi%20x%C3%A1ch%20th%E1%BB%9Di%20trang%20n%E1%BB%AF&imgurl=https%3A%2F%2Fmediaelly.sgp1.digitaloceanspaces.com%2Fuploads%2F2024%2F09%2F20115011%2FTui-xach-nu-thoi-trang-ELLY-EL326-45-Sao-chep.jpg&imgrefurl=https%3A%2F%2Felly.vn%2Fsan-pham%2Ftui-xach-nu-thoi-trang-elly-el326%2F&docid=JLdwRwDwezkuOM&tbnid=zbbbg6m_UzftvM&vet=12ahUKEwiT8a7b1J6NAxVCr1YBHZn2HpoQM3oECBoQAA..i&w=1080&h=1080&hcb=2&ved=2ahUKEwiT8a7b1J6NAxVCr1YBHZn2HpoQM3oECBoQAA'),
       ('Mũ lưỡi trai nam', 99000,
        'https://www.google.com/imgres?q=M%C5%A9%20l%C6%B0%E1%BB%A1i%20trai%20nam&imgurl=https%3A%2F%2Fwww.chapi.vn%2Fimg%2Fproduct%2F2023%2F5%2F25%2Fmu-luoi-trai-nam-wondea-17-new.jpg&imgrefurl=https%3A%2F%2Fwww.chapi.vn%2Fmu-nam%2Fmu-luoi-trai-nam-wondea-mau-be&docid=oUSMaJpjlD4icM&tbnid=-kxkvVCiHfHSoM&vet=12ahUKEwjFs97S056NAxWLr1YBHbLUOzUQM3oECBcQAA..i&w=800&h=800&hcb=2&ved=2ahUKEwjFs97S056NAxWLr1YBHbLUOzUQM3oECBcQAA'),
       ('Váy hoa dáng dài', 449000,
        'https://www.google.com/imgres?q=V%C3%A1y%20hoa%20d%C3%A1ng%20d%C3%A0i&imgurl=https%3A%2F%2Fcdn.kkfashion.vn%2F32653-large_default%2Fdam-hoa-nhi-dang-dai-xoe-duoi-ca-hl28-18.jpg%3Fw%3D768&imgrefurl=https%3A%2F%2Fwww.kkfashion.vn%2Fdam-hoa-nhi-dang-dai-xoe-duoi-ca-hl28-18&docid=KoXu7Rrq6X42_M&tbnid=jLk9yYG4XJhtUM&vet=12ahUKEwj_nMPX056NAxUmgFYBHVNwJQAQM3oECBgQAA..i&w=768&h=1152&hcb=2&ved=2ahUKEwj_nMPX056NAxUmgFYBHVNwJQAQM3oECBgQAA'),
       ('Áo sơ mi caro', 279000,
        'https://www.google.com/imgres?q=%C3%81o%20s%C6%A1%20mi%20caro&imgurl=https%3A%2F%2Fcdn0199.cdn4s.com%2Fmedia%2Fd61641d2eb8a32d46b9b.jpg&imgrefurl=https%3A%2F%2Fthe1970.vn%2Fso-mi-caro-1-tui-ke-vang-cam&docid=2EwO0q-oLRdVIM&tbnid=CNggBBC9sDmJWM&vet=12ahUKEwiXhbnc056NAxV2sFYBHeRZAoUQM3oECBcQAA..i&w=768&h=960&hcb=2&ved=2ahUKEwiXhbnc056NAxV2sFYBHeRZAoUQM3oECBcQAA'),
       ('Balo laptop chống nước', 389000,
        'https://www.google.com/imgres?q=Balo%20laptop%20ch%E1%BB%91ng%20n%C6%B0%E1%BB%9Bc&imgurl=https%3A%2F%2Fzongvietnam.com%2Fwp-content%2Fuploads%2F2023%2F10%2Fbalo-laptop-du-lich-phuot-chong-tham-nuoc-tangcool-705-14-156-inch.jpg&imgrefurl=https%3A%2F%2Fzongvietnam.com%2Fbalo-laptop-du-lich-phuot-chong-tham-nuoc-14-15-6-inch-tangcool-705%2F&docid=aqsYVo0kMgjM0M&tbnid=nCwhEBmZp_ICVM&vet=12ahUKEwirxJDh056NAxUlgVYBHet4JGEQM3oECB0QAA..i&w=1200&h=1200&hcb=2&ved=2ahUKEwirxJDh056NAxUlgVYBHet4JGEQM3oECB0QAA'),
       ('Đồng hồ thời trang nam', 799000,
        'https://www.google.com/imgres?q=%C4%90%E1%BB%93ng%20h%E1%BB%93%20th%E1%BB%9Di%20trang%20nam&imgurl=https%3A%2F%2Fdonghoolevs.vn%2Fwp-content%2Fuploads%2F2024%2F02%2F2-4-6.jpg&imgrefurl=https%3A%2F%2Fdonghoolevs.vn%2Fdong-ho-nam-thoi-trang-thuong-hieu-mark-fairwhale-size-mm%2F&docid=NOnyMDiFpSRaeM&tbnid=4z_KEz7pwMfWAM&vet=12ahUKEwj7uLHm056NAxWOsFYBHZnlFmUQM3oECBsQAA..i&w=800&h=800&hcb=2&ved=2ahUKEwj7uLHm056NAxWOsFYBHZnlFmUQM3oECBsQAA');

delimiter \\
drop table products;
drop table product_carts;
create procedure get_all_products()
begin
    select *from products;
end \\
delimiter \\;
delimiter \\
create procedure add_to_cart(user_in int, p_id int, q int)
begin
    insert into product_carts(userid, productid, quantity)
    values (user_in, p_id, q);
end \\
create procedure delete_product_in_cart(id_in int)
begin
    delete from product_carts where id = id_in;
end \\
delimiter \\;

DELIMITER \\
CREATE PROCEDURE get_cart_items(IN user_id INT)
BEGIN
    SELECT pc.id, p.name, p.price, pc.quantity, p.imageurl
    FROM product_carts pc
             JOIN products p ON pc.productid = p.id
    WHERE pc.userid = user_id;
END \\
DELIMITER ;

CREATE TABLE employees
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(255) NOT NULL,
    birthday DATE,
    phone    VARCHAR(15),
    email    VARCHAR(255),
    salary   DECIMAL(10, 2),
    position VARCHAR(100)
);
INSERT INTO employees (name, birthday, phone, email, salary, position)
VALUES ('Nguyen Van A', '1990-01-01', '0123456789', 'nguyenvana@example.com', 1000.00, 'Manager'),
       ('Le Thi B', '1985-05-15', '0123456790', 'lethib@example.com', 900.00, 'Developer'),
       ('Tran Minh C', '1992-07-20', '0123456791', 'tranminhc@example.com', 950.00, 'Designer'),
       ('Pham Hoang D', '1993-03-25', '0123456792', 'phamhoangd@example.com', 1100.00, 'Tester'),
       ('Bui Thanh E', '1987-12-10', '0123456793', 'buthanhe@example.com', 1050.00, 'Manager'),
       ('Nguyen Thi F', '1989-08-30', '0123456794', 'nguyenthif@example.com', 850.00, 'Developer'),
       ('Nguyen Minh G', '1994-04-05', '0123456795', 'nguyenming@example.com', 800.00, 'Developer'),
       ('Hoang Thi H', '1991-11-13', '0123456796', 'hoangthih@example.com', 950.00, 'Designer'),
       ('Vu Thi I', '1988-06-18', '0123456797', 'vuthii@example.com', 1200.00, 'Tester'),
       ('Do Minh J', '1990-09-22', '0123456798', 'dominhj@example.com', 1000.00, 'Manager');

delimiter \\
create procedure add_employee(
    in p_name varchar(100),
    in p_birthday date,
    in p_phone varchar(20),
    in p_email varchar(100),
    in p_salary double,
    in p_position varchar(100)
)
begin
    insert into employees (name, birthday, phone, email, salary, position)
    values (p_name, p_birthday, p_phone, p_email, p_salary, p_position);
end;
create procedure update_employee(
    in p_id int,
    in p_name varchar(100),
    in p_birthday date,
    in p_phone varchar(20),
    in p_email varchar(100),
    in p_salary double,
    in p_position varchar(100)
)
begin
    update employees
    set name     = p_name,
        birthday = p_birthday,
        phone    = p_phone,
        email    = p_email,
        salary   = p_salary,
        position = p_position
    where id = p_id;
end;
create procedure delete_employee(
    in p_id int
)
begin
    delete from employees where id = p_id;
end;
create procedure get_employee_by_id(
    in p_id int
)
begin
    select * from employees where id = p_id;
end;
create procedure search_employee(
    in p_keyword varchar(100)
)
begin
    select *
    from employees
    where name like concat('%', p_keyword, '%')
       or id = cast(p_keyword as unsigned);
end;
delimiter \\;
drop procedure get_all_employees;
delimiter \\
create procedure get_all_employees()
begin
    select *from employees;
end \\;
delimiter \\;