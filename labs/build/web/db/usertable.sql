CREATE TABLE MOVIE(
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    "NAME" VARCHAR(255) NOT NULL,
    GENRE VARCHAR(255) NOT NULL,
    RATING INTEGER NOT NULL,
    "YEAR" INTEGER NOT NULL,
    PRICE DOUBLE NOT NULL,
    URL VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);


