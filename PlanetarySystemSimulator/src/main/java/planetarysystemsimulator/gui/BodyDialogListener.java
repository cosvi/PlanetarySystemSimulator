/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

/**
 *
 * @author jussi
 */
public class BodyDialogListener implements ActionListener{
    
    private ButtonGroup group;
    private String[] coms;
    
    public BodyDialogListener(ButtonGroup group, String[] coms) {
        this.group = group;
        this.coms = coms;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String com = this.group.getSelection().getActionCommand();
    }
    
    
    
}
