drop table product if exists;

create table product (
    id bigint auto_increment,
    product_code varchar(80) null,
    product_name varchar(80) null,
    product_desc varchar(250) null,
    product_type int(10) null
);
