/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dijkstra;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author sebas
 */
public abstract class Node implements Serializable {
    //public static final int RADIUS = 20;
    
    private int x;
    private int y;

    public Node(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    abstract void paint(Graphics g);
    
    public void move (int dx, int dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    abstract boolean isInNode(int x, int y);
    
    public boolean isNearNode(int x, int y) {
        return NodeManagement.RADIUS * 3 > Math.hypot(getX() - x, getY() - y);
    }

}
