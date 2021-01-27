CREATE DATABASE OATS_DB
USE OATS_DB
CREATE TABLE Subscriptions(
	Id int not null unique IDENTITY,
	Pershkrimi varchar(max)
)

CREATE TABLE LlojiTekstit(
	Id int not null unique IDENTITY,
	Pershkrimi varchar(max)
)

CREATE TABLE Perdoruesi(
	Id int not null unique IDENTITY,
	Emri varchar(max),
	Mbiemri varchar(max),
	Email varchar(max),
	Password varchar(max),
	IdSubscription int,
	FOREIGN KEY(IdSubscription) REFERENCES Subscriptions(Id)
)
	
CREATE TABLE TextToSummarizeHeader(
	Id int not null unique IDENTITY,
	IdPerdoruesi int not null,
	dataERegjistrimit datetime,
	IdLlojiTekstitInput int,
	FOREIGN KEY(IdLlojiTekstitInput) REFERENCES LlojiTekstit(Id),
	FOREIGN KEY(IdPerdoruesi) REFERENCES Perdoruesi(Id)
)

CREATE TABLE TextToSummarizeDetails(
	Id int not null unique IDENTITY,
	IdHeader int NOT null,
	IdLlojiTekstitOutput int,
	TextToSummarize varchar(max),
	SummarizedText varchar(max),
	SummPercentage decimal,
	Feedback varchar(max) null,
	FOREIGN KEY(IdHeader) REFERENCES TextToSummarizeHeader(Id),
	FOREIGN KEY(IdLlojiTekstitOutput) REFERENCES LlojiTekstit(Id)
)


