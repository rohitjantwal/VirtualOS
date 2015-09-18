/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package file_properties;

/**
 *
 * @author Rohit
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;

public class usb_detect implements Runnable
{   
    @Override
    public void run()
    {
       String[] letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
    File[] drives = new File[letters.length];
    boolean[] isDrive = new boolean[letters.length];

    // init the file objects and the initial drive state
    for ( int i = 0; i < letters.length; ++i )
        {
        drives[i] = new File(letters[i]+":/");

        isDrive[i] = drives[i].canRead();
        }

     while(true)
        {
        // check each drive
        for ( int i = 0; i < letters.length; ++i )
            {
            boolean pluggedIn = drives[i].canRead();

            // if the state has changed output a message
            if ( pluggedIn != isDrive[i] )
                {
                if ( pluggedIn )
                {
                    //System.out.println("Drive "+letters[i]+" has been plugged in");
               JOptionPane.showMessageDialog(null, "Drive "+letters[i]+" has been plugged in");
                }
                else
                {  //System.out.println("Drive "+letters[i]+" has been unplugged");
                JOptionPane.showMessageDialog(null, "Drive "+letters[i]+" has been unplugged");
                }       
                isDrive[i] = pluggedIn;
                }
            }

        // wait before looping
        try { Thread.sleep(100); }
        catch (InterruptedException e) { /* do nothing */ }

        }
    }

  }
