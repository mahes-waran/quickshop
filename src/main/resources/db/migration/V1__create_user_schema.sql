-- Create isolated schema
CREATE SCHEMA IF NOT EXISTS user_mgmt;

-- 1. Users Table inside user_mgmt schema
CREATE TABLE IF NOT EXISTS user_mgmt.users (
                                               id BIGSERIAL PRIMARY KEY,
                                               first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    is_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
                             );

-- 2. Addresses Table inside user_mgmt schema
CREATE TABLE IF NOT EXISTS user_mgmt.addresses (
                                                   id BIGSERIAL PRIMARY KEY,
                                                   user_id BIGINT NOT NULL,
                                                   street_line1 VARCHAR(255) NOT NULL,
    street_line2 VARCHAR(255),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    country VARCHAR(100) NOT NULL,
    is_default_shipping BOOLEAN NOT NULL DEFAULT FALSE,
    is_default_billing BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_address_user FOREIGN KEY (user_id) REFERENCES user_mgmt.users(id) ON DELETE CASCADE
    );

-- Indexes
CREATE INDEX IF NOT EXISTS idx_users_email ON user_mgmt.users(email);
CREATE INDEX IF NOT EXISTS idx_addresses_user_id ON user_mgmt.addresses(user_id);