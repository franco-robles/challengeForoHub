-- Actualizar la tabla usuarios
ALTER TABLE usuarios
    ALTER COLUMN nombre SET NOT NULL,
    ALTER COLUMN email SET NOT NULL,
    ALTER COLUMN password SET NOT NULL,
    ADD CONSTRAINT email_unique UNIQUE (email);

-- Actualizar la tabla topicos
ALTER TABLE topicos
    ALTER COLUMN titulo SET NOT NULL,
    ALTER COLUMN mensaje SET NOT NULL,
    DROP CONSTRAINT IF EXISTS topicos_mensaje_key, -- Asegúrate de que no haya constraint con ese nombre
    ADD CONSTRAINT titulo_unique UNIQUE (titulo),
    ADD CONSTRAINT mensaje_unique UNIQUE (mensaje),
    ALTER COLUMN autor_id SET NOT NULL;
