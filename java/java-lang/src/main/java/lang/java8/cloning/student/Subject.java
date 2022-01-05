package lang.java8.cloning.student;

public class Subject {

    private String name;

    public Subject() {
    }

    public Subject(String _name) {
        setName(_name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
