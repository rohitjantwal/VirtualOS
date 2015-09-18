/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.event.ActionEvent;
import javax.swing.event.HyperlinkEvent;
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
public class WebBrowserTest {
    
    public WebBrowserTest() {
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
     * Test of actionPerformed method, of class WebBrowser.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent ae = null;
        WebBrowser instance = null;
        instance.actionPerformed(ae);
       
    }

    /**
     * Test of hyperlinkUpdate method, of class WebBrowser.
     */
    @Test
    public void testHyperlinkUpdate() {
        System.out.println("hyperlinkUpdate");
        HyperlinkEvent e = null;
        WebBrowser instance = null;
        instance.hyperlinkUpdate(e);
        
    }

    /**
     * Test of main method, of class WebBrowser.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        WebBrowser.main(args);
       
    }
}
