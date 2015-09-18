/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.io.File;
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
public class notepadTest {
    
    public notepadTest() {
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
     * Test of init method, of class notepad.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        notepad instance = new notepad();
        instance.init();
       
    }

    /**
     * Test of ReadFile method, of class notepad.
     */
    @Test
    public void testReadFile() {
        System.out.println("ReadFile");
        notepad instance = new notepad();
        instance.ReadFile();
       
    }

    /**
     * Test of ReadThisFile method, of class notepad.
     */
    @Test
    public void testReadThisFile() {
        System.out.println("ReadThisFile");
        File f = null;
        notepad instance = new notepad();
        instance.ReadThisFile(f);
       
    }

    /**
     * Test of main method, of class notepad.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        notepad.main(args);
       }
}
