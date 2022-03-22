/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc.shapes2D;

import geocalc.Geo2D;
import geocalc.Punkt;

/**
 *
 * @author sebastian kawicher
 */
public class Dreieck extends Geo2D {
    public Dreieck(String desc, Punkt p1, Punkt p2) {
        super(desc, p1, p2);
    }
    
    @Override
    public int getUmfang() {
        return getP1().distance(getP2()) * 3;
    }
    @Override
    public int getFlaeche() {
        int d = getP1().distance(getP2());
        return (int) ((d * d) / 4 * Math.sqrt(3));
    }
    @Override
    public void println() {
        System.out.println("Dreieck: " + getDesc() + " a=" + 
                getP1().distance(getP2()) +
                " u=" + getUmfang() + " A=" + getFlaeche());
    }
}
