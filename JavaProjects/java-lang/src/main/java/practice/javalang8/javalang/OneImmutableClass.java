package practice.javalang8.javalang;

import java.util.*;

public class OneImmutableClass {
   
    private final String name;
    private final Integer id;
    private final Date createdOn;
    private final Set<String> immutableSetOfStrings;

    public OneImmutableClass() {
        // nothing
        this(null, 0, null);
    }

    public OneImmutableClass(String name, Integer id, Date createdOn) {
        this.name = name;
        this.id = id;
        this.createdOn = createdOn;
        immutableSetOfStrings = Collections.unmodifiableSet(new HashSet<>());
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.id;
    }

    public Date getCreatedOn() {
        return new Date(this.createdOn.getTime());
    }

    public Set<String> getImmutableSetOfStrings() {
        return immutableSetOfStrings;
    }

    @Override
    protected OneImmutableClass clone() throws CloneNotSupportedException {
        super.clone();
        throw new CloneNotSupportedException("Clone of this class is not supported.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.id);
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        OneImmutableClass that = (OneImmutableClass) o;
        return this.id.equals(that.id) && this.name.equals(that.name);
    }
}
