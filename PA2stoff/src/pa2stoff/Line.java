/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa2stoff;

import java.awt.Graphics;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class Line extends Figure implements Serializable {
    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        
        p1.draw(g);
        p2.draw(g);
    }
}
