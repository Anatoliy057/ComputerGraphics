package stud.task.drawer.line;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;
import java.util.Collections;

public class WuLine extends AbstractLineDrawer {

    public WuLine() {
    }

    public WuLine(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    @Override
    public void draw(int x1, int y1, int x2, int y2, Color c) {
        int dx, dy, e;
        int x = Math.abs(x1), y = Math.abs(y1);
        int incX = (int) Math.signum((dx = x2-x1));
        int incY = (int) Math.signum((dy = y2-y1));
        dx = Math.abs(dx);
        dy = Math.abs(dy);

        pd.pixel(x, y, c);
        double f;
        if (dx > dy) {
            e = dy - dx/2;
            for (int i = 0; i < dx-1; i++) {
                x+=incX;
                if (e > 0) {
                    f = convert(e - dx/2.0, dx);
                    pd.pixel(x, y, pd.mix(x, y, c, 1-f));
                    y+=incY;
                    e += (dy - dx);
                } else {
                    int de = e + dx/2;
                    f = convert(de, dx);
                    if (de > 0)
                        pd.pixel(x, y+incY, pd.mix(x, y+incY, c, 1-f));
                    else
                        pd.pixel(x, y-incY, pd.mix(x, y-incY, c, 1-f));
                    e += dy;
                }
                pd.pixel(x, y, pd.mix(x, y, c, f));
            }
        } else {
            e = dy/2 - dx;
            for (int i = 0; i < dy-1; i++) {
                y+=incY;
                if (e >= 0) {
                    int de = e - dy/2;
                    f = convert(de, dy);
                    if (de < 0)
                        pd.pixel(x+incX, y, pd.mix(x+incX, y, c, 1-f));
                    else {
                        pd.pixel(x - incX, y, pd.mix(x - incX, y, c, 1 - f));
                    }
                    e -= dx;
                } else {
                    f = convert(e + dy/2.0, dy);
                    pd.pixel(x, y, pd.mix(x, y, c,1-f));
                    x+=incX;
                    e += (dy - dx);
                }
                pd.pixel(x, y, pd.mix(x, y, c, f));
            }
        }
        pd.pixel(x2, y2, c);
    }

    private double convert(double e, double d) {
        e = Math.abs(e);
        if (e >= d) {
            return 0;
        }
        return (d-e)/d;
    }
}
