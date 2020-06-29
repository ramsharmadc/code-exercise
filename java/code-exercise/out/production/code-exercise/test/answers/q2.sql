
-- mysql server version - 5.7

-- function to capitalize first character of ONE word
drop function if exists initCapWord;
create function initCapWord(s varchar(255)) 
returns varchar(255)
	return concat( Ucase(left(s,1)), Lcase(substring(s,2)) );
	
	
delimiter $$

-- function to capitalize first character of all the words
drop function if exists initCap;
create function initCap(oldName VARCHAR(255), delim VARCHAR(1), trimSpaces BOOL) 
returns varchar(255)
begin
  
	SET @oldString := oldName;
	SET @newString := "";
	
	tokenLoop: LOOP
	 IF trimSpaces THEN SET @oldString := TRIM(BOTH " " FROM @oldString);          
	 END IF;
	
	-- locate the delimter's first index
	SET @splitPoint := LOCATE(delim, @oldString);
	
	IF @splitPoint = 0 THEN
		SET @newString := CONCAT(@newString, initcapWord(@oldString));
		LEAVE tokenLoop;
	END IF;
	
	SET @newString := CONCAT(@newString, initcapWord(SUBSTRING(@oldString, 1, @splitPoint)));
	SET @oldString := SUBSTRING(@oldString, @splitPoint+1);
	END LOOP tokenLoop;
	
	RETURN @newString;
  
end $$

delimiter ;


-- Test queries
select initCap('hEllO','|', true);
select initCap('united sTates oF aMeRica',' ', true);