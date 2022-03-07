DROP TABLE IF EXISTS persona;

CREATE TABLE persona
(
    id INTEGER PRIMARY KEY auto_increment,
    documento INT, nombre VARCHAR(128), apellido VARCHAR(128), fecha_Nac DATE
);

DROP TABLE IF EXISTS articulo;

CREATE TABLE articulo
(
    id INTEGER PRIMARY KEY auto_increment,
    titulo VARCHAR(256),
    contenido VARCHAR(256),
    autor_id INT/*,
    FOREIGN KEY (autor_id) REFERENCES persona(documento)*/
);