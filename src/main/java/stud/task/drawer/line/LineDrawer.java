package stud.task.drawer.line;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public interface LineDrawer {

    void draw(int x1, int y1, int x2, int y2, Color c);

    void setPixelDrawer(PixelDrawer pd);
}
