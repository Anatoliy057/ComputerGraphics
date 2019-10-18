package stud.task.drawer.ellipse;

import stud.task.drawer.line.LineDrawer;
import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public interface PieDrawer {

    void setPixelDrawer(PixelDrawer pd);

    void setLineDrawer(LineDrawer ld);

    void draw(int x, int y, int a, int b, double angle1, double angle2, Color c);
}
