/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc;

import geocalc.Punkt;
import geocalc.shapes2D.*;
import geocalc.shapes3D.*;
import javax.swing.tree.DefaultTreeSelectionModel;

/**
 *
 * @author sebastian kawicher
 */
public class GeoArray {
    private Geo[] geoarray;
    
    public static final int MAX = 10;
    public static final int NOT_FOUND = -1;

    public GeoArray(int size) {
        geoarray = new Geo[size];
    }
    
    public GeoArray() {
        this(MAX);
    }
    
    public void insert(int type, String desc, Punkt[] points) {
        switch (type) {
            case Geo.T_DREIECK:
                insert(new Dreieck(desc, points[0], points[1]));
                break;
            case Geo.T_Quadrat:
                insert(new Quadrat(desc, points[0], points[1]));
                break;
            case Geo.T_Kreis:
                insert(new Kreis(desc, points[0], points[1]));
                break;
            default:
                System.err.println("Invalid type" + type);
                break;
        }
    }
    
    public void insert(int type, String desc, Punkt[] points, int hoehe) {
        switch (type) {
            case Geo.T_PYRAMIDE:
                insert(new Pyramide(desc, new Dreieck(desc, points[0], points[1]), hoehe));
                break;
            case Geo.T_QUADER:
                insert(new Quader(desc, new Quadrat(desc, points[0], points[1]), hoehe));
                break;
            case Geo.T_ZYLINDER:
                insert(new Zylinder(desc, new Kreis(desc, points[0], points[1]), hoehe));
                break;
            case Geo.T_PRISMA:
                insert(new Prisma(desc, new Dreieck(desc, points[0], points[1]), hoehe));
                break;
            default:
                System.err.println("Invalid type" + type);
                break;
        }
    }
    
    private void insert(Geo figur) {
        int i = findFreeIndex();
        if (i == NOT_FOUND) {
            System.err.println("No free place found!");
            return;
        }
        geoarray[i] = figur;
    }
    
    public void println() {
        for (int i = 0; i < geoarray.length; ++i)
            if (geoarray[i] != null)
                geoarray[i].println();
    }
    
    public void delete() {
        geoarray = new Geo[geoarray.length];
    }
    
    public boolean delete(String desc) {
        for (int i = 0; i < geoarray.length; ++i)
            if (geoarray[i] != null && geoarray[i].getDesc() == desc) {
                geoarray[i] = null;
                return true;
            }
        return false;
    }
    
    public void readFrom(String filename) {
        // Geos from file in GeoArray
    }
    
    public void writeInto(String filename) {
        // GeoArray into file
    }
    
    private int findFreeIndex() {
        for (int i = 0; i < geoarray.length; ++i) {
            if (geoarray[i] == null)
                return i;
        }
        return NOT_FOUND;
    }
}
