#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER amch WITH PASSWORD '123456';
    CREATE DATABASE labs_amch_db;
    GRANT ALL PRIVILEGES ON DATABASE labs_amch_db TO amch;
    GRANT USAGE, CREATE ON SCHEMA public TO amch;
    GRANT USAGE, CREATE ON SCHEMA public TO postgres;
EOSQL