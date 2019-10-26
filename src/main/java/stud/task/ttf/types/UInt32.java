package stud.task.ttf.types;

public final class UInt32 extends Number implements Comparable<UInt32> {
    private final long value;

    public UInt32(long value) throws UnsignedException {
        if (value < 0) throw new UnsignedException(value);
        this.value = value;
    }

    @Override
    public int intValue() {
        return (int) value;
    }

    @Override
    public long longValue() {
        return value;
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
    public int compareTo(UInt32 o) {
        return (int) (longValue() - o.longValue());
    }
}
