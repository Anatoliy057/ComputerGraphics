package stud.task.drawer.line;

import stud.task.converter.ScreenPoint;

import java.awt.*;
import java.util.Collection;

public class BezierLine {

    public void draw(LineDrawer ld, Color c, Collection<ScreenPoint> points) {
        ScreenPoint[] arrPoints = new ScreenPoint[points.size()];
        draw(ld, c, points.toArray(arrPoints));
    }

    public void draw(LineDrawer ld, int k,  Color c, Collection<ScreenPoint> points) {
        ScreenPoint[] arrPoints = new ScreenPoint[points.size()];
        draw(ld, k*2, c, points.toArray(arrPoints));
    }

    public void draw(LineDrawer ld, Color c, ScreenPoint...points) {
        int k = 0;
        for (int i = 1; i < points.length; i++) {
            k += Math.sqrt(
                    Math.pow(points[i].getI() - points[i - 1].getI(), 2) +
                            Math.pow(points[i].getJ() - points[i - 1].getJ(), 2)
            );
        }
        draw(ld, k*2, c, points);
    }

    public void draw(LineDrawer ld, int k, Color c, ScreenPoint...points) {
        int d = 1;
        switch (points.length) {
            case 2: {
                ld.draw(points[0], points[1], c);
                break;
            }
            case 3: {
                ScreenPoint last = points[0];
                for (int i = 0; i < k; i++) {
                    double t = (d * i) / (double) k;
                    double t2 = Math.pow(t, 2);
                    double unt = 1-t;
                    double unt2 = Math.pow(unt, 2);
                    ScreenPoint cur = new ScreenPoint(
                            (int) Math.round(unt2 * points[0].getI() + 2 * t *  unt * points[1].getI() + t2 * points[2].getI()),
                            (int) Math.round(unt2 * points[0].getJ() + 2 * t *  unt * points[1].getJ() + t2 * points[2].getJ())
                    );
                    ld.draw(last, cur, c);
                    last = cur;
                }
                ld.draw(points[points.length-1], points[points.length-1], c);
                break;
            }
            case 4: {
                ScreenPoint last = points[0];
                for (int i = 0; i < k; i++) {
                    double t = (d * i) / (double) k;
                    double t2 = Math.pow(t, 2);
                    double t3 = Math.pow(t, 3);
                    double unt = 1-t;
                    double unt2 = Math.pow(unt, 2);
                    double unt3 = Math.pow(unt, 3);
                    ScreenPoint cur = new ScreenPoint(
                            (int) Math.round(unt3 * points[0].getI() + 3 * t *  unt2 * points[1].getI() + 3 * t2 *  unt * points[2].getI() + t3 * points[3].getI()),
                            (int) Math.round(unt3 * points[0].getJ() + 3 * t *  unt2 * points[1].getJ() + 3 * t2 *  unt * points[2].getJ() + t3 * points[3].getJ())
                    );
                    ld.draw(last, cur, c);
                    last = cur;
                }
                ld.draw(points[points.length-1], points[points.length-1], c);
                break;
            }
            default: {
                ScreenPoint last = nextPoint(d / (double) k, points);
                for (int i = 2; i < k; i++) {
                    ScreenPoint cur = nextPoint((d * i) / (double) k, points);
                    ld.draw(last.getI(), last.getJ(), cur.getI(), cur.getJ(), c);
                    last = cur;
                }
                ld.draw(points[points.length-1], points[points.length-1], c);
            }
        }
    }

    private ScreenPoint nextPoint(double t, ScreenPoint...points) {
        double x = 0;
        double y = 0;

        int n = points.length - 1;
        for (int i=0; i <= n; i++)
        {
            x += f(n)/(f(i)*f(n-i)) * points[i].getI() * Math.pow(t, i) * Math.pow(1-t, n-i);
            y += f(n)/(f(i)*f(n-i)) * points[i].getJ() * Math.pow(t, i) * Math.pow(1-t, n-i);
        }
        return new ScreenPoint((int)x, (int)y);
    }

    private double f(int n){
        int result = 1;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
