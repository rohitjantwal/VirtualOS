/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.event.ActionEvent;
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
public class ImageViewerTest {
    
    public ImageViewerTest() {
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
     * Test of actionPerformed method, of class ImageViewer.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent evt = null;
        ImageViewer instance = new ImageViewer();
        instance.actionPerformed(evt);
        
    }

    /**
     * Test of main method, of class ImageViewer.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ImageViewer.main(args);
        
    }
}
