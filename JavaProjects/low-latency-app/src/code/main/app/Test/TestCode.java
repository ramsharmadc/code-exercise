package code.main.app.Test;

public class TestCode {

    public static void main(String[] args) {

        System.out.println("Test program");
    }
}


/** SQL TEST 

// Education Institue database
// COurses 
// Student enrol in Subjects


Student
Id  Name  Specialization
1 Ram       Computer_Science
2 Sharma    Stats

Course
Id Course_Name Duration Sem  Tutor 
1   Physics  50  first  Xyx
2   Maths   40  first   xyz
3   Computer Science second name1

Student_Enrolment
Id      Student_ID       Course_ID
1           1               1
2           1               2
3           1               3
4           2               1
1           2               3


// List of student who enrolled for atleast one course other than Maths

select s.*
from Student s
join Student_Enrolment se
on (se.Student_id == s.Id
and count(se.id) > 0
and se.course_id != 2)
group by se.id


// Student_Name, Course_Name
// condition Specialzation = COmputer_science

select s.Name, c.Course_Name
from Student s, Course c
where exists ( select 1 from Student_Enrolment se where se.Student_Id = s.Id and se.Course_id = c.course_id );


select s.Name, c.Course_Name
from Student S, Course C
join Student_Enrolment SE 
on SE.Student_Id = S.Id 
and SE.Course_id = C.course_id;

**/