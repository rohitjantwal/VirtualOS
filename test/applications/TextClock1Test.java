/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Himanshu
 */
public class TextClock1Test {
    
    public TextClock1Test() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class TextClock1.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        TextClock1.main(args);
        
    }
}
