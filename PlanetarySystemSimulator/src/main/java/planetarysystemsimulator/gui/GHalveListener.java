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
 * This listener handles the alterG button.
 * @author jussi
 */
public class GHalveListener implements ActionListener {
    
    private VerletIntegrator verlet;
    
    public GHalveListener(VerletIntegrator verlet) {
        this.verlet = verlet;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.verlet.halveG();
    }

}
