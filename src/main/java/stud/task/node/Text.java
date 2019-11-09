package stud.task.node;

import stud.task.TTFParser;
import stud.task.converter.ScreenConverter;
import stud.task.converter.ScreenPoint;
import stud.task.drawer.line.BezierLine;
import stud.task.drawer.line.LineDrawer;
import stud.task.model.Contour;
import stud.task.model.Font;
import stud.task.model.Glyph;
import stud.task.model.GlyphPoint;
import stud.task.table.TTFTableFormatException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Text {
    private int x0, y0;

    private ScreenConverter sc;
    private BezierLine bl;

    private Font font;

    public Text(File ttf) throws IOException, TTFTableFormatException {
        bl = new BezierLine();
        TTFParser parser = new TTFParser();
        parser.parse(ttf);
        font = parser.createFont();
    }

    public void draw(int x0, int y0, LineDrawer ld, String text, double em, double rstr, double rsym, Color color) {
        this.x0 = x0;
        this.y0 = y0;
        int wr = Math.abs(font.getxMax() - font.getxMin());
        int hr = Math.abs(font.getyMax() - font.getyMin());
        sc = new ScreenConverter(0, 0, wr, hr, (int) (wr * em), (int) (hr * em));
        int dx = 0;
        int dy = 0;
        List<Glyph> glyphs = font.getGlyphs(text);
        for (Glyph glyph :
                glyphs) {
            dx += glyph.getLeftSideBearing()*em;
            for (Contour c :
                    glyph.getContourList()) {
                drawContour(dx, dy, ld, color, rstr, rsym, c);
            }
            dx += (glyph.getRightSideBearing() - glyph.getLeftSideBearing()) * em;
        }
    }

    public void drawContour(int dx, int dy, LineDrawer ld, Color c, double rstr, double rsym, Contour contour) {
        Iterator<GlyphPoint> it = contour.getPoints().iterator();
        GlyphPoint last = it.next();
        List<ScreenPoint> curveList = new LinkedList<>();
        while (it.hasNext()) {
            GlyphPoint cur = it.next();
            if (cur.isCurve()) {
                if (curveList.isEmpty()) {
                    curveList.add(toScreenPoint(dx, dy, rstr, rsym, last));
                }
                curveList.add(toScreenPoint(dx, dy, rstr, rsym, cur));
            } else if (!curveList.isEmpty()) {
                curveList.add(toScreenPoint(dx, dy, rstr, rsym, cur));
                bl.draw(ld,  c, curveList);
                curveList.clear();
            } else {
                ScreenPoint start = toScreenPoint(dx, dy, rstr, rsym, last);
                ScreenPoint end = toScreenPoint(dx, dy, rstr, rsym, cur);
                ld.draw(start.getI(), start.getJ(), end.getI(), end.getJ(), c);
            }
            last = cur;
        }
    }

    public ScreenPoint toScreenPoint(int dx, int dy, double rstr, double rsym, GlyphPoint gp) {
        ScreenPoint p = sc.s2s(new ScreenPoint(gp.getX(), gp.getY()));
        rotatePoint(p, rsym);
        p.setI(p.getI() + dx); p.setJ(p.getJ() + dy);
        rotatePoint(p, rstr);
        p.setI(p.getI() + x0); p.setJ(p.getJ() + y0);
        return p;
    }

    public void rotatePoint(ScreenPoint p, double r) {
        p.setI((int) (p.getI() * Math.cos(r) - p.getJ() * Math.sin(r)));
        p.setJ((int) (p.getJ() * Math.cos(r) + p.getI() * Math.sin(r)));
    }
}
