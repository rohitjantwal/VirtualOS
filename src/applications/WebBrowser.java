/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applications;

/**
 *
 * @author Rohit
 */
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.text.html.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.lang.*;
import java.net.*;
import java.net.HttpURLConnection;
public class WebBrowser extends JFrame implements ActionListener,HyperlinkListener
{
private JEditorPane jep;
JTextField urlField;
JButton back = new JButton("",new ImageIcon("undo.gif"));
final JLabel statusBar = new JLabel(" ");
JButton Go=new JButton("GO");
String url = "";

public WebBrowser(String startingUrl)
{
super("Simple Web Browser : Developed in Java ");
setSize(1035,740);
//setDefaultCloseOperation(EXIT_ON_CLOSE);

Container con=getContentPane();
JPanel urlPanel = new JPanel();
urlPanel.setLayout(new BorderLayout());
urlField = new JTextField(startingUrl);
urlPanel.add(new JLabel("Site: "), BorderLayout.WEST);
urlPanel.add(urlField);
urlPanel.add(Go,BorderLayout.EAST);
Go.addActionListener(this);
urlField.addActionListener(this);
jep = new JEditorPane();
jep.setEditable(false);
jep.setEditorKit(new HTMLEditorKit());
jep.setContentType("text/html");
JScrollPane jsp = new JScrollPane(jep); 

getContentPane().add(jsp, BorderLayout.CENTER);
getContentPane().add(urlPanel, BorderLayout.NORTH);
getContentPane().add(statusBar, BorderLayout.SOUTH);
jep.addHyperlinkListener(new SimpleLinkListener(jep, urlField,statusBar));
}
public void actionPerformed(ActionEvent ae)
{
Object obj=ae.getSource();
String url1="http://www.google.com";
if(obj==urlField)
{
try
{
url=ae.getActionCommand();
url1=URLDecoder.decode(url);
jep.setPage(url);
}catch(Exception e){statusBar.setText("Error: " + e.getMessage());}
}
if(obj==Go)
{
try
{
jep.setPage(urlField.getText());
}catch(Exception e){statusBar.setText("Error: " + e.getMessage());}
}
}
public void hyperlinkUpdate(HyperlinkEvent e)
{
if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
{
jep = (JEditorPane) e.getSource();
try
{
jep.setPage(e.getURL());
}catch (Throwable t){t.printStackTrace();}
}
}
public static void main(String args[])
{
//Setting the proxy if needed.
/*System.getProperties().put("proxySet","true");
System.getProperties().put("proxyPort","8080");
System.getProperties().put("proxyHost","192.168.2.1");*/

String url = "";
url = "about:blank";
new WebBrowser(url).setVisible(true);
}
public class SimpleLinkListener implements HyperlinkListener
{
private JEditorPane pane;
private JTextField urlField;
private JLabel statusBar;
public SimpleLinkListener(JEditorPane jep, JTextField jtf, JLabel jl)
{
pane = jep;
urlField = jtf;
statusBar = jl;
}
public SimpleLinkListener(JEditorPane jep)
{
this(jep, null, null);
}
public void hyperlinkUpdate(HyperlinkEvent he)
{
HyperlinkEvent.EventType type = he.getEventType();
if (type == HyperlinkEvent.EventType.ENTERED)
{
if (statusBar != null)
{
statusBar.setText(he.getURL().toString());
}
}
else if(type == HyperlinkEvent.EventType.EXITED)
{
if(statusBar != null)
{
statusBar.setText(" ");
}
}
else if (type == HyperlinkEvent.EventType.ACTIVATED)
{
try
{
pane.setPage(he.getURL());
if (urlField != null)
{
jep.setPage(he.getURL());
urlField.setText(he.getURL().toString());
}
}
catch (FileNotFoundException fnfe){pane.setText("Could not open file: <tt>" + he.getURL() + "</tt>.<hr>");}
catch (Exception e){e.printStackTrace();}
}
}
}

}
