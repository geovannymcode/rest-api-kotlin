INSERT INTO PERSONA(documento, nombre, apellido, fecha_Nac)
VALUES (123456,'Geovanny','Mendoza',TO_DATE('20-09-1990','dd-MM-yyyy')),
       (654321,'Yohana','Guerra',TO_DATE('13-02-1995','dd-MM-yyyy'));

INSERT INTO ARTICULO(titulo, contenido/*, autor_id*/)
VALUES ('Kotlin','All Relation with Kotlin'/*,123456*/);