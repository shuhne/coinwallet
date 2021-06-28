create table if not exists coinwallets
(
    id bigserial not null
        constraint coinwallets_pk
            primary key,
    coincurrency varchar(5) not null,
    coinvalue varchar(255) not null,
    owner varchar(255) not null
);

