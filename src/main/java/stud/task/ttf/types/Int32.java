package stud.task.ttf.types;

public final class Int32 extends Number implements Comparable<Int32> {
    private final int value;

    public Int32(int value) {
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
    public int compareTo(Int32 o) {
        return intValue() - o.intValue();
    }
}
