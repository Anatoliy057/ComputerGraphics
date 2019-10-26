package stud.task.ttf.types;

import java.util.Objects;
import java.util.StringJoiner;

public final class UFWord extends Number implements Comparable<UFWord> {
    private final UInt16 value;

    public UFWord(UInt16 value) {
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
    public int compareTo(UFWord o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UFWord ufWord = (UFWord) o;
        return Objects.equals(value, ufWord.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UFWord.class.getSimpleName() + "[", "]")
                .add("value=" + value.intValue())
                .toString();
    }
}
