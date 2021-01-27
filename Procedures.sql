CREATE PROCEDURE TextToSummarizeHeaderInsert_sp(
	@IdPerdoruesi int,
	@IdLLojiTekstitInput int
)
as begin
	INSERT INTO TextToSummarizeHeader VALUES(@IdPerdoruesi, GETDATE(), @IdLLojiTekstitInput)
	Select MAX(Id) FROM TextToSummarizeHeader as Id
END
	
CREATE PROCEDURE TextToSummarizeDetailsInsert_sp(
	@IdHeader int,
	@IdLlojiTekstitOutput int,
	@TextToSummarize varchar(max),
	@SummarizedText varchar(max),
	@SummPercentage decimal,
	@Feedback varchar(max) null
)
as begin
	INSERT INTO TextToSummarizeDetails VALUES(@IdHeader, @IdLlojiTekstitOutput, @TextToSummarize,@SummarizedText,@SummPercentage,@Feedback)
END

CREATE PROCEDURE PerdoruesiInsert_sp(
	@Emri varchar(max),
	@Mbiemri varchar(max),
	@Email varchar(max),
	@Password varchar(max),
	@IdSubscription int
) 
as begin		
	INSERT INTO Perdoruesi VALUES(@Emri, @Mbiemri, @Email,@Password,@IdSubscription)
END

CREATE PROCEDURE PerdoruesiSelectPerLogin_sp(
	@Email varchar(max),
	@Password varchar(max)
)as begin
	select Id,Emri,Mbiemri,Email,Password,IdSubscription from Perdoruesi where Email=@Email and Password=@Password
END