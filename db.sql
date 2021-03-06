USE [master]
GO
/****** Object:  Database [bms]    Script Date: 7/7/2015 11:56:45 AM ******/
CREATE DATABASE [bms]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'bms', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\bms.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'bms_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\bms_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [bms] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [bms].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [bms] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [bms] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [bms] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [bms] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [bms] SET ARITHABORT OFF 
GO
ALTER DATABASE [bms] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [bms] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [bms] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [bms] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [bms] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [bms] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [bms] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [bms] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [bms] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [bms] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [bms] SET  DISABLE_BROKER 
GO
ALTER DATABASE [bms] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [bms] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [bms] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [bms] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [bms] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [bms] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [bms] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [bms] SET RECOVERY FULL 
GO
ALTER DATABASE [bms] SET  MULTI_USER 
GO
ALTER DATABASE [bms] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [bms] SET DB_CHAINING OFF 
GO
ALTER DATABASE [bms] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [bms] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [bms]
GO
/****** Object:  Table [dbo].[Currency]    Script Date: 7/7/2015 11:56:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Currency](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Currency] [int] NULL,
	[Doubloons] [int] NULL,
 CONSTRAINT [PK_Doubloon] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Pirate]    Script Date: 7/7/2015 11:56:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Pirate](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [varchar](150) NULL,
	[LastName] [varchar](150) NULL,
	[ShipName] [varchar](150) NULL,
	[PirateName] [varchar](150) NULL,
 CONSTRAINT [PK_Pirate] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ship]    Script Date: 7/7/2015 11:56:45 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Ship](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ShipName] [varchar](150) NULL,
	[Doubloons] [int] NULL,
 CONSTRAINT [PK_Ship] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Currency] ON 

INSERT [dbo].[Currency] ([ID], [Currency], [Doubloons]) VALUES (1, 0, 6942)
SET IDENTITY_INSERT [dbo].[Currency] OFF
SET IDENTITY_INSERT [dbo].[Pirate] ON 

INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1, N'Davey', N'Blamey', N'S.S. Minow', N'Davy "Voodoo" Blamey')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (2, N'James', N'Bowen', N'The Barbaric Abandoned', N'Executioner')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (3, N'Clancy', N'Crumps', N'The Sea Killer', N'Roadkill')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (4, N'Agnes', N'Stone', N'The Speedy Revenge', N'Haggis Queen')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (5, N'Ben', N'Bailey', N'The Rising Hangman', N'The Driver')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (6, N'Billy', N'Mays', N'Black Hydro', N'Beefcake')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (7, N'Harry', N'Blackheart', N'Bird of Thousand Colors', N'The Dishoner of the North')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (8, N'Jen', N'Hen', N'The Barbaric Abandoned', N'Cluckington')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (9, N'Gretchen', N'Graves', N'The Speedy Revenge', N'Grave Digger')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (10, N'Caitlyn', N'Stark', N'Black Hydro', N'Lady Stoneheart')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (11, N'Joe', N'Sugar', N'S.S. Minow', N'Sloppy Joe')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1002, N'Salladhor', N'Saan', N'The Sea Killer', N'Prince of the Narrow Sea')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1003, N'null', N'null', N'The Barbaric Abandoned', N'null')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1004, N'Frankie', N'Muniz', N'The Barbaric Abandoned', N'Mad Malcolm')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1005, N'Ken', N'Burns', N'The Sea Killer', N'The Documentarian')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1006, N'Sam', N'Smith', N'The Rising Hangman', N'Smitty')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1007, N'a', N'a', N'The Barbaric Abandoned', N'a')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1008, N'sdfg', N'sdfg', N'The Speedy Revenge', N'dsfg')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1009, N'sadfasdf', N'asdfa', N'{"ship":"S.S. Minow","doubloons":"546"}', N'aafafdsfdasf')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1010, N'asas', N'asas', N'{"ship":"The Barbaric Abandoned","doubloons":"132"}', N'asas')
INSERT [dbo].[Pirate] ([ID], [FirstName], [LastName], [ShipName], [PirateName]) VALUES (1011, N'asdf', N'asdf', N'S.S. Minow', N'asdf')
SET IDENTITY_INSERT [dbo].[Pirate] OFF
SET IDENTITY_INSERT [dbo].[Ship] ON 

INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (1, N'S.S. Minow', 546)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (2, N'The Barbaric Abandoned', 132)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (3, N'The Sea Killer', 3456)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (4, N'The Speedy Revenge', 432)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (5, N'The Rising Hangman', 333)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (6, N'Black Hydro', 581)
INSERT [dbo].[Ship] ([ID], [ShipName], [Doubloons]) VALUES (7, N'Bird of Thousand Colors', 342)
SET IDENTITY_INSERT [dbo].[Ship] OFF
USE [master]
GO
ALTER DATABASE [bms] SET  READ_WRITE 
GO
