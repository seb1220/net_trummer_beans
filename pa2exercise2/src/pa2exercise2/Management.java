package pa2exercise2;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Management implements Serializable {
    private ArrayList<Figure> figs;

    Management() {
        figs = new ArrayList<Figure>();
    }

    public void add(Figure f) {
        figs.add(f);
    }

    public Point isInFigure(int x, int y) {
        for (Figure f : figs) {
            Point tmp = (f.isInPoints(x, y));
            if (tmp != null)
                return tmp;
        }
        return null;
    }

    public void paint(Graphics g) {
        for (Figure f : figs) {
            f.paint(g);
        }
    }
}
