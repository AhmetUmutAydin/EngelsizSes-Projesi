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

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;
import java.util.*;

/**
 * The <code>kayit</code> class provides a Java interface to MATLAB functions. 
 * The interface is compiled from the following files:
 * <pre>
 *  C:\Program Files\MATLAB\R2017a\bin\test\Kod\Untitled.m
 * </pre>
 * The {@link #dispose} method <b>must</b> be called on a <code>kayit</code> instance 
 * when it is no longer needed to ensure that native resources allocated by this class 
 * are properly freed.
 * @version 0.0
 */
public class kayit extends MWComponentInstance<kayit>
{
    /**
     * Tracks all instances of this class to ensure their dispose method is
     * called on shutdown.
     */
    private static final Set<Disposable> sInstances = new HashSet<Disposable>();

    /**
     * Maintains information used in calling the <code>Untitled</code> MATLAB function.
     */
    private static final MWFunctionSignature sUntitledSignature =
        new MWFunctionSignature(/* max outputs = */ 0,
                                /* has varargout = */ false,
                                /* function name = */ "Untitled",
                                /* max inputs = */ 3,
                                /* has varargin = */ false);

    /**
     * Shared initialization implementation - private
     * @throws MWException An error has occurred during the function call.
     */
    private kayit (final MWMCR mcr) throws MWException
    {
        super(mcr);
        // add this to sInstances
        synchronized(kayit.class) {
            sInstances.add(this);
        }
    }

    /**
     * Constructs a new instance of the <code>kayit</code> class.
     * @throws MWException An error has occurred during the function call.
     */
    public kayit() throws MWException
    {
        this(SpeechrecMCRFactory.newInstance());
    }
    
    private static MWComponentOptions getPathToComponentOptions(String path)
    {
        MWComponentOptions options = new MWComponentOptions(new MWCtfExtractLocation(path),
                                                            new MWCtfDirectorySource(path));
        return options;
    }
    
    /**
     * @deprecated Please use the constructor {@link #kayit(MWComponentOptions componentOptions)}.
     * The <code>com.mathworks.toolbox.javabuilder.MWComponentOptions</code> class provides an API to set the
     * path to the component.
     * @param pathToComponent Path to component directory.
     * @throws MWException An error has occurred during the function call.
     */
    public kayit(String pathToComponent) throws MWException
    {
        this(SpeechrecMCRFactory.newInstance(getPathToComponentOptions(pathToComponent)));
    }
    
    /**
     * Constructs a new instance of the <code>kayit</code> class. Use this constructor to 
     * specify the options required to instantiate this component.  The options will be 
     * specific to the instance of this component being created.
     * @param componentOptions Options specific to the component.
     * @throws MWException An error has occurred during the function call.
     */
    public kayit(MWComponentOptions componentOptions) throws MWException
    {
        this(SpeechrecMCRFactory.newInstance(componentOptions));
    }
    
    /** Frees native resources associated with this object */
    public void dispose()
    {
        try {
            super.dispose();
        } finally {
            synchronized(kayit.class) {
                sInstances.remove(this);
            }
        }
    }
  
    /**
     * Invokes the first MATLAB function specified to MCC, with any arguments given on
     * the command line, and prints the result.
     *
     * @param args arguments to the function
     */
    public static void main (String[] args)
    {
        try {
            MWMCR mcr = SpeechrecMCRFactory.newInstance();
            mcr.runMain( sUntitledSignature, args);
            mcr.dispose();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Calls dispose method for each outstanding instance of this class.
     */
    public static void disposeAllInstances()
    {
        synchronized(kayit.class) {
            for (Disposable i : sInstances) i.dispose();
            sInstances.clear();
        }
    }

    /**
     * Provides the interface for calling the <code>Untitled</code> MATLAB function 
     * where the first argument, an instance of List, receives the output of the MATLAB function and
     * the second argument, also an instance of List, provides the input to the MATLAB function.
     * <p>
     * Description as provided by the author of the MATLAB function:
     * </p>
     * <pre>
     * %set(handles.word1,'String',wrd),return etme,grafik,kaydedilen kelime varsa
     * %sonuna numeric ekle,keyword,otomatik addpath
     * </pre>
     * @param lhs List in which to return outputs. Number of outputs (nargout) is
     * determined by allocated size of this List. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs List containing inputs. Number of inputs (nargin) is determined
     * by the allocated size of this List. Input arguments may be passed as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or
     * as arrays of any supported Java type. Arguments passed as Java types are
     * converted to MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void Untitled(List lhs, List rhs) throws MWException
    {
        fMCR.invoke(lhs, rhs, sUntitledSignature);
    }

    /**
     * Provides the interface for calling the <code>Untitled</code> MATLAB function 
     * where the first argument, an Object array, receives the output of the MATLAB function and
     * the second argument, also an Object array, provides the input to the MATLAB function.
     * <p>
     * Description as provided by the author of the MATLAB function:
     * </p>
     * <pre>
     * %set(handles.word1,'String',wrd),return etme,grafik,kaydedilen kelime varsa
     * %sonuna numeric ekle,keyword,otomatik addpath
     * </pre>
     * @param lhs array in which to return outputs. Number of outputs (nargout)
     * is determined by allocated size of this array. Outputs are returned as
     * sub-classes of <code>com.mathworks.toolbox.javabuilder.MWArray</code>.
     * Each output array should be freed by calling its <code>dispose()</code>
     * method.
     *
     * @param rhs array containing inputs. Number of inputs (nargin) is
     * determined by the allocated size of this array. Input arguments may be
     * passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     * @throws MWException An error has occurred during the function call.
     */
    public void Untitled(Object[] lhs, Object[] rhs) throws MWException
    {
        fMCR.invoke(Arrays.asList(lhs), Arrays.asList(rhs), sUntitledSignature);
    }

    /**
     * Provides the standard interface for calling the <code>Untitled</code> MATLAB function with 
     * 3 comma-separated input arguments.
     * Input arguments may be passed as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>, or as arrays of
     * any supported Java type. Arguments passed as Java types are converted to
     * MATLAB arrays according to default conversion rules.
     *
     * <p>
     * Description as provided by the author of the MATLAB function:
     * </p>
     * <pre>
     * %set(handles.word1,'String',wrd),return etme,grafik,kaydedilen kelime varsa
     * %sonuna numeric ekle,keyword,otomatik addpath
     * </pre>
     * @param rhs The inputs to the MATLAB function.
     * @return Array of length nargout containing the function outputs. Outputs
     * are returned as sub-classes of
     * <code>com.mathworks.toolbox.javabuilder.MWArray</code>. Each output array
     * should be freed by calling its <code>dispose()</code> method.
     * @throws MWException An error has occurred during the function call.
     */
    public Object[] Untitled(Object... rhs) throws MWException
    {
        Object[] lhs = new Object[0];
        fMCR.invoke(Arrays.asList(lhs), 
                    MWMCR.getRhsCompat(rhs, sUntitledSignature), 
                    sUntitledSignature);
        return lhs;
    }
}
