package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public interface AcrDrawer {

    void setPixelDrawer(PixelDrawer pd);

    void draw(int x, int y, int a, int b, double angle1, double angle2, Color c);
}
