create table if not exists to_do_list (
	todo_id int not null auto_increment primary key,
	todo_title varchar(50),
	todo_detail varchar(255)
);
