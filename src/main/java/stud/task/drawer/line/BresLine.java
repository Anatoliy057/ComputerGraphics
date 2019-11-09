package stud.task.drawer.line;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BresLine extends AbstractLineDrawer {


    public BresLine(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    public BresLine() {
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2, Color c) {
        if (x1 == x2 && y1 == y2) {
            pd.pixel(x1, y1, c);
            return;
        }
        int dx, dy, e;
        int x = Math.abs(x1), y = Math.abs(y1);
        int incX = (int) Math.signum((dx = x2-x1));
        int incY = (int) Math.signum((dy = y2-y1));
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        if (dx > dy) {
            e = 2 * dy - dx;
            for (int i = 0; i < dx; i++) {
                pd.pixel(x , y, c);
                if (e >= 0) {
                    e += 2 * (dy - dx);
                    y+=incY;
                } else {
                    e += 2 * dy;
                }
                x+=incX;
            }
        } else {
            e = dy - 2 * dx;
            for (int i = 0; i < dy; i++) {
                pd.pixel(x, y, c);
                if (e >= 0) {
                    e += -2 * dx;
                } else {
                    e += 2 * (dy - dx);
                    x+=incX;
                }
                y+=incY;
            }
        }
    }
}
