/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astro.planetarysystemsimulator;

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
public class VelocityCalculatorTest {
    private VelocityCalculator calc;
    private Body body;
    private int t;
    
    public VelocityCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        this.calc =  new VelocityCalculator();
        this.body = new Body("body", 10);
        this.body.setVelocity(new double[]{5, 0, -1});
        this.body.setAcceleration(new double[]{10, -5, 0});
        this.body.setAccelerationOld(new double[]{5, 0, -5});
        this.t = 2;
    }
    
    @Test
    public void testVelocityX() {
        assertEquals(20.0, calc.newVelocity(this.body, this.t)[0], 0.001);
    }
    
    @Test
    public void testVelocityY() {
        assertEquals(-5.0, calc.newVelocity(this.body, this.t)[1], 0.001);
    }

    @Test
    public void testVelocityZ() {
        assertEquals(-6.0, calc.newVelocity(this.body, this.t)[2], 0.001);
    }
    

}
