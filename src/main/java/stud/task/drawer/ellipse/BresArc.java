package stud.task.drawer.ellipse;

import stud.task.converter.ScreenPoint;
import stud.task.drawer.pixel.PixelDrawer;

import java.awt.*;

import static java.lang.Math.PI;

public class BresArc extends BresEllipse implements AcrDrawer {

    private boolean most;
    private int x0, y0;
    private ScreenPoint first, last;

    public BresArc(PixelDrawer pd) {
        setPixelDrawer(pd);
    }

    public BresArc() {}

    @Override
    public void draw(int x, int y, int a, int b, double angle1, double angle2, Color c) {
        this.x0 = x;
        this.y0 = y;
        angle1 %= 2*PI;
        angle2 %= 2*PI;
        int direct1 = angle1 <= PI/2 || angle1 > 3*PI/2 ? 1 : -1;
        int direct2 = angle2 <= PI/2 || angle2 > 3*PI/2 ? 1 : -1;
        double k1 = Math.tan(angle1);
        double k2 = Math.tan(angle2);

        most = (angle1 > angle2) ?
                (angle2 - angle1+2*PI) > PI :
                (angle2 - angle1) > PI;

        first = findInter(a, b, k1, direct1, x0, y0);
        last = findInter(a, b, k2, direct2, x0, y0);

        super.draw(x0, y0, a, b, c);
    }

    protected ScreenPoint findInter(int a, int b, double k, int direct, int dx, int dy) {
        double x = direct*(a*b/Math.sqrt(b*b + a*a*k*k));
        double y = k*x;
        return new ScreenPoint((int) x+dx, (int) y+dy);
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
        int errorFirst = (first.getI()-x0)*(y - y0) - (first.getJ()-y0)*(x - x0);
        int errorLast = (last.getI()-x0)*(y - y0) - (last.getJ()-y0)*(x - x0);
        if (most) {
            if (errorFirst > 0 || errorLast < 0) pd.pixel(x, y, c);
        } else {
            if (errorFirst > 0 && errorLast < 0) pd.pixel(x, y, c);
        }
    }
}
