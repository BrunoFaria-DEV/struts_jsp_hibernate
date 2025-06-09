-- Cria o banco de dados
CREATE DATABASE "struts_jsp_hibernate";

-- Depois de executar o comando acima, conecte-se ao banco recém-criado antes de rodar os próximos comandos.

-- Criação das tabelas
CREATE TABLE "municipios"(
    "id" SERIAL PRIMARY KEY,
    "nome" VARCHAR(120) NOT NULL
);

CREATE TABLE "usuarios" (
    "id" SERIAL PRIMARY KEY,
    "nome" VARCHAR(120) NOT NULL,
    "email" VARCHAR(220) NOT NULL,
    "CPF" VARCHAR(14),
    "municipio_id" INTEGER,
    FOREIGN KEY ("municipio_id") REFERENCES "municipios"("id")
);

INSERT INTO "municipios" ("nome") VALUES 
('São Paulo'),
('Rio de Janeiro'),
('Belo Horizonte'),
('Porto Alegre'),
('Curitiba'),
('Brasília'),
('Salvador'),
('Recife'),
('Fortaleza'),
('Manaus'),
('Belém'),
('Goiânia'),
('Campinas'),
('São Luís'),
('Natal'),
('João Pessoa'),
('Teresina'),
('Maceió'),
('Aracaju'),
('Cuiabá'),
('Campo Grande'),
('Florianópolis'),
('Vitória'),
('Uberlândia'),
('Ribeirão Preto'),
('Sorocaba'),
('Juiz de Fora'),
('Niterói'),
('Santo André'),
('São Bernardo do Campo'),
('Osasco'),
('Contagem'),
('Londrina'),
('Joinville'),
('Anápolis'),
('Pelotas'),
('Caxias do Sul'),
('Macapá'),
('Boa Vista'),
('Porto Velho'),
('Rio Branco'),
('Apucarana'),
('Maringá'),
('Cascavel'),
('Itajaí'),
('Blumenau'),
('Chapecó'),
('Feira de Santana'),
('Petrolina'),
('Caruaru');


-- Criação do usuário
CREATE USER "struts_jsp_hibernate" WITH PASSWORD 'struts_jsp_hibernate';

-- Permissões de conexão ao banco
GRANT CONNECT ON DATABASE "struts_jsp_hibernate" TO "struts_jsp_hibernate";

-- Permissões no schema público
GRANT USAGE ON SCHEMA public TO "struts_jsp_hibernate";

-- Permissões em todas as tabelas existentes
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO "struts_jsp_hibernate";

-- Permissões em todas as sequências existentes (necessárias para colunas SERIAL/IDENTITY)
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA public TO "struts_jsp_hibernate";

-- Permissões para tabelas futuras no schema public
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO "struts_jsp_hibernate";

-- Permissões para sequências futuras no schema public
ALTER DEFAULT PRIVILEGES IN SCHEMA public
GRANT USAGE, SELECT, UPDATE ON SEQUENCES TO "struts_jsp_hibernate";

CREATE SEQUENCE hibernate_sequence;

SELECT relname FROM pg_class WHERE relkind = 'S' AND relname LIKE '%municipios%';

SELECT relname FROM pg_class WHERE relkind = 'S' AND relname LIKE '%usuarios%';

SELECT relname FROM pg_class WHERE relkind = 'S' AND relname LIKE '%hibernate_sequence%';


