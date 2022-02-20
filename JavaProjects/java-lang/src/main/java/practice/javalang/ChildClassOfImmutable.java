package javalang;

public class ChildClassOfImmutable extends OneImmutableClass{

    public void mutateParent(){
        this.getCreatedOn().setYear(2013);
    }
}
