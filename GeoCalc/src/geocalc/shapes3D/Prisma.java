/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package geocalc.shapes3D;

import geocalc.Geo2D;
import geocalc.Geo3D;

/**
 *
 * @author sebastian kawicher
 */
public class Prisma extends Geo3D {
    public Prisma(String desc, Geo2D figur2D, int hoehe) {
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
        return getFlaeche() * 2 + getUmfang() * getHoehe();
    }
    @Override
    public int getVolumen() {
        return getFlaeche() * getHoehe();
    }
    @Override
    public void println() {
        System.out.println("Prisma: " + getDesc() + " u=" + getUmfang() + 
                " A=" + getFlaeche() + " O=" + getOberfläche() + 
                " V=" + getVolumen());
    }
}
