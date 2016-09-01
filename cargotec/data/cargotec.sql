/*
Navicat SQL Server Data Transfer

Source Server         : CARGOTEC
Source Server Version : 110000
Source Host           : 192.168.178.109:1433
Source Database       : EXCEL_DB
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 110000
File Encoding         : 65001

Date: 2016-09-01 17:51:01
*/


-- ----------------------------
-- Table structure for files
-- ----------------------------
DROP TABLE [files]
GO
CREATE TABLE [files] (
[file_id] bigint NOT NULL IDENTITY(1,1) ,
[createdDate] datetime2(7) NULL ,
[name] varchar(255) NULL ,
[status] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of files
-- ----------------------------
BEGIN TRANSACTION
GO
SET IDENTITY_INSERT [files] ON
GO
SET IDENTITY_INSERT [files] OFF
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for images
-- ----------------------------
DROP TABLE [images]
GO
CREATE TABLE [images] (
[image_id] bigint NOT NULL IDENTITY(1,1) ,
[model_id] bigint NULL ,
[filename] varchar(255) NULL ,
[status] varchar(1) NULL ,
[url] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of images
-- ----------------------------
BEGIN TRANSACTION
GO
SET IDENTITY_INSERT [images] ON
GO
SET IDENTITY_INSERT [images] OFF
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for models
-- ----------------------------
DROP TABLE [models]
GO
CREATE TABLE [models] (
[model_id] bigint NOT NULL IDENTITY(1,1) ,
[code] varchar(255) NULL ,
[englishTitle] varchar(255) NULL ,
[fileId] bigint NULL ,
[koreanTitle] varchar(255) NULL ,
[logoBrand] varchar(255) NULL ,
[month] varchar(255) NULL ,
[parentId] bigint NULL ,
[year] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of models
-- ----------------------------
BEGIN TRANSACTION
GO
SET IDENTITY_INSERT [models] ON
GO
SET IDENTITY_INSERT [models] OFF
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Table structure for parts
-- ----------------------------
DROP TABLE [parts]
GO
CREATE TABLE [parts] (
[part_id] bigint NOT NULL IDENTITY(1,1) ,
[code] varchar(255) NULL ,
[model_id] bigint NULL ,
[englishDescription] varchar(255) NULL ,
[koreanDescription] varchar(255) NULL ,
[no] varchar(255) NULL ,
[partNo] varchar(255) NULL ,
[quantity] varchar(255) NULL ,
[remarks] varchar(255) NULL 
)


GO

-- ----------------------------
-- Records of parts
-- ----------------------------
BEGIN TRANSACTION
GO
SET IDENTITY_INSERT [parts] ON
GO
SET IDENTITY_INSERT [parts] OFF
GO
COMMIT TRANSACTION
GO

-- ----------------------------
-- Indexes structure for table files
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table files
-- ----------------------------
ALTER TABLE [files] ADD PRIMARY KEY ([file_id])
GO

-- ----------------------------
-- Uniques structure for table files
-- ----------------------------
ALTER TABLE [files] ADD UNIQUE ([name] ASC)
GO

-- ----------------------------
-- Indexes structure for table images
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table images
-- ----------------------------
ALTER TABLE [images] ADD PRIMARY KEY ([image_id])
GO

-- ----------------------------
-- Uniques structure for table images
-- ----------------------------
ALTER TABLE [images] ADD UNIQUE ([filename] ASC)
GO

-- ----------------------------
-- Indexes structure for table models
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table models
-- ----------------------------
ALTER TABLE [models] ADD PRIMARY KEY ([model_id])
GO

-- ----------------------------
-- Uniques structure for table models
-- ----------------------------
ALTER TABLE [models] ADD UNIQUE ([code] ASC, [fileId] ASC, [englishTitle] ASC, [koreanTitle] ASC)
GO

-- ----------------------------
-- Indexes structure for table parts
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table parts
-- ----------------------------
ALTER TABLE [parts] ADD PRIMARY KEY ([part_id])
GO
