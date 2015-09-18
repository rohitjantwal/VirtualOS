
package cpu_schedule;
/**
 *
 * @author Rohit
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class sjf {

    
    int jt1[]={2,2}, jt2[]={2,2},jt;
    
    JPanel jp, jp1;
            
    Container con;
    int k, p;
    int sw[];
   
    String str1[] = {"Process", "   AT", "ST", "WT", "FT", "TAT", "NTAT"};
    
    
    

    public sjf(int count) {
       
        k =count;// Integer.parseInt(JOptionPane.showInputDialog("Enter number of process"));

        sw=new int[k];
        jt1 = new int[k];
        jt2 = new int[k];


        for (int i = 0; i < k; i++) {
            sw[i]=i+1;
            jt1[i] = new Integer(10);
            jt2[i] = new Integer(10);
        }

     
        
    }//end of constructor

   void create()
   {
    int t1,temp;
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


                    for (int j = 0; j < k-1; j++) {
                        t1=j+1;
                        //temp1[j] = jt2[j].getText();
                        //temp2[j] = jt2[t1].getText();
                        if (jt2[j] > jt2[t1]) {
                            jt = jt2[j];
                            jt2[j] = jt2[t1];
                            jt2[t1] = jt;
                            temp=sw[j];
                            sw[j]=sw[t1];
                            sw[t1]=temp;
                        }
                    }
                }
                if(i!=0)
                {
                t1 = i - 1;
                WT[i] = WT[t1] + jt2[t1];
                FT[i] = FT[i - 1] +jt2[i];
                }
                else
                {
                    t1=0;
                }
                
                TAT[i] = WT[i] + jt2[i];
                NTAT[i] = TAT[i] / jt2[i];
                sum = sum + WT[i];
                sum1=sum1+TAT[i];


            }//end for loop
            for (int i = 0; i < 7; i++) {
                jp.add(new JLabel(str1[i]));
            }
            for (int i = 0; i < k; i++) {
                jp.add(new JLabel("Process" + (i + 1)));
                jp.add(new JLabel("" + jt1[i]));
                jp.add(new JLabel("" + jt2[i]));
                jp.add(new JLabel("" + WT[i]));
                jp.add(new JLabel("" + FT[i]));
                jp.add(new JLabel("" + TAT[i]));
                jp.add(new JLabel("" + NTAT[i]));


            }
            avg = sum / k;
            avg1=sum1/k;
            String str2 = "Average Waiting Time is " + avg;
            String str3 = "\n\nAverage Turn Around Time is " + avg1;
            String str4="\n\nGantt Chart is: ";
            for(int i=0;i<k;i++)
            {
                str4=str4+sw[i]+"  ";
            }
            jp1.add(new JLabel(str2));
            jp1.add(new JLabel(str3));
            jp1.add(new JLabel(str4));
            main.add(jp, BorderLayout.NORTH);
            main.add(jp1, BorderLayout.SOUTH);

            JOptionPane.showMessageDialog(null, main, "Output", JOptionPane.PLAIN_MESSAGE);

        } 
        
 
}

   


