package file_properties;

import javax.swing.*;

/**
 *
 * @author Rohit
 */
public class rename {
    public String input_name;
    public String[] save_name;
   public String setRename()
   {
   input_name=JOptionPane.showInputDialog("enter the name with extention");
   String save_name[]=input_name.split("\\.");
   
   //JOptionPane.showMessageDialog ( null, "Put \nyour \nmessage \nhere" ); 
   return(input_name);
   }
}
