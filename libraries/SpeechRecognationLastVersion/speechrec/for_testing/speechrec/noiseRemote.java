/*
 * MATLAB Compiler: 6.4 (R2017a)
 * Date: Wed May 23 21:46:10 2018
 * Arguments: 
 * "-B""macro_default""-W""java:speechrec,slient""-T""link:lib""-d""C:\\Users\\umut\\Desktop\\SpeechRecognationLastVersion\\speechrec\\for_testing""class{slient:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\recs.m}""class{noise:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\Un2.m}""class{train_all:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\train_all_words.m}""class{testword:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\test_word.m}""class{kayit:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\Untitled.m}""class{train:C:\\Program 
 * Files\\MATLAB\\R2017a\\bin\\test\\Kod\\train_word.m}"
 */

package speechrec;

import com.mathworks.toolbox.javabuilder.pooling.Poolable;
import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The <code>noiseRemote</code> class provides a Java RMI-compliant interface to MATLAB 
 * functions. The interface is compiled from the following files:
 * <pre>
 *  C:\Program Files\MATLAB\R2017a\bin\test\Kod\Un2.m
 * </pre>
 * The {@link #dispose} method <b>must</b> be called on a <code>noiseRemote</code> 
 * instance when it is no longer needed to ensure that native resources allocated by this 
 * class are properly freed, and the server-side proxy is unexported.  (Failure to call 
 * dispose may result in server-side threads not being properly shut down, which often 
 * appears as a hang.)  
 *
 * This interface is designed to be used together with 
 * <code>com.mathworks.toolbox.javabuilder.remoting.RemoteProxy</code> to automatically 
 * generate RMI server proxy objects for instances of speechrec.noise.
 */
public interface noiseRemote extends Poolable
{
    /**
     * Provides the standard interface for calling the <code>Un2</code> MATLAB function 
     * with 3 input arguments.  
     *
     * Input arguments to standard interface methods may be passed as sub-classes of 
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of any 
     * supported Java type (i.e. scalars and multidimensional arrays of any numeric, 
     * boolean, or character type, or String). Arguments passed as Java types are 
     * converted to MATLAB arrays according to default conversion rules.
     *
     * All inputs to this method must implement either Serializable (pass-by-value) or 
     * Remote (pass-by-reference) as per the RMI specification.
     *
     * Documentation as provided by the author of the MATLAB function:
     * <pre>
     * % Design a bandpass filter that filters out between 700 to 12000 Hz
     * </pre>
     *
     * @param rhs The inputs to the MATLAB function.
     *
     * @return Array of length nargout containing the function outputs. Outputs are 
     * returned as sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>. 
     * Each output array should be freed by calling its <code>dispose()</code> method.
     *
     * @throws java.rmi.RemoteException An error has occurred during the function call or 
     * in communication with the server.
     */
    public Object[] Un2(Object... rhs) throws RemoteException;
  
    /** 
     * Frees native resources associated with the remote server object 
     * @throws java.rmi.RemoteException An error has occurred during the function call or in communication with the server.
     */
    void dispose() throws RemoteException;
}
