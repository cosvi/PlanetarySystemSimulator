/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planetarysystemsimulator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import planetarysystemsimulator.astro.VerletIntegrator;

/**
 * Listens to the pause button.
 * @author jussi
 */
public class PauseListener implements ActionListener {
    
    private VerletIntegrator verlet;
    
    public PauseListener(VerletIntegrator verlet) {
        this.verlet = verlet;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.verlet.toggleRunning();
    }
}
