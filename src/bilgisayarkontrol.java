
import java.awt.Robot;
import java.awt.event.InputEvent;
 
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class bilgisayarkontrol {

 

    
    
    public static void movemodify(Robot r, int X, int Y,int curX,int curY){
    	r.mouseMove(curX+X, curY+Y);
       
        
    }

   

    public static void moveMouse(Robot r, int X, int Y){
        r.mouseMove(X, Y);
    }

    //
    // Click mouse button twice
    //

    public static void  doubleClickMouse(Robot r){
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        r.delay(1000);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    //
    // Click mouse buttons n - times
    //

    public static void  clickMouse(String button,Robot r, int number){
        int mouse;
        switch (button) {
            case "left": mouse = InputEvent.BUTTON1_MASK;break;
            case "right": mouse = InputEvent.BUTTON3_MASK;break;
            case "middle": mouse = InputEvent.BUTTON2_MASK;break;
            default: mouse = InputEvent.BUTTON1_MASK;break;
        }
        for(int i =0;i<number;i++){
            r.mousePress(mouse);
            r.delay(1000);
            r.mouseRelease(mouse);
            r.delay(1000);
        }
    }

    //
    // Press Enter
    //

    public static void  pressEnter(Robot r){
        r.delay(1000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.delay(1000);
    }
    public static void  pressspace(Robot r){
        r.delay(1000);
        r.keyPress(KeyEvent.VK_SPACE);
        r.delay(1000);
    }

    //
    // Press Tab
    //
    public static void  pressTab(Robot r){
        r.delay(1000);
        r.keyPress(KeyEvent.VK_TAB);
        r.delay(1000);
    }

    //
    // Copy CTRL + C
    //
    public static void copy(Robot r){
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_C);
        r.delay(1000);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_C);
    }

    //
    // Paste CTRL + V
    //
    public static void paste(Robot r){
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.delay(1000);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
    }

    //
    // Paste CTRL + V
    //
    public static void pasteText(String text, Robot r){
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        //Paste attached file paste
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_V);
    }

    //
    // Select All CTRL + A
    //
    public static void  selectAll(Robot r){
        //Select all
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_A);
        r.delay(1000);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_A);
    }

    //
    // Select press buttons
    //
    public static void  pressButton(Robot r, String button, int number){
        for(int i =0;i<number;i++){
            r.delay(1000); //set the delay
            type(r, button);
            r.delay(1000); //set the delay
            type(r, button);
        }
    }

    public static void  type(Robot r, String character) {
    	
    	if (character != null) {
            try {
               
                for (int i = 0; i < character.length(); i++) {
                    final char ch = character.charAt(i);
                    final boolean upperCase = Character.isUpperCase(ch);
                    final int keyCode = KeyEvent.getExtendedKeyCodeForChar(ch);
                    r.delay(10);
                    if (upperCase) {
                        r.keyPress(KeyEvent.VK_SHIFT);
                    }
                    r.keyPress(keyCode);
                    r.keyRelease(keyCode);
                    if (upperCase) {
                        r.keyRelease(KeyEvent.VK_SHIFT);
                    }
                }

            } catch (final Exception e) {
                System.out.println(e);
            }
        }
    	
       

                
        }
    
}
