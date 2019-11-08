DROP TABLE if exists pizzas;

create table pizzas (
  id     	integer NOT NULL AUTO_INCREMENT,
  name    	varchar(30),
  description 	varchar(80),
  price 		integer,
  primary key (id),
  UNIQUE KEY name_UNIQUE (name));

INSERT INTO mario.pizzas (name, description, price) VALUES ('Vesuvio', 'tomatsauce, ost, skinke, oregano', 57);
INSERT INTO mario.pizzas (name, description, price) VALUES ('Amerikaner', 'tomatsauce, ost, oksefars, oregano', 53);
INSERT INTO mario.pizzas (name, description, price) VALUES ('Cacciatore', 'tomatsauce, ost, pepperoni, oregano', 57);
