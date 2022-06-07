/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa2stoff;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author sebas
 */
public class Management implements Serializable {
    private ArrayList<Figure> figs;
    
    public Management() {
        figs = new ArrayList<Figure>();
    }
    
    public void addFigure(Figure f) {
        figs.add(f);
    }
    
    public void draw(Graphics g) {
        for (Figure f : figs) {
            f.draw(g);
        }
    }
    
    public Point isInPoint(int x, int y) {
        Point p;
        for (Figure f : figs) {
            p = f.isInFigure(x, y);
            if (p != null)
                return p;
        }
        return null;
    }
}
