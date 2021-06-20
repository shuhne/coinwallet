CREATE TABLE if not exist coinwallets
(
    id integer NOT NULL,
    coincurrency character varying(255) NOT NULL,
    coinvalue character varying(255) NOT NULL,
    CONSTRAINT coinwallets_pk PRIMARY KEY (id)
)
