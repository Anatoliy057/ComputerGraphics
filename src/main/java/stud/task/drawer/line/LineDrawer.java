package stud.task.drawer.line;

import stud.task.converter.ScreenPoint;
import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public interface LineDrawer {

    void draw(int x1, int y1, int x2, int y2, Color c);

    default void draw(ScreenPoint p1, ScreenPoint p2, Color c) {
        this.draw(p1.getI(), p1.getJ(), p2.getI(), p2.getJ(), c);
    }

    void setPixelDrawer(PixelDrawer pd);
}
