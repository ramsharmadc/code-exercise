package javalang;

import java.util.Date;
import java.util.Objects;

public class OneImmutableClass {

    private String name;
    private Integer id;
    private Date createdOn;

    public OneImmutableClass() {
        // nothing
    }

    public OneImmutableClass(String name, Integer id, Date createdOn) {
        this.name = name;
        this.id = id;
        this.createdOn = createdOn;
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

    @Override
    protected OneImmutableClass clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("CLone of this class is not supported.");
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.id);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        OneImmutableClass that = (OneImmutableClass) o;
        return this.id.equals(that.id) && this.name.equals(that.name);
    }
}
