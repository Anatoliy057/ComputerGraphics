package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class OffSet32 extends Number implements Comparable<OffSet32> {
    private final UInt32 value;

    public OffSet32(UInt32 value) {
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
    public int compareTo(OffSet32 o) {
        return (int) (longValue() - o.longValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OffSet32 offSet32 = (OffSet32) o;
        return Objects.equals(value, offSet32.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OffSet32.class.getSimpleName() + "[", "]")
                .add("value=" + value.longValue())
                .toString();
    }
}
