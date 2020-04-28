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

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class SpeechrecMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "speechrec_2F291C106B109EC7C3836CE86D1970A4";
    
    /** Component name */
    private static final String sComponentName = "speechrec";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(SpeechrecMCRFactory.class)
        );
    
    
    private SpeechrecMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            SpeechrecMCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{9,2,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
