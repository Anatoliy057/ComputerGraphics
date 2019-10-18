package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public class BlankBresEllipse extends BresEllipse {

    public BlankBresEllipse(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    public BlankBresEllipse() {

    }

    @Override
    final protected void mirror(int x, int y, int dx, int dy, Color c) {
        dx *= 2;
        dy *= 2;
        pd.pixel(x, y, c);
        pd.pixel(x+dx, y, c);
        pd.pixel(x, y+dy, c);
        pd.pixel(x+dx, y+dy, c);
    }
}
