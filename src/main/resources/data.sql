create table person 
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date timestamp,
	primary key (id)

);

insert into person
(id, name, location, birth_date)
values
(10001, 'shivashankar', 'Bangalore', sysdate());


insert into person
(id, name, location, birth_date)
values
(10002, 'Harish', 'Delli', sysdate());


insert into person
(id, name, location, birth_date)
values
(10003, 'Kallappa', 'Harihar', sysdate());



insert into person
(id, name, location, birth_date)
values
(10004, 'ram', 'Mumbai', sysdate());