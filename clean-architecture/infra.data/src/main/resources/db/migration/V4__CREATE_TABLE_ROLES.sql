CREATE TABLE TB_USER_ROLES
(
    user_id VARCHAR(36),
    ROLES VARCHAR(36),
    FOREIGN KEY (user_id) REFERENCES tb_user (UUID)
);
