package stud.task.ttf.types;

import java.util.StringJoiner;

public final class FWord extends Number implements Comparable<FWord> {
    private final Int16 value;

    public FWord(Int16 value) {
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
    public int compareTo(FWord o) {
        return value.compareTo(o.value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FWord.class.getSimpleName() + "[", "]")
                .add("value=" + value.shortValue())
                .toString();
    }
}
