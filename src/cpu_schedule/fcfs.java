
package cpu_schedule;
/**
 *
 * @author Rohit
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fcfs  {

    int jt1[]={1,2}, jt2[]={1,2};
    JPanel jp, jp1;
    int k, p;
    int sw[];
    float f, avg;
    String str1[] = {"Process", "   AT", "ST", "WT", "FT", "TAT", "NTAT"};

    
    
    public fcfs(int count) {
       
        k = count;//Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));     //number of processes
        sw = new int[k];
        jt1 = new int[k];         //Arrival time
        jt2 = new int[k];     //Service time


        for (int i = 0; i < k; i++) {
            sw[i] = i + 1;
            
            jt1[i] = new Integer(10);
            jt2[i] = new Integer(10);
        }
          
        int l = 0;
        int FT[] = new int[k];
        int temp = 0;
        int WT[] = new int[k];
        int TAT[] = new int[k];
        float NTAT[] = new float[k];
        float sum = 0, sum1 = 0;
        float avg1;
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
         jp = new JPanel();
        jp1 = new JPanel();
        jp.setLayout(new GridLayout(k + 1, 7));
        jp1.setLayout(new FlowLayout());

        
            for (int j = 0; j < k - 1; j++) {
                if (jt1[j] > jt1[j + 1]) {
                    temp = sw[j];
                    sw[j] = sw[j + 1];
                    sw[j + 1] = temp;
                }
            }

            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    WT[j] = 0;
                } else {

                    if (FT[j - 1] < jt1[j]) {
                        FT[j] = jt1[j] + jt2[j];
                        WT[j] = 0;
                    } else {
                        FT[j] = FT[j - 1] + jt2[j];
                        WT[j] = FT[j - 1] - jt1[j];
                    }

                }
                TAT[j] = WT[j] + jt2[j];
                NTAT[j] = TAT[j] / jt2[j];
                sum = sum + WT[j];
                sum1 = sum1 + TAT[j];


            }//end for loop
            for (int j = 0; j < 7; j++) {
                jp.add(new JLabel(str1[j]));
            }
            for (int j = 0; j < k; j++) {
                jp.add(new JLabel("Process" + sw[j]));
                jp.add(new JLabel("   " + jt1[j]));
                jp.add(new JLabel("" + jt2[j]));
                jp.add(new JLabel("" + WT[j]));
                jp.add(new JLabel("" + FT[j]));
                jp.add(new JLabel("" + TAT[j]));
                jp.add(new JLabel("" + NTAT[j]));


            }
            avg = sum / k;
            avg1 = sum1 / k;
            
            String str2 = "Average Waiting Time is :" + avg;
            String str3 = "\n\nAverage Turn Around Time is : " + avg1;
            String str4 = "\n\nGantt Chart is : ";

            for (int j = 0; j < k; j++) {
               
                str4 = str4+ sw[j] + "  ";
            }
            jp1.add(new JLabel(str2));
            jp1.add(new JLabel(str3));
            jp1.add(new JLabel(str4));
            main.add(jp, BorderLayout.NORTH);
            main.add(jp1, BorderLayout.SOUTH);

            JOptionPane.showMessageDialog(null, main, "Output", JOptionPane.PLAIN_MESSAGE);

            l++;
        }
        
    } 

