CREATE TABLE member_information(
    id UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    date_of_birth TIMESTAMP   NOT NULL,
    address JSONB,
    PRIMARY KEY (id)
);