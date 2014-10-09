/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import planetarysystemsimulator.astro.Body;

/**
 *
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
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.cont.add(this.gui.bodyDialog(this.body));
        System.out.println(1);
    }
}
