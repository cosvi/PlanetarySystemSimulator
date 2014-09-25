/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import planetarysystemsimulator.astro.Body;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jussi
 */
public class BodyTest {
    private Body body;
    private Body body2;
    private double[] acc;
    
    public BodyTest() {
    }

    @Before
    public void setUp() {
        this.body = new Body("Earth", 300.0);

    }
    
    @Test
    public void constructorSetsNameCorrectly() {
        assertEquals("Earth", this.body.getName());
    }
    
    @Test
    public void constructorSetsMassCorrectly() {
        assertEquals(300.0, this.body.getMass(), 0.0000001);
    }
    
    @Test
    public void constructorDoesntSetNegativeMass() {
        this.body2 = new Body("Venus", -100);
        assertEquals(1.0, this.body2.getMass(), 0.0000001);
    }

    @Test
    public void constructorDoesntSetZeroMass() {
        this.body2 = new Body("Pluto", 0);
        assertEquals(1.0, this.body2.getMass(), 0.0000001);
    }
    
    @Test
    public void acceleratesCorrectly() {
        this.body.setAcceleration(new double[]{0.0, 0.0, 0.0});
        this.acc = new double[]{1.5, 0.0, -2.0};
        this.body.accelerate(this.acc);
        assertEquals(1.5, this.body.getAcceleration()[0], 1E-4);
        assertEquals(0.0, this.body.getAcceleration()[1], 1E-4);
        assertEquals(-2.0, this.body.getAcceleration()[2], 1E-4);
    }
    
    @Test
    public void savesAcceleration() {
        this.body.setAcceleration(new double[]{3.0, 3.0, -7.5});
        this.body.saveAcceleration();
        assertEquals(3.0, this.body.getAccelerationOld()[0], 1E-4);
        assertEquals(3.0, this.body.getAccelerationOld()[1], 1E-4);
        assertEquals(-7.5, this.body.getAccelerationOld()[2], 1E-4);
        assertEquals(0.0, this.body.getAcceleration()[0], 1E-4);
        assertEquals(0.0, this.body.getAcceleration()[1], 1E-4);
        assertEquals(0.0, this.body.getAcceleration()[2], 1E-4);
    }
}
