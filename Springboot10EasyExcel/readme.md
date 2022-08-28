* ===================Mysql==========================
* DROP TABLE IF EXISTS t_hospital;
* CREATE TABLE t_hospital(
*     hos_ID INT NOT NULL AUTO_INCREMENT  COMMENT '机构主键' ,
*     hos_name VARCHAR(255)    COMMENT '医院名称' ,
*     hos_code VARCHAR(255)    COMMENT '医院编码' ,
*     hos_tel VARCHAR(255)    COMMENT '联系电话' ,
*     hos_addr VARCHAR(255)    COMMENT '医院地址' ,
*     hos_lev VARCHAR(32)    COMMENT '医院等级' ,
*     status VARCHAR(255)    COMMENT '状态' ,
*     VerSION VARCHAR(32)    COMMENT '乐观锁' ,
*     CREATED_BY VARCHAR(32)    COMMENT '创建人' ,
*     CREATED_TIME DATETIME    COMMENT '创建时间' ,
*     UPDATED_BY VARCHAR(255)    COMMENT '更新人' ,
*     UPDATED_TIME DATETIME    COMMENT '更新时间' ,
*     PRIMARY KEY (hos_ID)
* )  COMMENT = '医院机构信息表';
*  ===================Mysql==========================
*  ===================oracle==========================
*  CREATE TABLE t_hospital(
*     hos_ID INT NOT NULL,
*     hos_name VARCHAR2(255),
*     hos_code VARCHAR2(255),
*     hos_tel VARCHAR2(255),
*     hos_addr VARCHAR2(255),
*     hos_lev VARCHAR2(32),
*     status VARCHAR2(255),
*     VerSION VARCHAR2(32),
*     CREATED_BY VARCHAR2(32),
*     CREATED_TIME DATE,
*     UPDATED_BY VARCHAR2(255),
*     UPDATED_TIME DATE,
*     PRIMARY KEY (hos_ID)
* );
*
* COMMENT ON TABLE t_hospital IS '医院机构信息表';
* COMMENT ON COLUMN t_hospital.hos_ID IS '机构主键';
* COMMENT ON COLUMN t_hospital.hos_name IS '医院名称';
* COMMENT ON COLUMN t_hospital.hos_code IS '医院编码';
* COMMENT ON COLUMN t_hospital.hos_tel IS '联系电话';
* COMMENT ON COLUMN t_hospital.hos_addr IS '医院地址';
* COMMENT ON COLUMN t_hospital.hos_lev IS '医院等级';
* COMMENT ON COLUMN t_hospital.status IS '状态';
* COMMENT ON COLUMN t_hospital.VerSION IS '乐观锁';
* COMMENT ON COLUMN t_hospital.CREATED_BY IS '创建人';
* COMMENT ON COLUMN t_hospital.CREATED_TIME IS '创建时间';
* COMMENT ON COLUMN t_hospital.UPDATED_BY IS '更新人';
* COMMENT ON COLUMN t_hospital.UPDATED_TIME IS '更新时间';
  *===================oracle==========================
  *===================sqlsever==========================
*
* IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[t_hospital]') AND type in (N'U'))
* DROP TABLE [dbo].[t_hospital];
* CREATE TABLE [dbo].[t_hospital](
*     hos_ID INT NOT NULL IDENTITY(1,1),
*     hos_name VARCHAR(255),
*     hos_code VARCHAR(255),
*     hos_tel VARCHAR(255),
*     hos_addr VARCHAR(255),
*     hos_lev VARCHAR(32),
*     status VARCHAR(255),
*     VerSION VARCHAR(32),
*     CREATED_BY VARCHAR(32),
*     CREATED_TIME DATETIME,
*     UPDATED_BY VARCHAR(255),
*     UPDATED_TIME DATETIME,
*     PRIMARY KEY (hos_ID)
* );
*
* EXEC sp_addextendedproperty 'MS_Description', '医院机构信息表', 'SCHEMA', dbo, 'table', t_hospital, null, null;
* EXEC sp_addextendedproperty 'MS_Description', '机构主键', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_ID;
* EXEC sp_addextendedproperty 'MS_Description', '医院名称', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_name;
* EXEC sp_addextendedproperty 'MS_Description', '医院编码', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_code;
* EXEC sp_addextendedproperty 'MS_Description', '联系电话', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_tel;
* EXEC sp_addextendedproperty 'MS_Description', '医院地址', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_addr;
* EXEC sp_addextendedproperty 'MS_Description', '医院等级', 'SCHEMA', dbo, 'table', t_hospital, 'column', hos_lev;
* EXEC sp_addextendedproperty 'MS_Description', '状态', 'SCHEMA', dbo, 'table', t_hospital, 'column', status;
* EXEC sp_addextendedproperty 'MS_Description', '乐观锁', 'SCHEMA', dbo, 'table', t_hospital, 'column', VerSION;
* EXEC sp_addextendedproperty 'MS_Description', '创建人', 'SCHEMA', dbo, 'table', t_hospital, 'column', CREATED_BY;
* EXEC sp_addextendedproperty 'MS_Description', '创建时间', 'SCHEMA', dbo, 'table', t_hospital, 'column', CREATED_TIME;
* EXEC sp_addextendedproperty 'MS_Description', '更新人', 'SCHEMA', dbo, 'table', t_hospital, 'column', UPDATED_BY;
* EXEC sp_addextendedproperty 'MS_Description', '更新时间', 'SCHEMA', dbo, 'table', t_hospital, 'column', UPDATED_TIME;
  *================================sqlsever*================================