--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

-- You can use this file to load seed data into the database using SQL statements

insert into Monstroes(id, name, email, telefone, data_nascimento) values (0, 'Luan Menegas', 'luan.menegas@bodybuilder.com', '2125551212', '1989-01-01');

insert into Enderecos(id, rua, numero, bairro, municipio, uf, cep, monstrao_id) values (0, 'Rua Menegas', 547, 'Batata doce', 'Shark City', 'SC',12345678, 0);

INSERT INTO public.estabelecimentos(id, documento, nome, telefone) VALUES (0, '12345678910', 'Casa da mãe Joana', '4898875412');

INSERT INTO pedidos(id, dh_entrega, dh_solicitacao, observacao, situacao, endereco_id, monstrao_id) VALUES (0, '2001-01-01 10:00', '2017-01-01 15:00', 'Eu quero cafeeeee', 'E', 0,0);