/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cpu_schedule;
/**
 *
 * @author Rohit
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class priority {

    
    int jt1[]={2,2}, jt2[]={1,2}, jt, jt3;
    
    JPanel jp, jp1;
   
           int sw[];

    int k, p;
   
    String str1[] = {"Process", "   Priority", "ST", "WT", "FT", "TAT", "NTAT"};

    public priority(int count) {
       

        k = count;//Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));

        sw=new int[k];
        jt1 = new int[k];
        jt2 = new int[k];

        for (int i = 0; i < k; i++) {
            sw[i] = i + 1;
            
            jt1[i] = new Integer(10);
            jt2[i] = new Integer(10);
        }
          


    }
    public void create() 
    {
        int t1,temp=0;

        int FT[] = new int[k];
        int WT[] = new int[k];
        int TAT[] = new int[k];
        float NTAT[] = new float[k];
        float sum = 0,sum1=0;
        float avg,avg1;
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        jp = new JPanel();
        jp1 = new JPanel();
        jp.setLayout(new GridLayout(k + 1, 7));
        jp1.setLayout(new FlowLayout());
        //     System.out.println(jt1[1].getText());

       
            for (int i = 0; i < k; i++) {
                if (i == 0) {
                    WT[i] = 0;
                } else {


                    for (int j = 0; j < k - 1; j++) {
                        t1 = j + 1;

                        if (jt1[j] > jt1[t1]) {
                            jt = jt1[j];
                            jt1[j] = jt1[t1];
                            jt1[t1] = jt;
                            jt3 = jt2[j];
                            jt2[j] = jt2[t1];
                            jt2[t1] = jt3;
                            temp=sw[j];
                            sw[j]=sw[t1];
                            sw[t1]=temp;

                        }
                    }
                }
                if (i != 0) {
                    t1 = i - 1;
                    WT[i] = WT[t1] + jt2[t1];
                    FT[i] = FT[i - 1] + jt2[i];
                } else {
                    t1 = 0;
                }

                TAT[i] = WT[i] + jt2[i];
               NTAT[i] = TAT[i] / jt2[i];
                sum = sum + WT[i];
                sum1=sum1+TAT[i];


            }//end for loop
            for (int i = 0; i < 7; i++) {
                jp.add(new JLabel(str1[i]));
            }
            int k1;
            for (int i = 0; i < k; i++) {
                k1=sw[i]+1;
                jp.add(new JLabel("Process " + k1));
                jp.add(new JLabel("   " + jt1[i]));
                jp.add(new JLabel("" + jt2[i]));
                jp.add(new JLabel("" + WT[i]));
                jp.add(new JLabel("" + FT[i]));
                jp.add(new JLabel("" + TAT[i]));
                jp.add(new JLabel("" + NTAT[i]));


            }
            avg = sum / k;
            avg1=sum1/k;
            int p;
            String str2 = "Average Waiting Time is " + avg;
            String str3 = "\n\nAverage Turn Around Time is " + avg1;
            String str4="\n\nGantt Chart is: ";
            for(int i=0;i<k;i++)
            {
                p=sw[i]+1;
                str4="Process: "+str4+p+"  ";
            }
            jp1.add(new JLabel(str2));
            jp1.add(new JLabel(str3));
            jp1.add(new JLabel(str4));
            main.add(jp, BorderLayout.NORTH);
            main.add(jp1, BorderLayout.SOUTH);

            JOptionPane.showMessageDialog(null, main, "Output", JOptionPane.PLAIN_MESSAGE);

      
   }
    
}


