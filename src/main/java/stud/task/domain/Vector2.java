package stud.task.domain;

import java.util.Objects;
import java.util.StringJoiner;

public class Vector2 {

    private double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2 add(Vector2 v) {
        return new Vector2(getX() + v.getX(), getY() + v.getY());
    }

    public Vector2 multi(double b) {
        return new Vector2(getX() * b, getY() * b);
    }

    public Vector2 normalized() {
        double l = length();
        if (Math.abs(l) < 1e-10) {
            return new Vector2(0, 0);
        } else {
            return new Vector2(getX()/l, getY()/l);
        }
    }

    public double length() {
        return Math.sqrt(getX()*getX() + getY() * getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return Double.compare(vector2.x, x) == 0 &&
                Double.compare(vector2.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Vector2.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}
