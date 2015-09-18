/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

/**
 *
 * @author Rohit
 */
import applications.ImageViewer;
import applications.notepad;
import file_properties.rename;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import os.*;
import os.startmenu.ButtonListener;


public class SplitSample {
    startmenu sm=new startmenu();
    JFrame folder_window=new JFrame();
    JPanel folder_window_panel=new JPanel();
    JTextField address_bar=new JTextField();
    JButton create_new=new JButton("new file");
    public JSplitPane spRight;
    public JSplitPane spLeft;
    public JPanel right_folder_window=new JPanel();
    public JTree left_folder_window;
  protected JSplitPane split;

  public SplitSample() {
    
startmenu sm=new startmenu();
  
    folder_window.setSize(200, 200);
    folder_window.getContentPane().setLayout(new BorderLayout());
    
    DefaultMutableTreeNode my_comp=new DefaultMutableTreeNode("MY COMPUTER");
    DefaultMutableTreeNode memory=new DefaultMutableTreeNode("MEMORY");
    DefaultMutableTreeNode notepad_app=new DefaultMutableTreeNode("notepad");
    DefaultMutableTreeNode image_app=new DefaultMutableTreeNode("image viewer");
    DefaultMutableTreeNode browser_app=new DefaultMutableTreeNode("web browser");
    DefaultMutableTreeNode clock_app=new DefaultMutableTreeNode("clock");
    DefaultMutableTreeNode battery_app=new DefaultMutableTreeNode("battery");
    memory.add(notepad_app);
    memory.add(image_app);
    memory.add(browser_app);
    memory.add(clock_app);
    memory.add(battery_app);
    my_comp.add(memory);
  
    JTree left_folder_window=new JTree(my_comp);
    
    JSplitPane spLeft = new JSplitPane(JSplitPane.VERTICAL_SPLIT, create_new, left_folder_window);
    spLeft.setDividerSize(8);
    spLeft.setContinuousLayout(true);

    JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,address_bar, right_folder_window);
    spRight.setDividerSize(8);
    spRight.setContinuousLayout(true);

    split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, spLeft, spRight);
    split.setContinuousLayout(false);
    //split.setOneTouchExpandable(true);
    
    create_new.addActionListener(new ButtonListener_Dir());
    folder_window.getContentPane().add(split, BorderLayout.CENTER);
    folder_window.setVisible(true);
  }

  public void createTree()
{
DefaultMutableTreeNode root=new DefaultMutableTreeNode("style");
}
     public class ButtonListener_dir_dir implements ExtendedActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton)ae.getSource();
            
            String ext1 = ae.getActionCommand().substring( ae.getActionCommand().indexOf("."), ae.getActionCommand().length());
            if(ext1.equals(".txt"))
                    {
            File f = fileButtonMap.get(btn);
                 
            Frame frame = new notepad(f);
                    
            frame.setSize(500, 400);
            frame.setVisible(true);
            frame.show();
        }
            else if(ext1.equals(".gif"))
                    {
            File f = fileButtonMap.get(btn);
                
            JFrame frame = new ImageViewer(f);
            
                    
            frame.setSize(500, 400);
            frame.setVisible(true);
            frame.show();
        }
            else if(ext1.equals(".dir")) 
            {
                JPanel add_window_folder=new JPanel();
           
            right_folder_window.add(add_window_folder);
           right_folder_window.setVisible(true);
            }
        }
    }    
  
  class ButtonListener_Dir implements ActionListener
        {
        public void actionPerformed(ActionEvent ae) {
         rename r = new rename();
            String set_name = r.setRename();
            JButton button = new JButton();
            
            if (set_name != null) {
                String ext = set_name.substring(set_name.indexOf("."), set_name.length());
                if (ext.equals(".gif")) {
                    ImageIcon paint_image_icon = new ImageIcon("imageviewer.png");
                    button.setIcon(paint_image_icon);
                    
                } else if (ext.equals(".txt")) {
                   // new_add_notepad_icon = new JButton();
                    ImageIcon paint_notepad_icon = new ImageIcon("notepad.gif");
                    button.setIcon(paint_notepad_icon);
                } else if (ext.equals(".dir")) {
                   // new_add_folder_icon = new JButton();
                    ImageIcon paint_folder_icon = new ImageIcon("folder.gif");
                    button.setIcon(paint_folder_icon);
                
                }
                try {
                    File f = createFile(set_name);
                    button.setText(set_name);
                   
                    right_folder_window.add(button);
                    
                    //fileButtonMap.put(button, f);
                } catch (IOException ex) {
                    //Logger.getLogger(startmenu.class.getName()).log(Level.SEVERE, null, ex);
               // }
            }

            right_folder_window.revalidate();
            right_folder_window.repaint();  
        button.addActionListener(new ButtonListener_dir_dir());
            }
     /*      File createFile(String fileName) throws IOException{
        File f;
        f=new File("E:/memory/"+ fileName);
        if(!f.exists()){
           f.createNewFile();
        }
        return f;
    }*/

        }

 public File createFile(String fileName) throws IOException{
        File f;
        f=new File("E:/memory/"+ fileName);
        if(!f.exists()){
            
           f.createNewFile();
        }
        return f;
    }            
  }
  
  public static void main(String args[]) {
    new SplitSample();
  }
}
           