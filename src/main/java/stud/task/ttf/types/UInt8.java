package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class UInt8 extends Number implements Comparable<UInt8> {
    private final short value;

    public UInt8(short value) throws UnsignedException {
        if (value < 0) throw new UnsignedException(value);
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
    public short shortValue() {
        return value;
    }

    @Override
    public int compareTo(UInt8 o) {
        return shortValue() - o.shortValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UInt8 uInt8 = (UInt8) o;
        return value == uInt8.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UInt8.class.getSimpleName() + "[", "]")
                .add("value=" + value)
                .toString();
    }
}
