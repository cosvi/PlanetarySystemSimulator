/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import planetarysystemsimulator.astro.VerletIntegrator;

/**
 * Listens to the button that doubles the
 * gravitational constant.
 * @author jussi
 */
public class GDoubleListener implements ActionListener {
    
    private VerletIntegrator verlet;
    
    public GDoubleListener(VerletIntegrator verlet) {
        this.verlet = verlet;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.verlet.doubleG();
    }

    
}
