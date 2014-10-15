/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jussi
 */
public class ZoomInListener implements ActionListener {
    
    private DrawingBoard board;
    
    public ZoomInListener(DrawingBoard board) {
        this.board = board;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        this.board.setScale(1.5 * this.board.getScale());
    }
}
