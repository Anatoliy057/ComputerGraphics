package stud.task.drawer.line;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DDALine extends AbstractLineDrawer {

    public DDALine(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    public DDALine() {
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2, Color c) {
        double x = x1, y = y1;
        double dx = x2 - x1;
        double dy = y2 - y1;
        double D = Math.max(Math.abs(dx), Math.abs(dy));
        for (int i = 0; i < D; i++) {
            y += dy / D;
            x += dx / D;
            pd.pixel((int) Math.round(x), (int) Math.round(y), c);
        }
    }
}
