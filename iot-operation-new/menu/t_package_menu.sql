
-- 初始化菜单
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES (1, '套餐管理', 'meal/package/index', NULL, 0, 0, 'icon-menu', 0, 0, 0, 10000, now(), 10000, now());


set @menuId = @@identity;

INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '查看', '', 'meal:package:page', 1, 0, '', 0, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '新增', '', 'meal:package:save', 1, 0, '', 1, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '修改', '', 'meal:package:update,meal:package:info', 1, 0, '', 2, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '删除', '', 'meal:package:delete', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
INSERT INTO sys_operation_menu (pid, name, url, authority, type, open_style, icon, sort, version, deleted, creator, create_time, updater, update_time) VALUES ((SELECT @menuId), '导出', '', 'meal:package:export', 1, 0, '', 3, 0, 0, 10000, now(), 10000, now());
