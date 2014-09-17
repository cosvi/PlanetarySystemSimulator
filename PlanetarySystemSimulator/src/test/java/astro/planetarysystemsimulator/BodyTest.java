/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package astro.planetarysystemsimulator;
import astro.planetarysystemsimulator.Body;

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
}
