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
    url varchar(100),
    
	foreign key (generi_id) references generi (generi_id)
);

insert into serietv (titolo, generi_id, url) values
	('The Sopranos', 2, 'https://image.tmdb.org/t/p/original/rTc7ZXdroqjkKivFPvCPX0Ru7uw.jpg'),
    ('Twin Peaks', 4, 'https://image.tmdb.org/t/p/original/lA9CNSdo50iQPZ8A2fyVpMvJZAf.jpg'),
    ('The Young Pope', 2, 'https://image.tmdb.org/t/p/original/iaGH4pRNRFo7dTkvHmWJ9C4uPLM.jpg'),
    ('Breaking Bad', 2, 'https://image.tmdb.org/t/p/original/ztkUQFLlC19CCMYHW9o1zWhJRNq.jpg'),
    ('Lost', 4,'https://image.tmdb.org/t/p/original/og6S0aTZU6YUJAbqxeKjCa3kY1E.jpg'),
	('Fringe', 12,'https://image.tmdb.org/t/p/original/evhOVPj5IJyosoy6tByZ2YGPryD.jpg'),
    ('True Detective', 9, 'https://image.tmdb.org/t/p/original/o17Pc92lh44le7X69IA2gKKBcp7.jpg'),
    ('Succession', 2,'https://pad.mymovies.it/filmclub/2019/10/183/locandina.jpg'),
    ('Westworld', 12,'https://www.inkroci.it/racconti-brevi/wp-content/uploads/2020/11/Westworld.jpeg'),
    ('Dostoevskij', 9,'https://www.hollywoodreporter.it/wp-content/uploads/2024/02/DOSTOEVSKIJ-Poster.jpg');
    
commit;


-- TABELLA LIBRI

create table libri(
	libri_id integer primary key auto_increment,
	titolo varchar(40),
    generi_id integer,
    url varchar(100),
    
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

insert into libri (titolo, generi_id, url) values
('Diario Notturno', @commedia, 'https://www.adelphi.it/spool/i__id11704_mw1000__1x.jpg'),
('American Psycho', @thriller,'https://m.media-amazon.com/images/I/81jZ1EFsHhL.jpg'), 
('Infinite Jest', @romanzo, 'https://m.media-amazon.com/images/I/41hug15aRJL._SY445_SX342_.jpg'), 
('Cento Poesie d Amore a LadyHawke', @romantico, 'https://www.einaudi.it/content/uploads/2007/02/978880618112GRA.JPG'),
('I Detective Selvaggi', @polizesco, 'https://www.adelphi.it/spool/i__id6809_mw1000__1x.jpg'), 
('Paradiso Perduto', @romanzo, 'https://m.media-amazon.com/images/I/51Z0Cco7CmL._SY445_SX342_.jpg'), 
('Manituana', @drama, 'https://m.media-amazon.com/images/I/71E-3iD-hUL._SY425_.jpg'),
('I Terrestri', @fantascienza, 'https://m.media-amazon.com/images/I/71QxecnTncL.jpg'),
("L'avversario", @romanzo, 'https://www.adelphi.it/spool/i__id8656_mw1000__1x.jpg');

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
    url varchar(300),
    foreign key (generi_id) references generi (generi_id)
);

insert into fumetti (titolo, generi_id,url) values
	('Watchmen', 2, 'https://hips.hearstapps.com/hmg-prod/images/watchmen-fumetto-1571911021.jpg?resize=980:*'),
    ('Sin City', 2, 'https://www.starcomics.com/files/immagini/fumetti-cover/sincityilduroaddio-limitededition-1-1200px'),
    ('Ranxerox', 12, 'https://www.borsadelfumetto.com/wp-content/uploads/2024/08/30297-215436.jpg'),
    ('Zanardi', 1, 'https://m.media-amazon.com/images/I/41H+lkDM6lL.jpg'),
    ('Celestia', 6, 'https://m.media-amazon.com/images/I/51V85pHBmpL._SY445_SX342_.jpg'),
	('La Profezia Dell Armadillo', 1, 'https://m.media-amazon.com/images/I/51DMHSRXKuL._SY445_SX342_.jpg'),
    ('Spiderman', 7, 'https://www.panini.it/media/catalog/product/cache/d766b71eb5a49300f9a765da04354453/m/s/msmco001isbnr_0_agu8qk5hru3gbsst.jpg');
    
commit;

-- TABELLA MANGA

create table manga(
	manga_id integer primary key auto_increment,
	titolo varchar(25),
    generi_id integer,
    url varchar(100),
    foreign key (generi_id) references generi (generi_id)
);

insert into manga (titolo, generi_id, url) values
	('Bersek', 8, 'https://m.media-amazon.com/images/I/71lnvXSiITL.jpg'),
    ('Slam Dunk', 1, 'https://img2.libreriauniversitaria.it/BIT/500/601/9788891296016.jpg'),
    ('Green Blood', 7, 'https://img2.libreriauniversitaria.it/BIT/500/601/9788891296016.jpg'),
    ('Buonanotte, Punpun', 2, 'https://m.media-amazon.com/images/I/41jMFv+gsDL._AC_UF1000,1000_QL80_.jpg');
    
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



