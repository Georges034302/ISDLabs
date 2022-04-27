DROP TABLE USERS;

CREATE TABLE USERS(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    EMAIL VARCHAR(255) UNIQUE NOT NULL,
    "NAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);

INSERT INTO USERS (EMAIL,"NAME",PASSWORD,PHONE)
VALUES 
    ('john.smith@uts.com','John Smith','hello123','95959595'),
    ('alen.david@example.com','David Alen Jones','demo123','95950000'),
    ('jim.l@uts.com','Jim Lee','jim123','95000055'),
    ('emilia.a@gmail.com','Emilia Adams','adams123','88889999'),
    ('carl.r@uts.com','Carl Ridle','mmm123','91910011'),
    ('paula.costa@uts.com','Paula Costa','uts123','95591001'),
    ('jess.jones@example.com','Jessica Jones','hijess123','95957775'),
    ('carol.k@gmail.com','Carol Knox','knox123','88880000'),
    ('andy.b@uts.com','Andreas Brehme','ger123','88009595');

SELECT * FROM USERS;



