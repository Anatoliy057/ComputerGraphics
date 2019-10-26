package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class Int8 extends Number implements Comparable<Int8> {
    private final byte value;

    public Int8(byte value) {
        this.value = value;
    }

    @Override
    public int intValue() {
        return (int) value;
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
    public int compareTo(Int8 o) {
        return byteValue() - o.byteValue();
    }

    @Override
    public byte byteValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Int8 int8 = (Int8) o;
        return value == int8.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Int8.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
