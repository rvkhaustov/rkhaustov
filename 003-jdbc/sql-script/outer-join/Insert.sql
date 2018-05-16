INSERT INTO public.carBody(name) VALUES ('джип');
INSERT INTO public.carBody(name) VALUES ('классика');
INSERT INTO public.carBody(name) VALUES ('универсал');

INSERT INTO public.carEngine(name) VALUES ('бензиновый');
INSERT INTO public.carEngine(name) VALUES ('дизельный');
INSERT INTO public.carEngine(name) VALUES ('гибридный');

INSERT INTO public.carGearbox(name) VALUES ('механика');
INSERT INTO public.carGearbox(name) VALUES ('автомат');

INSERT INTO public.car(name, carbodyid, carengineid, cargearboxid) VALUES ('volvo', 1, 2, 2);
INSERT INTO public.car(name, carbodyid, carengineid, cargearboxid) VALUES ('taz', 2, 1, 1);





	