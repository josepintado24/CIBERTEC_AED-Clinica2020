Create database bd_proyectos
on Primary
(
	size=50,
	filename='C:/Proyectos/bd/bd_proyectos.mdf',
	maxsize=unlimited,
	filegrowth=2
),
(
	name='bd_tienda_sec',
	filename='C:/Proyectos/bd/bd_proyectos.ndf',
	size=20,
	maxsize=150,
	filegrowth=12%
)

Log on(
	name='bd_tienda_tra',
	filename='C:/Proyectos/bd/bd_proyectos.ldf',
	size=2,
	maxsize=15,
	filegrowth=1
)

Alter table Encargado
	add Constraint chk_cargo
	check (Cargo in ('Jefe de proyecto', 'Contador', 'Analista de riesgo'));

Alter table Proyecto
	add Constraint df_descripcion 'Sin definir' for Descripcion;