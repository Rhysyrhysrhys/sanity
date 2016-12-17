package com.modrons.screen;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

/**
 * Created by rhys on 12/17/16.
 */
public class PlayScreen implements Screen {

    private static final int ESCAPE = KeyEvent.VK_ESCAPE;
    private static final int ENTER = KeyEvent.VK_ENTER;

    public void displayOutput(AsciiPanel term) {
        term.write("You are having fun.", 1, 1);
        term.writeCenter("-- press [escape] to lose or [enter] to win --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case ESCAPE:
                return new LoseScreen();
            case ENTER:
                return new WinScreen();
        }

        return this;
    }
}
