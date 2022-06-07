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
public class Circle extends Figure implements Serializable {
    
    public Circle(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(p1.getX() - getRadius(), p1.getY() - getRadius(), 
                   getRadius() * 2, getRadius() * 2);
        
        p1.draw(g);
        p2.draw(g);
    }
    
    private int getRadius() {
        int dx = p1.getX() - p2.getX();
        int dy = p1.getY() - p2.getY();
        
        return (int)(Math.round(Math.sqrt(dx * dx + dy * dy)));
    }
}
