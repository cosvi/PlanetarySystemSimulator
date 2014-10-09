/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import planetarysystemsimulator.astro.Body;

/**
 *
 * @author jussi
 */
public class BodyListener implements ActionListener {
    
    private Body body;
    
    public BodyListener(Body body) {
        this.body = body;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
