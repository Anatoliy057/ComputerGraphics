package stud.task.drawer.ellipse;

import stud.task.converter.ScreenPoint;
import stud.task.drawer.line.LineDrawer;

import java.awt.*;

import static java.lang.Math.PI;

public abstract class BresPie extends BresEllipse implements PieDrawer {

    protected LineDrawer ld;
    protected boolean most;
    protected int x0, y0;
    protected ScreenPoint first, last;

    @Override
    public void setLineDrawer(LineDrawer ld) {
        this.ld = ld;
    }

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
        ld.draw(x0, y0, first.getI(), first.getJ(), c);
        last = findInter(a, b, k2, direct2, x0, y0);
        ld.draw(x0, y0, last.getI(), last.getJ(), c);

        super.draw(x0, y0, a, b, c);
    }

    protected ScreenPoint findInter(int a, int b, double k, int direct, int dx, int dy) {
        double x = direct*(a*b/Math.sqrt(b*b + a*a*k*k));
        double y = k*x;
        return new ScreenPoint((int) x+dx, (int) y+dy);
    }
}
