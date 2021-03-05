
-- mysql server version - 5.7

drop table if exists votes;

-- create the table
create table votes (name CHAR(10), votes INT);

-- insert records
insert into votes values
('Smith',10),
('Jones', 15),
('White', 20),
('Black', 40),
('Green', 50),
('Brown', 20);

-- query to rank order
-- assumption made -> name with same votes are ranked same.
select 
	name, 
	votes, 
	1 + (select count(*) from votes a where a.votes > b.votes) as rank
from votes b
order by b.votes desc;
