/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import java.util.ArrayList;
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
        ArrayList<Body> bodies = new ArrayList<Body>();
        bodies.add(body1);
        bodies.add(body2);
        DrawingBoard board = new DrawingBoard(bodies);
        this.verlet = new VerletIntegrator(bodies, board);
    }
    
    @Test
    public void acceleratesCorrectly() {
        this.verlet.accelerate();
        ArrayList<Body> bodies = this.verlet.getBodies();
        assertEquals(-2.333E-7, bodies.get(0).getAcceleration()[0], 1E-10);
        assertEquals(1.167E-7, bodies.get(0).getAcceleration()[1], 1E-10);
        assertEquals(0.778E-7, bodies.get(0).getAcceleration()[2], 1E-10);
        assertEquals(1.167E-7, bodies.get(1).getAcceleration()[0], 1E-10);
        assertEquals(-0.583E-7, bodies.get(1).getAcceleration()[1], 1E-10);
        assertEquals(-0.389E-7, bodies.get(1).getAcceleration()[2], 1E-10);
    }
    
    @Test
    public void testToggleRunning() {
        this.verlet.toggleRunning();
        assertEquals(false, this.verlet.getRunning());
        this.verlet.toggleRunning();
        assertEquals(true, this.verlet.getRunning());        
    }
    
    @Test
    public void testChangeG() {
        this.verlet.doubleG();
        assertEquals(13.34E-7, this.verlet.accCalc.forcecalc.getG(), 1E-10);
        this.verlet.halveG();
        this.verlet.halveG();
        assertEquals(3.335E-7, this.verlet.accCalc.forcecalc.getG(), 1E-10);        
    }
    
    @Test
    public void testNewVelocity() {
        this.verlet.accelerate();
        this.verlet.newVelocities();
        ArrayList<Body> bodies = this.verlet.getBodies();
        assertEquals(0.999999883, bodies.get(0).getVelocity()[0], 1E-9);
        assertEquals(0.000000058, bodies.get(0).getVelocity()[1], 1E-9);
        assertEquals(-1.999999961, bodies.get(0).getVelocity()[2], 1E-9);
        assertEquals(-1.499999942, bodies.get(1).getVelocity()[0], 1E-5);
        assertEquals(2.999999971, bodies.get(1).getVelocity()[1], 1E-5);
        assertEquals(-0.000000019, bodies.get(1).getVelocity()[2], 1E-5);
    }
    
    @Test
    public void savesAccelerations() {
        ArrayList<Body> bodies = this.verlet.getBodies();
        for (Body x : bodies) {
            x.setAcceleration(new double[]{1,1,1});
        }
        this.verlet.saveAccelerations();
        assertEquals(1, bodies.get(0).getAccelerationOld()[0],0.1);
        assertEquals(1, bodies.get(0).getAccelerationOld()[1],0.1);
        assertEquals(1, bodies.get(0).getAccelerationOld()[2],0.1);
        assertEquals(1, bodies.get(1).getAccelerationOld()[0],0.1);
        assertEquals(1, bodies.get(1).getAccelerationOld()[1],0.1);
        assertEquals(1, bodies.get(1).getAccelerationOld()[2],0.1);
    }
    
    @Test
    public void testNewPositions() {
        this.verlet.newPositions();
        ArrayList<Body> bodies = this.verlet.getBodies();
        assertEquals(4.5, bodies.get(0).getPosition()[0], 0.01);
        assertEquals(-2, bodies.get(0).getPosition()[1], 0.01);
        assertEquals(-2, bodies.get(0).getPosition()[2], 0.01);
        assertEquals(-4, bodies.get(1).getPosition()[0], 0.01);
        assertEquals(4, bodies.get(1).getPosition()[1], 0.01);
        assertEquals(2, bodies.get(1).getPosition()[2], 0.01);
    }
}
