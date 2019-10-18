package stud.task.drawer.ellipse;

import stud.task.drawer.line.LineDrawer;
import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public class FillBresPie extends BresPie {

    public FillBresPie() {
    }

    public FillBresPie(PixelDrawer pd, LineDrawer ld) {
        setPixelDrawer(pd);
        setLineDrawer(ld);
    }

    protected void mirror(int x, int y, int dx, int dy, Color c) {
        dx *= 2;
        dy *= 2;
        for (int i = x; i <= x + dx; i++) {
            pixel(i, y, c);
            pixel(i, y + dy, c);
        }
    }

    private void pixel(int x, int y, Color c) {
        int eStart = (first.getX()-x0)*(y - y0) - (first.getY()-y0)*(x - x0);
        int eEnd = (last.getX()-x0)*(y - y0) - (last.getY()-y0)*(x - x0);
        if (most) {
            if (eStart > 0 || eEnd < 0) pd.pixel(x, y, c);
        } else {
            if (eStart > 0 && eEnd < 0) pd.pixel(x, y, c);
        }
    }
}
