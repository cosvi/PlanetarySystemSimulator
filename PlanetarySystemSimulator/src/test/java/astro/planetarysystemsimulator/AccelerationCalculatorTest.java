
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
public class AccelerationCalculatorTest {
    private AccelerationCalculator calc;
    private Body body1, body2;
    
    public AccelerationCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        this.calc =  new AccelerationCalculator();
        this.body1 = new Body("body1", 10);
        this.body1.setPosition(new double[]{3.5, -2, 0});
        this.body2 = new Body("body2", 20);
        this.body2.setPosition(new double[]{-2.5, 1, 2});
    }

    @Test
    public void testAccelerationX1() {
        assertEquals(-3.4985, calc.acceleration(this.body1, this.body2)[0][0], 0.001);
    }

    @Test
    public void testAccelerationX2() {
        assertEquals(1.7493, calc.acceleration(this.body1, this.body2)[1][0], 0.001);
    }
    
    @Test
    public void testAccelerationY1() {
        assertEquals(1.7493, calc.acceleration(this.body1, this.body2)[0][1], 0.001);
    }
    
    @Test
    public void testAccelerationY2() {
        assertEquals(-0.8746, calc.acceleration(this.body1, this.body2)[1][1], 0.001);
    }
    
    @Test
    public void testAccelerationZ1() {
        assertEquals(1.1662, calc.acceleration(this.body1, this.body2)[0][2], 0.001);
    }
    
    @Test
    public void testAccelerationZ2() {
        assertEquals(-0.5831, calc.acceleration(this.body1, this.body2)[1][2], 0.001);
    }
        
}
