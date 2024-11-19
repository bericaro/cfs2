drop user if exists storyflow;
drop schema if exists storyflow;

create user storyflow identified by 'password';
create schema storyflow;
grant all privileges on storyflow.* to storyflow;
