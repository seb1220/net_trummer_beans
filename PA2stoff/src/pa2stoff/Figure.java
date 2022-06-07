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
public abstract class Figure implements Serializable {
    protected Point p1, p2;

    public Figure(int x1, int y1, int x2, int y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }
    
    public abstract void draw(Graphics g);
    
    public Point isInFigure(int x, int y) {
        if (p1.isInPoint(x, y))
            return p1;
        if (p2.isInPoint(x, y))
            return p2;
        
        return null;
    }
    
    public Point getP2() {
        return p2;
    }
}
