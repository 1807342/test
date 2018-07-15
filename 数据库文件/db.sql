create database Film;

create table filmtype(
	typeid int primary key auto_increment,
	typename varchar(50)
);

select * from filmtype


create table filminfo(
	filmid int primary key auto_increment,
	typeid int,
	filmname varchar(50),
	actor varchar(50),
	director varchar(50),
	ticketprice double
);

drop table filminfo

alter table filminfo
   add constraint fk_filminfo_typeid
      foreign key(typeid) references filmtype(typeid);
      
select * from filmtype;

select * from filminfo 

select filmid,typename,filminfo.typeid as typeid,filmname,actor,director,ticketprice
from filminfo
left join filmtype
on filmtype.typeid=filminfo.typeid  
where ticketprice between 10 and 15

//不不不不不不不不