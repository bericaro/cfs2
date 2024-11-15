drop user if exists storyflow1;
drop schema if exists storyflow1;

create user storyflow1 identified by 'password';
create schema storyflow1;

grant all privileges on storyflow1.* to storyflow1;