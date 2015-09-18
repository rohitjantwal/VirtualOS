
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BackProcess;

import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Rohit
 */
public class DirectoryRestrictedFileSystemView extends FileSystemView
{
    private final File[] rootDirectories;

    public  DirectoryRestrictedFileSystemView(File rootDirectory)
    {
        this.rootDirectories = new File[] {rootDirectory};
    }

    public DirectoryRestrictedFileSystemView(File[] rootDirectories)
    {
        this.rootDirectories = rootDirectories;
    }

    //To create new folder in directory
    //FileSystemView fsv = new DirectoryRestrictedFileSystemView( new File[] {
    //new File("X:\\"),
    //new File("Y:\\")
    //});
    //JFileChooser fileChooser = new JFileChooser(fsv);
    //Override modules are executed in sequence before your main module is loaded,
    //making it possible to run additional code on startup & modify built in prototypes and functions. 
    
    @Override
    //It overrides existing methods(that match) present in class FileSytemView by ones defined where.
    //Do it so that you can take advantage of the compiler checking to make sure you actually are 
    //overriding a method when you think you are. This way, if you make a common mistake of misspelling
    //a method name or not correctly matching the parameters, 
    //you will be warned that you method does not actually override as you think it does. 
    // Secondly, it makes your code easier to understand because 
    //it is more obvious when methods are overwritten.
    
    public File createNewFolder(File containingDir) throws IOException
    {       
        throw new UnsupportedOperationException("Unable to create directory");
    }

    @Override
    public File[] getRoots()
    {
        return rootDirectories;
    }

    //review
    
    @Override
    public boolean isRoot(File file)// Determines if the given file is a root in the navigatable tree(s).
    {
        for (File root : rootDirectories) {
            if (root.equals(file)) { //equals( ) method compares the characters inside a String object
                return true;
            }
        }
        return false;
    }
}