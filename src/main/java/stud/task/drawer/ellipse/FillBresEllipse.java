package stud.task.drawer.ellipse;

import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

public class FillBresEllipse extends BresEllipse {

    public FillBresEllipse(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    public FillBresEllipse() {
    }

    final protected void mirror(int x, int y, int dx, int dy, Color c) {
        dx *= 2;
        dy *= 2;
        for (int i = x; i <= x + dx; i++) {
            pd.pixel(i, y, c);
            pd.pixel(i, y - dy, c);
        }
    }
}
