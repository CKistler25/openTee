-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER teams_final_owner
WITH PASSWORD 'password';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO teams_final_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO teams_final_owner;

CREATE USER teams_final_appuser
WITH PASSWORD 'password';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO teams_final_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO teams_final_appuser;
