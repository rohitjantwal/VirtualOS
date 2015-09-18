/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

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
public class startmenuTest {
    
    public startmenuTest() {
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
     * Test of main method, of class startmenu.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        //startmenu.main(args);
       //public static void main(String args[]) {
        startmenu am = new startmenu();
        am.create();
    //}
}

    /**
     * Test of create method, of class startmenu.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        startmenu instance = new startmenu();
        instance.create();
       
       
    }

    /**
     * Test of createFile method, of class startmenu.
     */
    @Test
    public void testCreateFile() throws Exception {
        System.out.println("createFile");
        String fileName = "";
        startmenu instance = new startmenu();
        File expResult = null;
        File result = instance.createFile(fileName);
        assertEquals(expResult, result);
        }
}
