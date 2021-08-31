CREATE TABLE State (
                       id   INT          NOT NULL,
                       name VARCHAR(255) NULL,
                       CONSTRAINT pk_states PRIMARY KEY (id)
);

CREATE TABLE City (
                      id       INT          NOT NULL,
                      name     VARCHAR(255) NULL,
                      state_id INT          NOT NULL,
                      CONSTRAINT pk_city PRIMARY KEY (id)
);

ALTER TABLE City
    ADD CONSTRAINT FK_CITY_ON_STATE FOREIGN KEY (state_id) REFERENCES State (id);

CREATE TABLE Population (
                            id         INT NOT NULL,
                            city_id    INT NOT NULL,
                            year       INT NULL,
                            total INT NULL,
                            CONSTRAINT pk_population PRIMARY KEY (id)
);

ALTER TABLE Population
    ADD CONSTRAINT FK_POPULATION_ON_CITY FOREIGN KEY (city_id) REFERENCES City (id);

