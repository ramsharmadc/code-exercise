
-- mysql server version - 5.7

drop table if exists bugs;

create table bugs ( id INT, open_date date, close_date date, severity INT);

-- test data
insert into bugs values
(1, '2016-01-12', '2016-01-30', 3),
(2, '2016-02-11', '2016-03-15', 2),
(3, '2016-04-15', '2016-05-12', 4),
(4, '2016-05-10', '2016-06-10', 5),
(5, '2016-07-28', '2016-08-04', 2),
(6, '2016-09-12', '2016-10-15', 3),
(7, '2016-12-10', '2017-01-04', 3),
(8, '2017-01-03', '2017-02-15', 3),
(9, '2017-03-12', '2017-03-20', 5),
(10, '2017-05-03', '2017-05-10', 5),
(11, '2017-05-03', '2017-05-25', 2),
(12, '2017-05-03', '2017-05-25', 2),
(13, '2017-05-03', null, 2),
(14, '2017-05-03', null, 2);

-- temporary table to store all dates between a range
-- give you range in the 'between' clause of insert query
drop temporary table if exists dates_of_range; 

create temporary table IF not exists dates_of_range (dates date);

-- give you date range in the 'between' clause of insert query
insert into dates_of_range
select * from 
(select adddate('2000-01-01',t4.i*10000 + t3.i*1000 + t2.i*100 + t1.i*10 + t0.i) selected_date from
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t0,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t1,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t2,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t3,
 (select 0 i union select 1 union select 2 union select 3 union select 4 union select 5 union select 6 union select 7 union select 8 union select 9) t4) v
where selected_date 
between '2017-01-01' and '2017-05-30';


-- Main Query
-- gives count of bugs in open state on each day between a given range
select
 count(b.id) bugs_open, r.dates on_date
from bugs b, dates_of_range r
where b.open_date <= r.dates
and ( b.close_date is null 
		Or b.close_date > r.dates)
group by on_date;
 