
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import planetarysystemsimulator.astro.AccelerationCalculator;
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
        assertEquals(-2.333E-7, calc.acceleration(this.body1, this.body2)[0][0], 1E-10);
    }

    @Test
    public void testAccelerationX2() {
        assertEquals(1.167E-7, calc.acceleration(this.body1, this.body2)[1][0], 1E-10);
    }
    
    @Test
    public void testAccelerationY1() {
        assertEquals(1.167E-7, calc.acceleration(this.body1, this.body2)[0][1], 1E-10);
    }
    
    @Test
    public void testAccelerationY2() {
        assertEquals(-0.583E-7, calc.acceleration(this.body1, this.body2)[1][1], 1E-10);
    }
    
    @Test
    public void testAccelerationZ1() {
        assertEquals(0.778E-7, calc.acceleration(this.body1, this.body2)[0][2], 1E-10);
    }
    
    @Test
    public void testAccelerationZ2() {
        assertEquals(-0.389E-7, calc.acceleration(this.body1, this.body2)[1][2], 1E-10);
    }
        
}
