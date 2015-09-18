/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rohit
 */
//Review
public interface ExtendedActionListener extends ActionListener {
    public Map<JButton,File> fileButtonMap = new HashMap<JButton,File>();

}
//this is always a reference to the object on which the method was invoked