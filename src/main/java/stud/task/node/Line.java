package stud.task.node;

import stud.task.drawer.line.LineDrawer;

import java.awt.*;

public class Line {

    private int x1, y1, x2, y2;
    private Color color;
    private LineDrawer ld;

    public Line(int x1, int y1, int x2, int y2, Color color, LineDrawer ld) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.ld = ld;
    }

    public Line(int x1, int y1, int x2, int y2, LineDrawer ld) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.ld = ld;
    }

    public void draw(Color c) {
        ld.draw(x1, y1, x2, y2, c);
    }

    public void draw() {
        draw(color);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public LineDrawer getLd() {
        return ld;
    }

    public void setLd(LineDrawer ld) {
        this.ld = ld;
    }
}
