ALTER TABLE books
    CHANGE coverImage cover_image VARCHAR (255);

ALTER TABLE books
    ADD is_deleted BIT(1) NULL;

ALTER TABLE books
    MODIFY is_deleted BIT (1) NOT NULL;

ALTER TABLE books
DROP
COLUMN isDeleted;