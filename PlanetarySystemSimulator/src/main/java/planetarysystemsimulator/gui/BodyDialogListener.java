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
 * Listens to the BodyDialog method of the 
 * GUI allowing the properties of the bodies
 * to be altered by the user.
 * @author jussi
 */
public class BodyDialogListener implements ActionListener{
    
    private ButtonGroup group;
    private String[] coms;
    
    /**
     * Creates a new Listener linked to the specified
     * RadioButton group.
     * @param group RadioButton group to be listened to
     * @param coms command options of the buttons in the group
     */
    public BodyDialogListener(ButtonGroup group, String[] coms) {
        this.group = group;
        this.coms = coms;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String com = this.group.getSelection().getActionCommand();
    }
    
    
    
}
