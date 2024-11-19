use storyflow;

drop table if exists utente;
drop table if exists libri;
drop table if exists generi;
drop table if exists serietv;
drop table if exists manga;
drop table if exists fumetti;
drop table if exists scrittori;
drop table if exists disegnatori;
drop table if exists mangaka;



-- TABELLA UTENTE

create table utente (
	utente_id integer primary key auto_increment,
    cognome varchar(50),
    nome varchar(50),
	email varchar (100),
    password varchar(25),
    nascita date,
    unique key (email)
);

commit;


-- TABELLA GENERI

create table generi(
	generi_id integer primary key auto_increment,
	nome varchar(25)
);

insert into generi (nome) values
	('Commedia'),
    ('Drama'),
    ('Anime'),
    ('Thriller'),
    ('Horror'),
	('Romantico'),
    ('Azione'),
    ('Fantasy'),
    ('Polizesco'),
    ('Autobiografico'),
    ('Biografico'),
    ('Fantascienza'),
    ('Romanzo');
    
commit;


-- TABELLA SERIE TV

create table serietv(
	serietv_id integer primary key auto_increment,
	titolo varchar(50),
    generi_id integer,
    
	foreign key (generi_id) references generi (generi_id)
);

insert into serietv (titolo, generi_id) values
	('The Sopranos', 2),
    ('Twin Peaks', 4),
    ('The Young Pope', 2),
    ('Breaking Bad', 2),
    ('Lost', 4),
	('Fringe', 12),
    ('True Detective', 9),
    ('Succession', 2),
    ('Westworld', 12),
    ('Dostoevskij', 9);
    
commit;


-- TABELLA LIBRI

create table libri(
	libri_id integer primary key auto_increment,
	titolo varchar(40),
    generi_id integer,
    
    foreign key (generi_id) references generi (generi_id)
);

-- FK
select generi_id into @commedia from generi where nome = 'Commedia';
select generi_id into @drama from generi where nome = 'Drama';
select generi_id into @anime from generi where nome = 'Anime';
select generi_id into @thriller from generi where nome = 'Thriller';
select generi_id into @horror from generi where nome = 'Horror';
select generi_id into @romantico from generi where nome = 'Romantico';
select generi_id into @azione from generi where nome = 'Azione';
select generi_id into @fantasy from generi where nome = 'Fantasy';
select generi_id into @polizesco from generi where nome = 'Polizesco';
select generi_id into @autobiografico from generi where nome = 'Autobiografico';
select generi_id into @biografico from generi where nome = 'Biografico';
select generi_id into @fantascienza from generi where nome = 'Fantascienza';
select generi_id into @romanzo from generi where nome = 'Romanzo';

insert into libri (titolo, generi_id) values
('Diario Notturno', @commedia),
('American Psycho', @thriller), 
('Infinite Jest', @romanzo), 
('Cento Poesie d Amore a LadyHawke', @romantico),
('I Detective Selvaggi', @polizesco), 
('Paradiso Perduto', @romanzo), 
('Manituana', @drama),
('I Terrestri', @fantascienza),
("L'avversario", @romanzo);

commit;

-- TABELLA SCRITTORI

create table scrittori(
	scrittori_id integer primary key auto_increment,
	nome varchar(50),
    cognome varchar(50),
    libri_id integer,
    
	foreign key (libri_id) references libri (libri_id)
);

insert into scrittori(nome, cognome, libri_id) values
	('Ennio', 'Flaiano', 1),
    ('Wuming', null, 7),
    ('Bret', 'Easton Ellis', 2),
    ('John', 'Milton', 6),
    ('Michele', 'Mari', 4),
    ('Roberto', 'Bolano', 5),
    ('David', 'Foster Wallace', 3),
    ('Emmanuel', 'Carrere', 9),
    ('Sayaka', 'Murata', 8);
    
    commit;


-- TABELLA FUMETTI

create table fumetti(
	fumetti_id integer primary key auto_increment,
	titolo varchar(50),
    generi_id integer,
    
    foreign key (generi_id) references generi (generi_id)
);

insert into fumetti (titolo, generi_id) values
	('Watchmen', 2),
    ('Sin City', 2),
    ('Ranxerox', 12),
    ('Zanardi', 1),
    ('Celestia', 6),
	('La Profezia Dell Armadillo', 1),
    ('Spiderman', 7);
    
commit;

-- TABELLA MANGA

create table manga(
	manga_id integer primary key auto_increment,
	titolo varchar(25),
    generi_id integer,
    
    foreign key (generi_id) references generi (generi_id)
);

insert into manga (titolo, generi_id) values
	('Bersek', 8),
    ('Slam Dunk', 1),
    ('Green Blood', 7),
    ('Buonanotte, Punpun', 2);
    
commit;

    
    -- TABELLA DISEGNATORI
    
create table disegnatori(
	disegnatori_id integer primary key auto_increment,
	nome varchar(25),
    cognome varchar(25),
    fumetti_id integer,
    
    foreign key (fumetti_id) references fumetti (fumetti_id)
);

insert into disegnatori (nome, cognome, fumetti_id) values
('Andrea', 'Pazienza', 4),
('Alan', 'Moore', 1),
('Zerocalcare', null, 6),
('Manuele', 'Fior', 5),
('Tanino', 'Liberatore', 3),
('Frank', 'Miller', 2),
('Steve', 'Ditko', 7);

commit;

-- TABELLA MANGAKA

create table mangaka (
	mangaka_id integer primary key auto_increment,
	nome varchar(25),
    cognome varchar(25),
    manga_id integer,
    
    foreign key (manga_id) references manga (manga_id)
);
    
insert into mangaka (nome, cognome, manga_id) values
('Kentarou', 'Miura', 1),
('Takehiko', 'Inoue', 2),
('Masasumi', 'Kakizaki', 3),
('Inio', 'Asano', 4);



