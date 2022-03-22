/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotextfiles;

/**
 *
 * @author tb
 */
public class Point {
    private int x, y;
    
    private Point (int x, int y) {
        setXY(x, y);
    }
    
    public static Point getPoint(int x, int y) {
        if ((x >= 0) && (y >= 0))
            return new Point(x, y);
        return null;
    }
    
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    

    @Override
    public String toString() {
        return x + " / " + y;
    }

}
