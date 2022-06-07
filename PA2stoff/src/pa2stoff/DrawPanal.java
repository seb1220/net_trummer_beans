/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pa2stoff;

import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebas
 */
public class DrawPanal extends javax.swing.JPanel {
    
    public static final Color BACKCOLOR = new Color(245, 245, 245);
    public static final int CIRCLE = 1;
    public static final int LINE = 2;
    
    private int type = CIRCLE;
    private Management m;
    
    private Point act;
    private int oldX;
    private int oldY;
    private boolean create, move;
    
    /**
     * Creates new form DrawPanal
     */
    public DrawPanal() {
        initComponents();
        m = new Management();
    }
    
    public void mi_change (int type) {
        this.type = type;
    }
    
    public void mi_new() {
        m = new Management();
        repaint();
    }
    
    public void mi_open(String filename) {
        if (!filename.endsWith(".lab"))
            filename = filename + ".lab";
        
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
            m = (Management)ois.readObject();
            ois.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawPanal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(DrawPanal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        repaint();
    }
    
    public void mi_save(String filename) {
        if (!filename.endsWith(".lab"))
            filename = filename + ".lab";
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            oos.writeObject(m);
            oos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DrawPanal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DrawPanal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mi_exit() {
        System.exit(0);
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        m.draw(g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        act = m.isInPoint(evt.getX(), evt.getY());
        if (act == null) {
            create = true;
            Figure hf = null;
            if (type == CIRCLE) {
                hf = new Circle(evt.getX(), evt.getY(), evt.getX(), evt.getY());
            } else if (type == LINE){
                hf = new Line(evt.getX(), evt.getY(), evt.getX(), evt.getY());
            }
            m.addFigure(hf);
            act = hf.getP2();
            
        } else if (act != null) {
            move = true;
            oldX = evt.getX();
            oldY = evt.getY();
        }
        
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        if (create)
            act.set(evt.getX(), evt.getY());
        else if (move)
            act.move(evt.getX() - oldX, evt.getY() - oldY);
        
        oldX = evt.getX();
        oldY = evt.getY();
        
        repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        act = null;
        move = false;
        create = false;
        
        repaint();
    }//GEN-LAST:event_formMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}