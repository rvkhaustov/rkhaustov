	create table carBody (
	id serial primary key,
    name character varying(200)									
	);
	
	create table carEngine (
	id serial primary key,
    name character varying(200)									
	);
	
	create table carGearbox (
	id serial primary key,
    name character varying(200)									
	);
	
	create table car (
	id serial primary key,
	name character varying(200),
    carBodyId	integer references carBody(id),
	carEngineId	integer references carEngine(id),
	carGearboxId	integer references carGearbox(id)
	);