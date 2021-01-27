CREATE PROCEDURE TextToSummarizeHeaderInsert_sp (
	@IdPerdoruesi INT
	,@IdLLojiTekstitInput INT
	)
AS
BEGIN
	INSERT INTO TextToSummarizeHeader
	VALUES (
		@IdPerdoruesi
		,GETDATE()
		,@IdLLojiTekstitInput
		)

	SELECT MAX(Id)
	FROM TextToSummarizeHeader AS Id
END

CREATE PROCEDURE TextToSummarizeDetailsInsert_sp (
	@IdHeader INT
	,@IdLlojiTekstitOutput INT
	,@TextToSummarize VARCHAR(max)
	,@SummarizedText VARCHAR(max)
	,@SummPercentage DECIMAL
	,@Feedback VARCHAR(max) NULL
	)
AS
BEGIN
	INSERT INTO TextToSummarizeDetails
	VALUES (
		@IdHeader
		,@IdLlojiTekstitOutput
		,@TextToSummarize
		,@SummarizedText
		,@SummPercentage
		,@Feedback
		)
END

CREATE PROCEDURE PerdoruesiInsert_sp (
	@Emri VARCHAR(max)
	,@Mbiemri VARCHAR(max)
	,@Email VARCHAR(max)
	,@Password VARCHAR(max)
	,@IdSubscription INT
	)
AS
BEGIN
	INSERT INTO Perdoruesi
	VALUES (
		@Emri
		,@Mbiemri
		,@Email
		,@Password
		,@IdSubscription
		)
END

CREATE PROCEDURE PerdoruesiSelectPerLogin_sp (
	@Email VARCHAR(max)
	,@Password VARCHAR(max)
	)
AS
BEGIN
	SELECT Id
		,Emri
		,Mbiemri
		,Email
		,Password
		,IdSubscription
	FROM Perdoruesi
	WHERE Email = @Email
		AND Password = @Password
END

CREATE PROCEDURE TextToSummarizeTableSelect_sp (
	@Id INT NULL
	,@IdPerdoruesi INT NULL
	)
AS
BEGIN
	SELECT H.Id
		,D.SummarizedText
		,H.DataERegjistrimit
	FROM TextToSummarizeHeader H
	INNER JOIN TextToSummarizeDetails D ON H.Id = D.IdHeader
	WHERE (
			@Id = H.Id
			OR @Id IS NULL
			)
		AND (
			@IdPerdoruesi = H.IdPerdoruesi
			OR @IdPerdoruesi IS NULL
			)
END
