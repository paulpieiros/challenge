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
insert into Registrant(id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212');

insert into Usuario(id, nombre, password, tipo_Usuario, estado, fecha_creacion) values (0, 'admin', '1234567', 'ADMIN', 'ACT', Sysdate);
insert into Usuario(id, nombre, password, tipo_Usuario, estado, fecha_creacion) values (1, 'usuario1', '1234567', 'NORMAL', 'ACT', Sysdate);
insert into Usuario(id, nombre, password, tipo_Usuario, estado, fecha_creacion) values (2, 'usuario2', '1234567', 'NORMAL', 'ACT', Sysdate);
insert into Usuario(id, nombre, password, tipo_Usuario, estado, fecha_creacion) values (3, 'usuario3', '1234567', 'NORMAL', 'ACT', Sysdate);

insert into Comida(id, nombre, descripcion, estado, fecha_creacion) values (0, 'comida0', 'comida 0 compuesta de ingredites 0', 'ACT', Sysdate);
insert into Comida(id, nombre, descripcion, estado, fecha_creacion) values (1, 'comida1', 'comida 1 compuesta de ingredites 1', 'ACT', Sysdate);
insert into Comida(id, nombre, descripcion, estado, fecha_creacion) values (2, 'comida2', 'comida 2 compuesta de ingredites 2', 'ACT', Sysdate);

insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (0, 0, 1, true, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (1, 1, 1, false, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, estado, fecha_creacion) values (2, 2, 1, 'ACT', Sysdate);

insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (3, 0, 2, true, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, estado, fecha_creacion) values (4, 1, 2, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, estado, fecha_creacion) values (5, 2, 2, 'ACT', Sysdate);

insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (6, 0, 3, false, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (7, 1, 3, true, 'ACT', Sysdate);
insert into ComidaUsuario(id, comida_id, usuario_id, meGusta, estado, fecha_creacion) values (8, 2, 3, true, 'ACT', Sysdate);


