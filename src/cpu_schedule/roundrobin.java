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

class roundrobin {

    int jt1[]={2,1}, jt2[]={1,2}, jt;
    JPanel jp, jp1;
    int k, p;
    int q = 3;
    String str1[] = {"Process", "   AT", "ST", "WT", "FT", "TAT", "NTAT"};

    public roundrobin(int count) {
    
        k =count; //Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));     //number of processes
        //Integer.parseInt(JOptionPane.showInputDialog("Enter time quantum"));
        jt1 = new int[k];         //Arrival time
        jt2 = new int[k];     //Service time

        for (int i = 0; i < k; i++) {
            //sw[i] = i + 1;
            
            jt1[i] = new Integer(10);
            jt2[i] = new Integer(10);
        }
          
    }
    public void create()
    {
        int sp = 0, temp, j = 0, i;
        int m, max = 0;
        int count[] = new int[k];
        int Rrobin[][] = new int[20][20];
        int FT[] = new int[k];
        int t[] = new int[k];
        int WT[] = new int[k];
        int TAT[] = new int[k];
        float NTAT[] = new float[k];
        float sum = 0;
        float avg;
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        jp = new JPanel();
        jp1 = new JPanel();
        jp.setLayout(new GridLayout(k + 1, 7));
        jp1.setLayout(new FlowLayout());

        for (i = 0; i < k; i++) {
            t[i] = 0;
        }
    
            for (i = 0; i < k; i++) {
                if (max < jt2[i]) {
                    max = jt2[i];
                }
            }

            m = max / q + 1;
            for (i = 1; i <= k; i++) {
                for (j = 1; j <= m; j++) {
                    Rrobin[i][j] = 0;
                }
            }
            i = 0;
            int p,p1;
            while (i < k) {
                j = 1;
                 p1=jt2[i];
                while (p1 > 0) {
                   
                    if (p1 >= q) {
                        p1 = p1 - q;
                        //jt2[i]=""+p;
                        Rrobin[i][j] = q;
                        j++;
                    } else {
                        Rrobin[i][j] = p1;
                        p1=0;
                        j++;
                    }
                }
                count[i] = j - 1;
                i++;
            }
            int x = 0;
            int k1;
            i = 0;
            while (x < k) {
                for (int a = 0; a < x; a++) {
                    WT[x] = WT[x] + Rrobin[a][i];
                }
                i = 0;
                int z = x;
                j = count[z];
                k1 = 1;
                while (k1 <= j - 1) {
                    if (i == k1 + 1) {
                        i = 0;
                        k1++;
                    } else {
                        if (i != z) {
                            WT[z] = WT[z] + Rrobin[i][k1];
                        }
                        i++;
                    }
                }
                x++;
            }
//calculating Average Weighting Time
            for (i = 0; i < k; i++) {
                sum = sum + WT[i];
                TAT[i] = WT[i] + jt2[i];
                NTAT[i] = TAT[i] / jt2[i];
                if(i!=0)
                {
                 FT[i] = FT[i - 1] + jt2[i];
                }
            }
            avg = sum / k;
            //end for loop
            for (i = 0; i < 7; i++) {
                jp.add(new JLabel(str1[i]));
            }
            for (i = 0; i < k; i++) {
                jp.add(new JLabel("Process" + (i + 1)));
                jp.add(new JLabel("   " + jt1[i]));
                jp.add(new JLabel("" + jt2[i]));
                jp.add(new JLabel("" + WT[i]));
                jp.add(new JLabel("" + FT[i]));
                jp.add(new JLabel("" + TAT[i]));
                jp.add(new JLabel("" + NTAT[i]));


            }
            avg = sum / k;
            String str2 = "Average Waiting Time is " + avg;
            jp1.add(new JLabel(str2));
            main.add(jp, BorderLayout.NORTH);
            main.add(jp1, BorderLayout.SOUTH);

            JOptionPane.showMessageDialog(null, main, "Output", JOptionPane.PLAIN_MESSAGE);

        } 
  
}//end class
