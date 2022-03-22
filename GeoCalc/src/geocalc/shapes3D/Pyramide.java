/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc.shapes3D;

import geocalc.Geo2D;
import geocalc.Geo3D;
import geocalc.Punkt;

/**
 *
 * @author sebastian kawicher
 */
public class Pyramide extends Geo3D {
    public Pyramide(String desc, Geo2D figur2D, int hoehe) {
        super(desc, figur2D, hoehe);
    }
    
    @Override
    public int getUmfang() {
        return getFigur2D().getUmfang();
    }
    @Override
    public int getFlaeche() {
        return (getFigur2D().getFlaeche());
    }
    @Override
    public int getOberfläche() {
        return getFlaeche() + (3 * (getUmfang() / 6) * getHoehe());
    }
    @Override
    public int getVolumen() {
        return getFlaeche() * getHoehe() / 3;
    }
    @Override
    public void println() {
        System.out.println("Pyramide: " + getDesc() + " u=" + getUmfang() + 
                " A=" + getFlaeche() + " O=" + getOberfläche() + 
                " V=" + getVolumen());
    }
}
