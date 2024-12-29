insert into c_security_permission (id, created, modified, created_by, modified_by, permission_label,permission_value)
VALUES ('P001','2024-12-18 00:00:00',null, 'SYSTEM',null, 'Permission Admin','PERMISSION_ADMIN');
insert into c_security_permission (id, created, modified, created_by, modified_by, permission_label,permission_value)
VALUES ('P002','2024-12-18 00:00:00',null, 'SYSTEM',null, 'Permission Member','PERMISSION_MEMBER');

insert into c_security_role (id, created, modified, created_by, modified_by, description,name,user_type)
VALUES ('R001','2024-12-18 00:00:00',null, 'SYSTEM',null, 'Default Admin Role','Role Admin','ADMIN');
insert into c_security_role (id, created, modified, created_by, modified_by, description,name,user_type)
VALUES ('R002','2024-12-18 00:00:00',null, 'SYSTEM',null, 'Default Member Role','Role Member','MEMBER');

insert into c_security_role_permission (id_role, id_permission) VALUES ('R001','P001');
insert into c_security_role_permission (id_role, id_permission) VALUES ('R002','P002');


insert into c_security_user (id, created, modified, created_by, modified_by, username,email,phone, active, id_role) VALUES
    ('default_admin','2024-12-18 00:00:00', null, 'SYSTEM',null , 'admin', 'admin.app@yopmail.com','081312501996', true, 'R001');

insert into c_security_user_password (id_user, created, modified, created_by, modified_by, user_password) VALUES
    ('default_admin','2024-12-18 00:00:00', null, 'SYSTEM', null, '$2a$08$LS3sz9Ft014MNaIGCEyt4u6VflkslOW/xosyRbinIF9.uaVLpEhB6');