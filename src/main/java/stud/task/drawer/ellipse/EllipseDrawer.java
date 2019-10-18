package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public interface EllipseDrawer {

    void draw(int x, int y, int a, int b, Color c);

    void setPixelDrawer(PixelDrawer pd);
}
