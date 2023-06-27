CREATE TABLE TB_PRODUCT
(
    UUID          VARCHAR(36) NOT NULL,
    name          VARCHAR(255),
    description   VARCHAR(255),
    price         DOUBLE,
    stock         INT,
    image         VARCHAR(255),
    category_uuid VARCHAR(255),
    PRIMARY KEY (UUID),
    CONSTRAINT FK_CATEGORY_UUID FOREIGN KEY (category_uuid) REFERENCES TB_CATEGORY (UUID)
);
