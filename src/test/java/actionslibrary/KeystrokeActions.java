package actionslibrary;

import java.awt.*;
import java.awt.event.KeyEvent;

public interface KeystrokeActions {

    Robot keystroke = null;

    default void windowsCopy(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

    }

    default void windowsPaste(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

    }

    default void windowsCopyPaste(){
        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_COPY);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);

        keystroke.keyPress(KeyEvent.VK_CONTROL);
        keystroke.keyPress(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_V);
        keystroke.keyRelease(KeyEvent.VK_CONTROL);
    }


}
