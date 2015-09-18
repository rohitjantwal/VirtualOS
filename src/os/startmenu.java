package os;
import java.awt.Graphics;
import applications.ImageViewer;
import applications.TextClock1;
import applications.WebBrowser;
import applications.battery1;
import applications.notepad;
import cpu_schedule.scheduler;
import applications.battery1;
import applications.task;
import file_properties.rename;
import file_properties.usb_detect;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import window.SplitSample;
//import lan_mt.*;
//import lan_mt.Sys_server;
import java.awt.Container;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import lan_mt.ServerGUI;
//import os.Listener.Listener1;

public class startmenu implements Runnable
{
    JFrame desk = new JFrame("Mainframe");

    //public JPanel main_screen = new JPanel();
    ImageIcon create_new_file_image_icon = new ImageIcon("new.jpg");
    ImageIcon server_icon = new ImageIcon("server.jpg");
    ImageIcon unknown_image_icon = new ImageIcon("unknown.jpg");
    ImageIcon notepad_image_icon = new ImageIcon("notepad.gif");
    ImageIcon mycomp1 = new ImageIcon("my_comp.png");
    ImageIcon browser_image_icon = new ImageIcon("internet.jpg");
    ImageIcon imageviewer_image_icon = new ImageIcon("imageviewer.png");
    ImageIcon cpu_icon = new ImageIcon("cpu.jpg");
    ImageIcon clock_image_icon = new ImageIcon("clock.jpg");
    ImageIcon control_panel_image_icon = new ImageIcon("controlp.png");
    ImageIcon battery_icon = new ImageIcon("battery.png");
    ImageIcon task_icon = new ImageIcon("t.png");
    ImageIcon calculator_icon = new ImageIcon("c.png");
    ImageIcon alarm_icon = new ImageIcon("a.png");
    ImageIcon blue_icon = new ImageIcon("b.png");
    public ImagePanel main_screen = new ImagePanel(new ImageIcon("background.jpg").getImage());
    
    JMenuBar start = new JMenuBar();
    JMenu item = new JMenu("START");
    JMenuItem create_new_file = new JMenuItem("NEW FILE", create_new_file_image_icon);
    JMenuItem notepad = new JMenuItem("notepad", notepad_image_icon);
    JMenuItem browser = new JMenuItem("Browser", browser_image_icon);
    JMenuItem imageviewer = new JMenuItem("Image Viewer", imageviewer_image_icon);
    JMenuItem clock = new JMenuItem("CLOCK", clock_image_icon);
    JMenuItem battery = new JMenuItem("Battery",battery_icon);
    JMenuItem control_panel = new JMenuItem("CONTROL PANEL", control_panel_image_icon);
    JMenuItem server = new JMenuItem("Server start", server_icon);
    JButton mycomp = new JButton("MY COMPUTER", mycomp1);
    JButton notepad_desk_icon = new JButton("NOTEPAD", notepad_image_icon);
    JButton browser_desk_icon = new JButton("WEB BROWSER", browser_image_icon);
    JButton imageviewer_desk_icon = new JButton("IMAGE VIEWER", imageviewer_image_icon);
    JButton clock_desk_icon = new JButton("CLOCK", clock_image_icon);
    JButton control_panel_icon = new JButton("CONTROL PANEL", control_panel_image_icon);
    JButton battery_desk_icon = new JButton("Battery",battery_icon);
    JButton server_desk_icon = new JButton("Server ", server_icon);
    JButton alarm_desk_icon = new JButton("ALARM", alarm_icon);
    JButton task_desk_icon = new JButton("TASK MANAGER", task_icon);
    
    JButton blue_desk_icon = new JButton("BLUETOOTH", blue_icon);
    JButton cal_desk_icon = new JButton("CALCULATOR", calculator_icon);
    JButton new_add_image_icon = new JButton();
    JButton new_add_notepad_icon = new JButton();
    JButton new_add_folder_icon = new JButton();
    public JPopupMenu rightclick = new JPopupMenu();
    JMenuItem New = new JMenuItem("new");
    JMenuItem folder = new JMenuItem("folder");
    public static int count = 0;
    //ServerGUI RJ = null;
    task sg=null;
    

   
  public startmenu() {
//layout= new GridBagLayout
desk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void create() 
    {   //desk.setLayout(new GridBagLayout()); 
        desk.add(mycomp,FlowLayout.LEFT);
        desk.setJMenuBar(start);
        desk.add(main_screen);
        desk.setVisible(true);
        desk.setSize(1366, 778);
        //main_screen.setBackground();
        main_screen.setLayout(new FlowLayout());
        main_screen.add(mycomp);
        main_screen.add(notepad_desk_icon);
        main_screen.add(browser_desk_icon);
        main_screen.add(imageviewer_desk_icon);
        main_screen.add(clock_desk_icon);
        main_screen.add(control_panel_icon);
        main_screen.add(battery_desk_icon);
        main_screen.add(server_desk_icon);
        main_screen.add(alarm_desk_icon);
        main_screen.add(blue_desk_icon);
        main_screen.add(task_desk_icon);
        
        main_screen.add(cal_desk_icon);
        desk.add(start, BorderLayout.SOUTH);
        start.add(item);
        item.add(create_new_file);
        item.add(notepad);
        item.add(battery);
        item.add(browser);
        item.add(imageviewer);
        item.add(clock);
        item.add(control_panel);
        item.add(server);

        main_screen.add(rightclick);
        rightclick.add(New);
        New.add(folder);
        mycomp.addActionListener(new MyComputerListener());
        main_screen.addMouseListener(new RightClickListener());
        notepad.addActionListener(new NotepadListener());
        notepad_desk_icon.addActionListener(new NotepadListener());
        browser.addActionListener(new BrowserListener());
        browser_desk_icon.addActionListener(new BrowserListener());
        imageviewer.addActionListener(new ImageViewerListener());
        imageviewer_desk_icon.addActionListener(new ImageViewerListener());
        clock.addActionListener(new ClockListener());
        clock_desk_icon.addActionListener(new ClockListener());
        create_new_file.addActionListener(new CreateNewFileListener());
        battery.addActionListener(new BatteryListener());
        battery_desk_icon.addActionListener(new BatteryListener());
        control_panel_icon.addActionListener(new ControlPanelListener());
        control_panel.addActionListener(new ControlPanelListener());
        server.addActionListener(new Serverlistener());
        server_desk_icon.addActionListener(new Serverlistener());
        
        ComponentMover cm = new ComponentMover();
        cm.registerComponent(mycomp, notepad_desk_icon,browser_desk_icon,imageviewer_desk_icon,clock_desk_icon,control_panel_icon,battery_desk_icon,server_desk_icon,alarm_desk_icon,blue_desk_icon,task_desk_icon,cal_desk_icon);
    
        ComponentResizer cr = new ComponentResizer();
        cr.registerComponent(mycomp, notepad_desk_icon,browser_desk_icon,imageviewer_desk_icon,clock_desk_icon,control_panel_icon,battery_desk_icon,server_desk_icon,alarm_desk_icon,blue_desk_icon,task_desk_icon,cal_desk_icon);
    
    }

    @Override
    public void run() {
       create();
    }

    class MyComputerListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
           new SplitSample();
        }
    
    }
    
    
    
    
    class RightClickListener implements MouseListener {

        public void mouseClicked(MouseEvent me) {
            JFrame aa = new JFrame();
            main_screen.add(aa);
            /*
            if(me.isPopupTrigger())
            {
            rightclick.show(me.getComponent(), me.getX(), me.getY());
            }
            
            if(e.getButton()==MouseEvent.BUTTON1)   
            {
            JOptionPane.showMessageDialog(null, "happy brday");
            }
            else if(e.getButton()==MouseEvent.BUTTON2)
            {}
            else if(e.getButton()==MouseEvent.BUTTON3)
            {    }
             */
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
        }

        @Override
        public void mouseExited(MouseEvent me) {
        }
    }

    public class NotepadListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            Frame f = new notepad();
            f.setSize(500, 400);
            f.setVisible(true);
            f.show();
        }
    }

    public class BrowserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String url = "";
            url = "about:blank";
            new WebBrowser(url).setVisible(true);

        }
    }

    public class ImageViewerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            JFrame frame = new ImageViewer();
            frame.show();
        }
    }

    public class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();
            System.out.println(btn.getText());
            JFrame clock = new TextClock1();
            clock.setVisible(true);
        }
    }
    
    public class BatteryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();
            System.out.println(btn.getText());
            JFrame battery = new battery1();
            battery.setVisible(true);
        }
    }
    
    public class TaskListener implements ActionListener {
        
        public void actionPerformed(ActionEvent ae){
            
            
                    JButton btn = (JButton) ae.getSource();
                    sg = new task();
                     
                  
        }
    }

    class ControlPanelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JFrame control_frame = new JFrame("control panel");
            control_frame.setLayout(new FlowLayout());
            JButton control = new JButton("CPU SCHEDULER", cpu_icon);
            control_frame.setSize(300, 300);
            control_frame.setVisible(true);

            control_frame.add(control);
            control.addActionListener(new CpuListener());
        }

        class CpuListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                //scheduler sc=new scheduler();

                java.awt.EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new scheduler().setVisible(true);
                    }
                });

            }
        }
    }

    class Serverlistener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();
            //System.out.println(btn.getText());
            //  OsStart o = new OsStart();
             //o.exit_thread();
            //NWMServer rj = new Sys_server();
            //nwm.setVisible(true);
            //throw new UnsupportedOperationException("Not supported yet.");
            
            
      // RJ = new ServerGUI("Virtual Operating System : LAN media tranfer ");
//               java.awt.EventQueue.invokeLater(new Runnable() {
//
//                  public void run() {
//        ServerGUI.cons.fill = GridBagConstraints.HORIZONTAL;
//
//        ServerGUI.cons.gridx = (noOfClient - 1) % 4;
//        ServerGUI.cons.gridy = (noOfClient - 1) / 4;
//
//        ServerGUI.gridbag.setConstraints(thumbnail, ServerGUI.cons);
//
//        ServerGUI.allImagePane.add(thumbnail);
//        ServerGUI.allImagePane.validate();
//        ServerGUI.imageScrollPane.validate();
//                  }                      
    //ExecutorService threadExecutor = Executors.newCachedThreadPool();
                        //NWMServer rj = new Sys_server();
   // threadExecutor.execute( rj  );
                        //new Sys_server().run();
      //              }
             //   });
        }
    }
            
    public class ButtonListener implements ExtendedActionListener {
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();

             String ext1 = ae.getActionCommand().substring(ae.getActionCommand().indexOf("."), ae.getActionCommand().length());
            if (ext1.equals(".txt")) {
                File f = fileButtonMap.get(btn);
                
                Frame frame = new notepad(f);

                frame.setSize(500, 400);
                frame.setVisible(true);
                frame.show();
            } else if (ext1.equals(".gif")) {
                File f = fileButtonMap.get(btn);
                
                JFrame frame = new ImageViewer(f);


                frame.setSize(500, 400);
                frame.setVisible(true);
                frame.show();
            } else if (ext1.equals(".dir")) {
            try
            {
             File f = fileButtonMap.get(btn);
             f.mkdir();
            }
            catch(Exception e)
            {}
            }
        }
    }

    
    public class CreateNewFileListener implements ExtendedActionListener {
        JFrame controlpf;

        public void actionPerformed(ActionEvent ae) {
            /*controlpf=new JFra    me("CONTROL PANEL      ");
            controlpf.setSize(400,400);
            controlpf.setVisible(true);*/
             

            rename r = new rename();
            String set_name = r.setRename();
            JButton button = new JButton();
            if (set_name != null) {
                String ext = set_name.substring(set_name.indexOf("."), set_name.length());
                if (ext.equals(".gif")) {
                    ImageIcon paint_image_icon = new ImageIcon("imageviewer.png");
                    button.setIcon(paint_image_icon);
                   
                } 
                
                else if (ext.equals(".txt")) 
                {
                    //new_add_notepad_icon = new JButton();
                    ImageIcon paint_notepad_icon = new ImageIcon("notepad.gif");
                    button.setIcon(paint_notepad_icon);
                    //JFrame note = new notepad();
                    //note.setVisible(true);

                } else if (ext.equals(".dir")) {
                    // new_add_folder_icon = new JButton();
                    ImageIcon paint_folder_icon = new ImageIcon("folder.jpg");
                    button.setIcon(paint_folder_icon);
                }
                
                try {
                    File f = createFile(set_name);
                    button.setText(set_name);
                    button.addActionListener(new ButtonListener());
                    count++;
                    main_screen.add(button);
                    fileButtonMap.put(button, f);
                } catch (IOException ex) {
                    Logger.getLogger(startmenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            System.out.println(count);
            }

            main_screen.revalidate();
            main_screen.repaint();
        }
    }

    class Lis implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
//mycomp m=new mycomp();
        }
    }

    public File createFile(String fileName) throws IOException {
        File f;
        f = new File("E:/memory/" + fileName);
        //if(ext1.)
        if (!f.exists()) {
            f.createNewFile();
        }
        return f;
    }
}