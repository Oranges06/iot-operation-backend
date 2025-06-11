
-- 初始化菜单
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES (1, '设备', 'iot/device/index', NULL, 0, 0, 'icon-menu', 0, 0, 0, 10000, now(), 10000, now());


set @menuId = @@identity;

INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '查看', '', 'iot:device:page', 1, 0, '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '新增', '', 'iot:device:save', 1, 0, '', 1, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '修改', '', 'iot:device:update,iot:device:info', 1, 0, '', 2, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '删除', '', 'iot:device:delete', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '导出', '', 'iot:device:export', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
