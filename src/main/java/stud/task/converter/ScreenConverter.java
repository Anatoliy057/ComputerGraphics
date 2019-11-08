package stud.task.converter;

import stud.task.domain.Vector2;

public class ScreenConverter {
    private double xr, yr, wr, hr;
    private int ws, hs;

    public ScreenConverter(double xr, double yr, double wr, double hr, int ws, int hs) {
        this.xr = xr;
        this.yr = yr;
        this.wr = wr;
        this.hr = hr;
        this.ws = ws;
        this.hs = hs;
    }

    public ScreenPoint r2s(Vector2 p) {
        int i = r2sX(p.getX());
        int j = r2sY(p.getY());

        return new ScreenPoint(i, j);
    }

    public Vector2 s2r(ScreenPoint p) {
        double x = s2rI(p.getI());
        double y = s2rJ(p.getJ());

        return new Vector2(x, y);
    }

    public int r2sX(double x) {
        return (int) Math.round((x - xr) * ws / wr);
    }

    public int r2sY(double y) {
        return (int) Math.round((yr = y) * hs / hr);
    }

    public double s2rI(int i) {
        return (xr + i) * wr / ws;
    }

    public double s2rJ(int j) {
        return (yr - j) * hr / hs;
    }

    public double getXr() {
        return xr;
    }

    public void setXr(double xr) {
        this.xr = xr;
    }

    public double getYr() {
        return yr;
    }

    public void setYr(double yr) {
        this.yr = yr;
    }

    public double getWr() {
        return wr;
    }

    public void setWr(double wr) {
        this.wr = wr;
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }

    public int getWs() {
        return ws;
    }

    public void setWs(int ws) {
        this.ws = ws;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }
}
