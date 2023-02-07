create table if not exists Taco_Order (
    id integer not null auto_increment,
    amount decimal not null,
    address varchar(100) not null,
    placed_at timestamp not null,
    primary key (id)
);

create table if not exists Taco (
    id integer not null auto_increment,
    name varchar(50) not null,
    taco_order integer not null,
    taco_order_key integer not null,
    created_at timestamp not null,
    primary key (id)
);

create table if not exists Ingredient_Ref (
    taco integer not null,
    taco_key integer not null,
    ingredient varchar(4) not null,
    unique(taco, ingredient)
);

create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(10) not null,
    unique(id)
);

alter table Taco add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref add foreign key (ingredient) references Ingredient(id);

create table if not exists User (
    id integer not null auto_increment,
    username varchar(30) not null,
    password varchar(100) not null,
    first_name varchar(50) not null,
	last_name varchar(50) not null,
    address varchar(100),
    mobile_number varchar(15),
    primary key (id)
);