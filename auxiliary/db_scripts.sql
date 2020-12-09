CREATE USER api_client IDENTIFIED BY '123';
CREATE DATABASE stocks;
GRANT INSERT ON stocks.* TO api_client;
GRANT DELETE ON stocks.* TO api_client;
GRANT CREATE ON stocks.* TO api_client;
GRANT SELECT ON stocks.* TO api_client;
GRANT UPDATE ON stocks.* TO api_client;