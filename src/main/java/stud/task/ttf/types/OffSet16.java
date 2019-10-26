package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class OffSet16 extends Number implements Comparable<OffSet16>{
    private final UInt16 value;

    public OffSet16(UInt16 value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value.intValue();
    }

    @Override
    public long longValue() {
        return value.longValue();
    }

    @Override
    public float floatValue() {
        return value.floatValue();
    }

    @Override
    public double doubleValue() {
        return value.doubleValue();
    }

    @Override
    public int compareTo(OffSet16 o) {
        return intValue() - o.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffSet16 offSet16 = (OffSet16) o;
        return Objects.equals(value, offSet16.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OffSet16.class.getSimpleName() + "[", "]")
                .add("value=" + value.intValue())
                .toString();
    }
}
