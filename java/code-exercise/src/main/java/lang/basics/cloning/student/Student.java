package lang.basics.cloning.student;

public class Student implements Cloneable {

    private String name;
    private Subject subject;

    public Student(String _name, Subject _subject) {
        setName(_name);
        setSubject(_subject);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws CloneNotSupportedException {
        Subject sub = new Subject(this.getSubject().getName());
        Student st = new Student(this.getName(), sub);
        return st;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return getName() + " reads " + getSubject();
    }
}
