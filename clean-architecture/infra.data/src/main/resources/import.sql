INSERT INTO TB_CATEGORY(UUID, name) VALUES ('c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a', 'Livros');
INSERT INTO TB_CATEGORY(UUID, name) VALUES ('5d39567c-7293-4f5d-8dc3-39a4b24a49f2', 'Eletrônicos');
INSERT INTO TB_CATEGORY(UUID, name) VALUES ('46b920fa-af3a-4e2d-a408-fa821a947a5f', 'Roupas');

INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('6501f0a8-675e-46c5-a449-b0f3f2c81d6c', 'Livro A', 'Livro incrível A', 15.00, 100, 'url_imagem', 'c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('9401f0a8-675e-46c5-a449-b0f3f2c81d6a', 'Livro B', 'Livro incrível B', 20.00, 100, 'url_imagem', 'c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('2401f0a8-675e-46c5-a449-b0f3f2c81d6b', 'Livro C', 'Livro incrível C', 25.00, 100, 'url_imagem', 'c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('2301f0a8-675e-46c5-a449-b0f3f2c81d6c', 'Livro D', 'Livro incrível D', 30.00, 100, 'url_imagem', 'c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('1201f0a8-675e-46c5-a449-b0f3f2c81d6d', 'Livro E', 'Livro incrível E', 35.00, 100, 'url_imagem', 'c345ef1a-7e42-4fb1-a9d4-65d5c3a0671a');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('9901f0a8-675e-46c5-a449-b0f3f2c81d6e', 'TV 32"', 'TV LED 32"', 900.00, 50, 'url_imagem', '5d39567c-7293-4f5d-8dc3-39a4b24a49f2');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('8801f0a8-675e-46c5-a449-b0f3f2c81d6f', 'TV 42"', 'TV LED 42"', 1200.00, 50, 'url_imagem', '5d39567c-7293-4f5d-8dc3-39a4b24a49f2');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('7701f0a8-675e-46c5-a449-b0f3f2c81d6g', 'TV 52"', 'TV LED 52"', 1500.00, 50, 'url_imagem', '5d39567c-7293-4f5d-8dc3-39a4b24a49f2');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('6601f0a8-675e-46c5-a449-b0f3f2c81d6h', 'Notebook', 'Notebook Gamer', 3000.00, 30, 'url_imagem', '5d39567c-7293-4f5d-8dc3-39a4b24a49f2');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('5501f0a8-675e-46c5-a449-b0f3f2c81d6i', 'Celular', 'Celular Android', 800.00, 200, 'url_imagem', '5d39567c-7293-4f5d-8dc3-39a4b24a49f2');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('4401f0a8-675e-46c5-a449-b0f3f2c81d6j', 'Camiseta A', 'Camiseta estilosa A', 40.00, 300, 'url_imagem', '46b920fa-af3a-4e2d-a408-fa821a947a5f');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('3301f0a8-675e-46c5-a449-b0f3f2c81d6k', 'Camiseta B', 'Camiseta estilosa B', 40.00, 300, 'url_imagem', '46b920fa-af3a-4e2d-a408-fa821a947a5f');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('2201f0a8-675e-46c5-a449-b0f3f2c81d6l', 'Camiseta C', 'Camiseta estilosa C', 40.00, 300, 'url_imagem', '46b920fa-af3a-4e2d-a408-fa821a947a5f');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('1101f0a8-675e-46c5-a449-b0f3f2c81d6m', 'Calça Jeans', 'Calça Jeans estilosa', 80.00, 200, 'url_imagem', '46b920fa-af3a-4e2d-a408-fa821a947a5f');
INSERT INTO TB_PRODUCT(UUID, name, description, price, stock, image, category_uuid) VALUES ('9901f0a8-675e-46c5-a449-b0f3f2c81d6n', 'Vestido', 'Vestido estiloso', 100.00, 100, 'url_imagem', '46b920fa-af3a-4e2d-a408-fa821a947a5f');

INSERT INTO TB_USER(UUID, username, password) VALUES ('d48f0a57-72b2-4b3f-8b15-2b79c6ad8fb8', 'admin', '$2a$12$mMqys4.Z2iqK.5Qyt2Mcx.quRvCPms/zrKYDd89zklSce9rpGouYG');
INSERT INTO TB_USER(UUID, username, password) VALUES ('72c02c0c-e353-49c1-a1ee-d6122513d59e', 'guest', '$2a$12$tQTQtol77RA8cx13UmNSKeQH.uVmN1NQSla0HA.VtNi3hBkiHE7Q2');

INSERT INTO TB_USER_ROLES(USER_UUID, ROLES) VALUES ('d48f0a57-72b2-4b3f-8b15-2b79c6ad8fb8', 'ADMIN');
INSERT INTO TB_USER_ROLES(USER_UUID, ROLES) VALUES ('72c02c0c-e353-49c1-a1ee-d6122513d59e', 'GUEST');