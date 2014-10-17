/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import planetarysystemsimulator.astro.Body;

/**
 * Listens to the various body buttons in the GUI
 * calling the appropriate BodyDialog to allow
 * the user alter the body's properties.
 * @author jussi
 */
public class BodyListener implements ActionListener {
    
    private Body body;
    private Container cont;
    private GUI gui;
    
    public BodyListener(GUI gui, Container cont, Body body) {
        this.body = body;
        this.gui = gui;
        this.cont = cont;
    }
    
    /**
     * After the action is performed, calls the
     * DrawingBoard to redraw itself.
     * 
     * @param ae 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.cont.add(this.gui.bodyDialog(this.body), BorderLayout.EAST);
        this.cont.revalidate();
        this.cont.repaint();
    }
}
