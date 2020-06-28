-- mysql server version - 5.7

-- drop table if exists
drop table if exists sometbl;

-- creating table
create table sometbl ( ID int, NAME varchar(50) );

-- insert test records
insert into sometbl VALUES 
(1, 'Smith'), 
(2, 'Julio|Jones|Falcons'), 
(3, 'White|Snow'), 
(4, 'Paint|It|Red'), 
(5, 'Green|Lantern'), 
(6, 'Brown|bag');

-- temporary table to store the expanded result
drop temporary table if exists temptable4query; 
create temporary table IF not exists temptable4query ( id int, name varchar(255) );

delimiter $$

-- a splitter function to split the delimied row
drop function if exists splitter;
create function splitter(x varchar(255), delim varchar(12), pos integer) 
returns varchar(255)
begin
  declare output varchar(255);
  set output = replace(substring(substring_index(x, delim, pos)
                 , length(substring_index(x, delim, pos - 1)) + 1)
                 , delim
                 , '');
  if output = '' then set output = null; end if;
  return output;
end $$


-- a procedure to use to expand the results
-- as a result, stored the expanded data in temp table
drop procedure if exists exploder;
create procedure exploder()
begin  
  declare i integer;

  set i = 1;
  repeat
   insert into temptable4query (id, name)
      select id, splitter(NAME, '|', i) from sometbl
      where splitter(NAME, '|', i) is not null;
      
    set i = i + 1;
    until row_count() = 0
  end repeat;
end $$

delimiter ;

-- call procedure to perform select
call exploder();

-- result is stored in temp table after the procedure finished
select * from temptable4query order by id ;