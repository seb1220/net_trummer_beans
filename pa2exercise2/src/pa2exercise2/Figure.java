package pa2exercise2;

import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable {
    protected Point p1, p2;

    Figure(int x1, int y1, int x2, int y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    public Point getP2() {
        return p2;
    }

    public Point isInPoints(int x, int y) {
        if (p1.isInPoint(x, y))
            return p1;
        if (p2.isInPoint(x, y))
            return p2;

        return null;
    }

    abstract void paint(Graphics g);
}
