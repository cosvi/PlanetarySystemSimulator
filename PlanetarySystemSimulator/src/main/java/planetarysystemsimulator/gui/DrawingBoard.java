/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetarysystemsimulator.gui;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import planetarysystemsimulator.astro.Body;

/**
 * The DrawingBoard controls the drawing
 * of the objects onto the screen.
 * 
 * @author jussi
 */

public class DrawingBoard extends JPanel {
    
    private ArrayList<Body> bodies;
    private double scale;

    /**
     * Sets the scale attribute to 1 and
     * the background color to black.
     * @param bodies 
     */    
    public DrawingBoard(ArrayList<Body> bodies) {
        super.setBackground(Color.black);
        this.bodies = bodies;
        this.scale = 1;
    }
    
    /**
     * Sets a new value for the scale attribute
     * allowing the view to be zoomed in and out.
     * @param newScale new scale factor
     */
    public void setScale(double newScale) {
        this.scale = newScale;
    }
    
    /**
     * Returns the current scale factor of the DrawingBoard.
     * @return current scale factor
     */
    public double getScale() {
        return this.scale;
    }
    
    /**
     * Scales the actual position of the given body
     * to the appropriate position on the screen.
     * @param body body to be scaled
     * @return position on screen
     */
    public int[] scalePosition(Body body) {
         int[] pos = new int[]{0,0,0};
         pos[0] = 400 + (int)(this.scale * 13.0/18.0 * body.getPosition()[0]);
         pos[1] = 370 - (int)(this.scale * 13.0/18.0 * body.getPosition()[1]);
         pos[2] = (int)(body.getPosition()[2]);
         return pos;
    }

    /**
     * Paints the bodies onto the screen with
     * the appropriate color, position and size.
     * @param g graphics component
     */    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Body x : this.bodies) {
            g.setColor(x.getColor());
            int[] pos = this.scalePosition(x);
            g.fillOval(pos[0], pos[1], x.getSize(), x.getSize());
        }
    }
}
