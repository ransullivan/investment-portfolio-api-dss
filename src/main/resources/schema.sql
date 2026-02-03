CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS pgcrypto;


CREATE TABLE IF NOT EXISTS unit_prices (
    id UUID PRIMARY KEY,
    nav_date DATE NOT NULL UNIQUE,
    price NUMERIC(19,4) NOT NULL
);

CREATE TABLE IF NOT EXISTS investment_transactions (
    id UUID PRIMARY KEY,
    transaction_date DATE NOT NULL,
    units NUMERIC(19,4) NOT NULL
);
