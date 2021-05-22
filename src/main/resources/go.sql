CREATE TABLE menu (idM INT NOT NULL AUTO_INCREMENT,
                   name VARCHAR(30) NOT NULL,
                   category ENUM('starters','salads',
                       'main_dishes','meat','fish_and_seafoods',
                       'side_dishes','sauces','desserts',
                       'beverages') NOT NULL ,
                   price INT NOT NULL,
                   PRIMARY KEY (idM)                            );

CREATE TABLE orders (idO INT NOT NULL AUTO_INCREMENT,
                     state ENUM('fresh','preparing','delivering','done'),
                     address VARCHAR(40) NOT NULL,
                     name VARCHAR(30),
                     sum INT,
                     PRIMARY KEY (idO)                              );

CREATE TABLE menu_orders(idO INT NOT NULL,
                         idM INT NOT NULL,
                         quantity INT NOT NULL,
                         FOREIGN KEY (idM) REFERENCES menu (idM),
                         FOREIGN KEY (idO) REFERENCES orders (idO)
                                                                    );
CREATE TABLE authority (idA INT NOT NULL AUTO_INCREMENT,
                        authority VARCHAR(20) NOT NULL,
                        PRIMARY KEY (idA)              );
CREATE TABLE users (idU INT NOT NULL AUTO_INCREMENT,
                    name VARCHAR(30) NOT NULL ,
                    pass VARCHAR(30) NOT NULL ,
                    authority_id INT NOT NULL ,
                    PRIMARY KEY (idU),
                    FOREIGN KEY (authority_id) REFERENCES authority(idA));
DROP TABLE menu_orders;
DROP TABLE orders;
