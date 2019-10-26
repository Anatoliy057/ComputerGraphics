package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class UInt24 extends Number implements Comparable<UInt24> {
    private final int value;

    public UInt24(int value) throws UnsignedException {
        if (value < 0) throw new UnsignedException(value);
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
    public int compareTo(UInt24 o) {
        return intValue() - o.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UInt24 uInt24 = (UInt24) o;
        return value == uInt24.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UInt24.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
