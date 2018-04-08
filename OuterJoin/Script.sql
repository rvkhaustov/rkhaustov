-- 4.	Вывести все машины.
select 
c.name,
(select cb.name from carbody as cb where cb.id = c.carbodyid) as carbody,
(select ce.name from carengine as ce where ce.id = c.carengineid) as carengine,
(select cg.name from cargearbox as cg where cg.id = c.cargearboxid) as cargearbox
from car as c;


-- 5.	Вывести все неиспользуемые детали.
select cb.name from car as c
right outer join carBody as cb on c.carbodyid = cb.id
where c.id is null;

select ce.name from car as c
right outer join carengine as ce on c.carengineid = ce.id
where c.id is null;

select cg.name from car as c
right outer join cargearbox as cg on c.carengineid = cg.id
where c.id is null;

