/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
/**
 *
 * @author shivangi
 */

public class task 
{
   
    public void actionPerformed(ActionEvent e) {
    throw new UnsupportedOperationException("Not supported yet.");
 
    }

public static class GetProcess {

public static List listRunningProcesses() {
List processes = new ArrayList();
try {
String line;
Process p = Runtime.getRuntime().exec("tasklist.exe /nh");
BufferedReader input = new BufferedReader
(new InputStreamReader(p.getInputStream()));
while ((line = input.readLine()) != null) {
if (!line.trim().equals("")) {
// keep only the process name
processes.add(line.substring(0, line.indexOf(" ")));
}

}
input.close();
}
catch (Exception err) {
err.printStackTrace();
}
return processes;
}
}

public static void msgBox(String msg) {
javax.swing.JOptionPane.showConfirmDialog((java.awt.Component)
null, msg, "System Task",
javax.swing.JOptionPane.DEFAULT_OPTION);

}

public static void main(String[] args){
   
    task sg1 =new task();
    GetProcess g = new GetProcess();
List processes = g.listRunningProcesses();
String result = "";
// display the result 
Iterator it = processes.iterator();
int i = 0;
while (it.hasNext()) {
result += it.next() +",";
i++;
if (i==10) {
result += "\n";
i = 0;
}
}
msgBox("Running processes :\n " + result+"\n Total No of Processes: "+ processes.size());

}

public task()
{
    
    GetProcess g = new GetProcess();
List processes = g.listRunningProcesses();
String result = "";
// display the result 
Iterator it = processes.iterator();
int i = 0;
while (it.hasNext()) {
result += it.next() +",";
i++;
if (i==10) {
result += "\n";
i = 0;
}
}
msgBox("Running processes :\n " + result+"\n Total No of Processes: "+ processes.size());
}

}
 
 

 class TaskListener implements ActionListener {
        
    @Override
        public void actionPerformed(ActionEvent ae){
                       task sg1 =new task();
                  //              msgBox(s);
                  
        }
    }