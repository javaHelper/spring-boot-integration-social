create table actor (
       actor_id bigint not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        last_updated date,
        primary key (actor_id)
    ) engine=InnoDB;