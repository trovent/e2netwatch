-- Set password on root user on all hosts
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password AS '*315D050BFD5453A9B221D3E8F2D97262E99ADF53';
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password AS '*315D050BFD5453A9B221D3E8F2D97262E99ADF53';

-- Create new user middleware, if exists - clear first
DROP USER IF EXISTS 'middleware'@'%';
CREATE USER IF NOT EXISTS 'middleware'@'%' IDENTIFIED WITH mysql_native_password AS '*B6B7FE644D1C9144543F844AC153A09DC7DFEF29';
GRANT ALL ON user_management_db.* TO 'middleware'@'%';
GRANT ALL ON aql_db.* TO 'middleware'@'%';
