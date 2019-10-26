package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class Int16 extends Number implements Comparable<Int16> {
    private final short value;

    public Int16(short value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public short shortValue() {
        return value;
    }

    @Override
    public int compareTo(Int16 o) {
        return intValue() - o.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int16 int16 = (Int16) o;
        return value == int16.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Int16.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
