/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astrotest;

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
import astro.planetarysystemsimulator.ForceCalculator;
import astro.planetarysystemsimulator.Body;

public class ForceCalculatorTest {
    
    ForceCalculator calc;
    Body body1, body2;
    
    public ForceCalculatorTest() {
    }
    
    @Before
    public void setUp() {
        this.calc =  new ForceCalculator();
        this.body1 = new Body("body1", 10);
        this.body1.setPosition(new double[]{3.5, -2, 0});
        this.body2 = new Body("body2", 20);
        this.body2.setPosition(new double[]{-2.5, 1, 2});
        
    }
    
    @Test
    public void testDistanceX() {
        assertEquals(6.0, calc.Distances(this.body1.getPosition(), this.body2.getPosition())[0], 0.001);
    }
    
    @Test
    public void testDistanceY() {
        assertEquals(-3.0, calc.Distances(this.body1.getPosition(), this.body2.getPosition())[1], 0.001);
    }

    @Test
    public void testDistanceZ() {
        assertEquals(-2.0, calc.Distances(this.body1.getPosition(), this.body2.getPosition())[2], 0.001);
    }
    
    @Test
    public void testDistanceTotal() {
        assertEquals(7.0, calc.Distances(this.body1.getPosition(), this.body2.getPosition())[3], 0.001);
    }
    
    @Test
    public void testForceX() {
        assertEquals(35.0 , calc.Force(this.body1, this.body2)[0], 0.1);
    }
    
    @Test
    public void testForceY() {
        assertEquals(-17.5 , calc.Force(this.body1, this.body2)[1], 0.1);        
    }
    
    @Test
    public void testForceZ() {
        assertEquals(-11.7 , calc.Force(this.body1, this.body2)[2], 0.1);        
    }
}
