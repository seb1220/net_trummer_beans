/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pa2stoff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class Point implements Serializable {
    public static final int SIZE = 10;
    private int x;
    private int y;

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void set(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void move(int dx, int dy) {
        set(getX() + dx, getY() + dy);
    }
    
    public void draw(Graphics g) {
        g.setColor(DrawPanal.BACKCOLOR);
        g.fillRect(getX() - SIZE, getY() - SIZE, SIZE * 2, SIZE * 2);
        g.setColor(Color.black);
        g.drawRect(getX() - SIZE, getY() - SIZE, SIZE * 2, SIZE * 2);
    }
    
    public boolean isInPoint(int x, int y) {
        return (
                (getX()-SIZE < x && getX()+SIZE > x) &&
                (getY()-SIZE < y && getY()+SIZE > y)
                );
    }
}
