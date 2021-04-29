--for the tribble schema

create table "Tribbles" (
	"ID" int,
	"Name" varchar(80),
	"Age" int,
	"Lab" int,
	constraint "PK_Tribble" primary key ("ID"),
	foreign key ("Lab") references "Labs"("ID")
);

create table "Labs" (
	"ID" int,
	"Location" varchar(80),
	"Capacity" int,
	constraint "PK_Lab" primary key ("ID")
);