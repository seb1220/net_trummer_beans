/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geopoints;

/**
 *
 * @author sebas
 */
public class Point {
    private String desc; // describtion
    private int x;
    private int y;
    
    public static Point getPoint(String desc, int x, int y) {
        if ((x < 0) || (y < 0) || (desc.length() == 0))
            return null;
        return new Point(desc, x, y);
    }
    
    protected Point(String desc, int x, int y) {
        setDesc(desc);
        setXY(x, y);
    }
    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }
    
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }
    
    public double getDistance(Point p) {
        if (p != null)
            return Math.sqrt(Math.pow(Math.abs(getX() - p.getX()), 2) + Math.pow(Math.abs(getY() - p.getY()), 2));
        return 0;
    }
    
    @Override
    public String toString() {
        return getDesc() + " (" + getX() + "/" +getY() + ")";
    }
}
