package pa2exercise2;

import java.awt.*;
import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {

    Rectangle(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    void paint(Graphics g) {
        g.drawRect(p1.getX(), p1.getY(), (p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
        p1.paint(g);
        p2.paint(g);
    }
}
