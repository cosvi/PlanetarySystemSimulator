/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listens to the Zoom Out button.
 * @author jussi
 */
public class ZoomOutListener implements ActionListener {
    
    private DrawingBoard board;
    
    public ZoomOutListener(DrawingBoard board) {
        this.board = board;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.board.setScale(this.board.getScale() / 1.5);
    }
}
