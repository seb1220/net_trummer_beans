/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geopoints;

/**
 *
 * @author sebas
 */
public class Point3D extends Point {
    private int z;
    
    public static Point3D getPoint(String desc, int x, int y, int z) {
        if ((x < 0) || (y < 0) || (desc.length() == 0) || (z < 0))
            return null;
        return new Point3D(desc, x, y, z);
    }

    protected Point3D(String desc, int x, int y, int z) {
        super(desc, x, y);
        setZ(z);
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
    
    public double getDistance(Point3D p) {
        if (p != null)
            return Math.hypot(Math.hypot((getX() - p.getX()), (getY() - p.getY())), (getZ() - p.getZ()));
        return 0;
    }

    @Override
    public String toString() {
        return getDesc() + " (" + getX() + "/" + getY() + "/" + getZ() + ")";
    }
    
}
