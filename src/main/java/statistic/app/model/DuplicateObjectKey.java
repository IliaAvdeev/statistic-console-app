package statistic.app.model;

import java.util.Objects;

public class DuplicateObjectKey {
    private String group;
    private String type;

    public DuplicateObjectKey(String group, String type) {
        this.group = group;
        this.type = type;
    }

    public static DuplicateObjectKey of(ObjectItem objectItem) {
        return new DuplicateObjectKey(objectItem.getGroup(), objectItem.getType());
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        DuplicateObjectKey other = (DuplicateObjectKey) object;
        return Objects.equals(group, other.group) && Objects.equals(type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, type);
    }

    @Override
    public String toString() {
        return "[group='" + group + "+type='" + type + "]";
    }
}