package stud.task.ttf.types;

import java.util.Arrays;
import java.util.StringJoiner;

public final class Tag {
    private final byte[] chars;

    public Tag(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Arrays.equals(chars, tag.chars);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(chars);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tag.class.getSimpleName() + "[", "]")
                .add("chars=" + Arrays.toString(chars))
                .toString();
    }
}
