/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointfactorydemo;

/**
 *
 * @author tb
 */
public class Point {
    private String desc;
    private int x;
    private int y;
    
    private Point(String desc, int x, int y) {
        setDesc(desc);
        setXY(x, y);
    }
    
    public static Point getPoint(String desc, int x, int y) {
        if (
            (desc.length() >= 2) &&
            (x >= 0) && 
            (y >= 0)
           )
            return new Point(desc, x, y);
        else
            return null;
    }

    public void setDesc(String desc) {
        if (desc.length() >= 2)
            this.desc = desc;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setX(int x) {
        if (x >= 0)
            this.x = x;
    }
    
    public int getX() {
        return x;
    }
    
    public void setY(int y) {
        if (y >= 0)
            this.y = y;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return getDesc() + " (" +  getX() + "/" + getY() + ")";
    }

}
