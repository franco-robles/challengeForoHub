CREATE TABLE usuarios
(
    id     SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    email  VARCHAR(255),
    password VARCHAR(255)

);
CREATE TABLE topicos
(
    id             SERIAL PRIMARY KEY,
    titulo         VARCHAR(255),
    mensaje        TEXT,
    fecha_creacion TIMESTAMP,
    status         VARCHAR(255),
    curso          VARCHAR(255),
    autor_id       BIGINT,
    FOREIGN KEY (autor_id) REFERENCES usuarios (id)
);