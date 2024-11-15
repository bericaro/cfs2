drop user if exists cfs2;
drop schema if exists cfs2;

create user cfs2 identified by 'password';
create schema cfs2;

grant all privileges on cfs2.* to cfs2;

