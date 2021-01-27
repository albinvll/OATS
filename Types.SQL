CREATE DATABASE OATS_DB

USE OATS_DB

CREATE TABLE Subscriptions (
	Id INT NOT NULL UNIQUE IDENTITY
	,Pershkrimi VARCHAR(max)
	)

CREATE TABLE LlojiTekstit (
	Id INT NOT NULL UNIQUE IDENTITY
	,Pershkrimi VARCHAR(max)
	)

CREATE TABLE Perdoruesi (
	Id INT NOT NULL UNIQUE IDENTITY
	,Emri VARCHAR(max)
	,Mbiemri VARCHAR(max)
	,Email VARCHAR(max)
	,Password VARCHAR(max)
	,IdSubscription INT
	,FOREIGN KEY (IdSubscription) REFERENCES Subscriptions(Id)
	)

CREATE TABLE TextToSummarizeHeader (
	Id INT NOT NULL UNIQUE IDENTITY
	,IdPerdoruesi INT NOT NULL
	,dataERegjistrimit DATE
	,IdLlojiTekstitInput INT
	,FOREIGN KEY (IdLlojiTekstitInput) REFERENCES LlojiTekstit(Id)
	,FOREIGN KEY (IdPerdoruesi) REFERENCES Perdoruesi(Id)
	)

CREATE TABLE TextToSummarizeDetails (
	Id INT NOT NULL UNIQUE IDENTITY
	,IdHeader INT NOT NULL
	,IdLlojiTekstitOutput INT
	,TextToSummarize VARCHAR(max)
	,SummarizedText VARCHAR(max)
	,SummPercentage DECIMAL
	,Feedback VARCHAR(max) NULL
	,FOREIGN KEY (IdHeader) REFERENCES TextToSummarizeHeader(Id)
	,FOREIGN KEY (IdLlojiTekstitOutput) REFERENCES LlojiTekstit(Id)
	)
