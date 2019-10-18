package stud.task.drawer.ellipse;

import stud.task.drawer.line.LineDrawer;
import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public class BlankBresPie extends BresPie implements PieDrawer {

    public BlankBresPie() {}

    public BlankBresPie(PixelDrawer pd, LineDrawer ld) {
        setPixelDrawer(pd);
        setLineDrawer(ld);
    }

    @Override
    public void setLineDrawer(LineDrawer ld) {
        this.ld = ld;
    }


    protected void mirror(int x, int y, int dx, int dy, Color c) {
        dx *= 2;
        dy *= 2;
        pixel(x, y, c);
        pixel(x+dx, y, c);
        pixel(x, y+dy, c);
        pixel(x+dx, y+dy, c);
    }

    private void pixel(int x, int y, Color c) {
        int errorFirst = (first.getX()-x0)*(y - y0) - (first.getY()-y0)*(x - x0);
        int errorLast = (last.getX()-x0)*(y - y0) - (last.getY()-y0)*(x - x0);
        if (most) {
            if (errorFirst > 0 || errorLast < 0) pd.pixel(x, y, c);
        } else {
            if (errorFirst > 0 && errorLast < 0) pd.pixel(x, y, c);
        }
    }
}
