/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import file_properties.usb_detect;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Rohit
 */
public class OsStart {
    Thread t;
    ExecutorService threadExecutor = Executors.newCachedThreadPool();
    //ExecutorService threadExecutor = Executors.newFixedThreadPool(5);
//   public static ThreadFactory defaultThreadFactory();
//           {
//               
//           };
           
//ExecutorService threadExecutor = Executors.;

void create_thread()
{
 startmenu am = new startmenu();
    threadExecutor.execute( am  );
       
        usb_detect ud=new usb_detect();
threadExecutor.execute( ud  );

//threadExecutor.shutdown();
}
    public void exit_thread()
    {
//        startmenu am = new startmenu();
//    threadExecutor.execute( am  );
//       
//        usb_detect ud=new usb_detect();
        Thread.currentThread().interrupt();
        return;
    }
     public static void main(String args[]) {
OsStart o=new OsStart();
o.create_thread();
       
       
    }

   
}
