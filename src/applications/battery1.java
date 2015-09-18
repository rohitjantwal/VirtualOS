package applications;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.win32.StdCallLibrary;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

/**
 *
 * @author Rohit
 */

public class battery1 extends JFrame  {
    
    private JTextField _batfield;
    
    
     /////////////////////////////////////////////// inner class ClockListener
//    class BatteryListener implements ActionListener {
//    	public void actionPerformed(ActionEvent e) {
//            batfield.setText(""+batteryStatus.);}
//    }
    
public interface Kernel32 extends StdCallLibrary {
    


    public Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("Kernel32", Kernel32.class);

    /**
     * @see http://msdn2.microsoft.com/en-us/library/aa373232.aspx
     */
    public class SYSTEM_POWER_STATUS extends Structure {
        public byte ACLineStatus;
        public byte BatteryFlag;
        public byte BatteryLifePercent;
        public byte Reserved1;
        public int BatteryLifeTime;
        public int BatteryFullLifeTime;

        /**
         * The AC power status
         */
        public String getACLineStatusString() {
            switch (ACLineStatus) {
                case (0): return "NOT CHARGING";
                case (1): return "CHARGING";
                default: return "Unknown";
            }
        }

        /**
         * The battery charge status
         */
      public String getBatteryFlagString() {
            switch (BatteryFlag) {
                case (1): return "High, more than 66 percent";
                case (2): return "Low, less than 33 percent";
                case (4): return "Critical, less than five percent";
                case (8): return "Charging";
                case ((byte) 128): return "No system battery";
                default: return "Unknown";
            }
        }

        /**
         * The percentage of full battery charge remaining
         */
        public String getBatteryLifePercent() {
            return (BatteryLifePercent == (byte) 255) ? "Unknown" : BatteryLifePercent + "%";
        }

        /**
         * The number of seconds of battery life remaining
         */
       public String getBatteryLifeTime() {
            return (BatteryLifeTime == -1) ? "Unknown" : BatteryLifeTime + " seconds";
        }

        /**
         * The number of seconds of battery life when at full charge
         */
        public String getBatteryFullLifeTime() {
            return (BatteryFullLifeTime == -1) ? "Unknown" : BatteryFullLifeTime + " seconds";
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ACLineStatus: " + getACLineStatusString() + "\n");
            //sb.append("Battery Flag: " + getBatteryFlagString() + "\n");
            sb.append("Battery Life: " + getBatteryLifePercent() + "\n");
            sb.append("Battery Left: " + getBatteryLifeTime() + "\n");
            //sb.append("Battery Full: " + getBatteryFullLifeTime() + "\n");
            return sb.toString();
        }
    }

    /**
     * Fill the structure.
     */
 public int GetSystemPowerStatus(SYSTEM_POWER_STATUS result);
}
   
//public battery1()
//    {
//     
//        _batfield = new JTextField(5);
//        _batfield.setEditable(false);
//        _batfield.setFont(new Font("sansserif", Font.PLAIN, 48));
//        
//        JPanel content = new JPanel();
//        content.setLayout(new FlowLayout());
//        content.add(_batfield); 
//        
//        this.setContentPane(content);
//        this.setTitle("Battery Status");
//        this.pack();
//        this.setLocationRelativeTo(null);
//        this.setResizable(false);
        
/* alag hai*/
//        Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
//        Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
// 
//        
//         javax.swing.Timer t = new javax.swing.Timer(1000, new BatteryListener());
//        t.start();
   // }
    
public battery1()
{
        _batfield = new JTextField(40);
        _batfield.setEditable(false);
        _batfield.setFont(new Font("sansserif", Font.PLAIN, 20)); 
    
        JPanel content = new JPanel();
       
        //content.setSize(200, 200);
        content.setLayout(new FlowLayout());
        
        content.add(_batfield);
        
        this.setContentPane(content);
        this.setTitle("Battery Status");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        javax.swing.Timer t = new javax.swing.Timer(1000, new BatteryListener());
        t.start();
//        
//       Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
//       Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
//
//       System.out.println(batteryStatus);
//       
}// Shows result of toString() method.
        
       class BatteryListener implements ActionListener {
        @Override
    	public void actionPerformed(ActionEvent e) {
    		//... Whenever this is called, get the current time and
    		//    display it in the textfield.
//            Calendar now = Calendar.getInstance();
//            int h = now.get(Calendar.HOUR_OF_DAY);
//            int m = now.get(Calendar.MINUTE);
//            int s = now.get(Calendar.SECOND);
//            _timeField.setText("" + h + ":" + m + ":" + s);
//            //... The following is an easier way to format the time,
            //    but requires knowing how to use the format method.
            //_timeField.setText(String.format("%1$tH:%1$tM:%1$tS", now));
    	Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
       Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);
      _batfield.setText("Battery status is " + batteryStatus);
       //System.out.println(batteryStatus);
        
        }
    }
       
 public static void main(String[] args) 
 {
    JFrame frame = new battery1();
    frame.show(); 
  
 }// TODO code application logic here
 

}