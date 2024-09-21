Employee
    emp_id
    dept_id
    salary

Dept
    dept_id
    dept_name


dept_name, salary

select
    max(e.salary),

from
    Employee e, Dept d, (select distinct d2.dept_name from Dept d2) d2
where
    e.dept_id = d.dept_id
and
    d2.dept_id != d.dept_id
and
    d2.dept_name = d.dept_name
group by
    dep2.d_name;