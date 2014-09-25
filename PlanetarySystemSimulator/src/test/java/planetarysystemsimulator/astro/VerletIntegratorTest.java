/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import planetarysystemsimulator.astro.VerletIntegrator;
import planetarysystemsimulator.astro.Body;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import planetarysystemsimulator.gui.DrawingBoard;

/**
 *
 * @author jussi
 */
public class VerletIntegratorTest {
    private VerletIntegrator verlet;
    
    public VerletIntegratorTest() {
        
    }
    
    @Before
    public void setUp() {
        Body body1 = new Body("body1", 10);
        body1.setPosition(new double[]{3.5, -2, 0});
        body1.setVelocity(new double[]{1.0, 0.0, -2.0});
        Body body2 = new Body("body2", 20);
        body2.setPosition(new double[]{-2.5, 1, 2});
        body2.setVelocity(new double[]{-1.5, 3.0, 0.0});
//        Body body3 = new Body("body3", 5); add third body to test
//        body3.setPosition
        Body[] bodies = new Body[]{body1, body2};
        DrawingBoard board = new DrawingBoard(bodies);
        this.verlet = new VerletIntegrator(bodies, board);
    }
    
    @Test
    public void acceleratesCorrectly() {
        this.verlet.accelerate();
        Body[] bodies = this.verlet.getBodies();
        assertEquals(-2.333E-4, bodies[0].getAcceleration()[0], 1E-7);
        assertEquals(1.167E-4, bodies[0].getAcceleration()[1], 1E-7);
        assertEquals(0.778E-4, bodies[0].getAcceleration()[2], 1E-7);
        assertEquals(1.167E-4, bodies[1].getAcceleration()[0], 1E-7);
        assertEquals(-0.583E-4, bodies[1].getAcceleration()[1], 1E-7);
        assertEquals(-0.389E-4, bodies[1].getAcceleration()[2], 1E-7);
        

    }
    
}
