/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package planetarysystemsimulator.astro;

import planetarysystemsimulator.astro.Body;
import planetarysystemsimulator.astro.PositionCalculator;
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
public class PositionCalculatorTest {
    
    private PositionCalculator calc;
    private Body body;
    private int t;
    
    public PositionCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        this.calc =  new PositionCalculator();
        this.body = new Body("body1", 10);
        this.body.setPosition(new double[]{3.5, -2, 0});
        this.body.setVelocity(new double[]{5, 0, -1});
        this.body.setAcceleration(new double[]{10, -5, 0});
        this.t = 2;
    }
    
    @Test
    public void testPositionX() {
        assertEquals(33.5, calc.newPosition(this.body, this.t)[0], 0.001);
    }
    
    @Test
    public void testPositionY() {
        assertEquals(-12.0, calc.newPosition(this.body, this.t)[1], 0.001);
    }

    @Test
    public void testPositionZ() {
        assertEquals(-2.0, calc.newPosition(this.body, this.t)[2], 0.001);
    }
    

}
