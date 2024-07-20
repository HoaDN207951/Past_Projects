create table origin
     (id int auto_increment,
      name varchar(30),
      primary key(id)
      );

create table dish
     (id int auto_increment,
      name varchar(50),
      price int,
      status boolean,
      primary key(id)
      ) auto_increment = 1000;
      
create table category
     (id int auto_increment,
      name varchar(30), 
      primary key(id)
      );

create table unit
     (id int auto_increment,
      name varchar(10),
      primary key(id)
      );

create table ingredients
     (id int auto_increment,
     name varchar(30),
     quantity int,
     unit_id int,
     import_date varchar(20),
     expired_date varchar(20),
     primary key(id),
     foreign key(unit_id) references unit(id)
     ) auto_increment = 2000;
     
create table dish_ingredients
    (dish_id int,
    ingre_id int,
    amount int,
    primary key(dish_id, ingre_id),
    foreign key(dish_id) references dish(id),
    foreign key(ingre_id) references ingredients(id)
    );
    
create table dish_org
	(dish_id int,
    org_id int,
    primary key(dish_id, org_id),
	foreign key(org_id) references origin(id),
    foreign key(dish_id) references dish(id)
    );
    
create table dish_categ
     (dish_id int,
     category_id int,
     primary key(dish_id, category_id),
	 foreign key(dish_id) references dish(id),
     foreign key(category_id) references category(id)
     );