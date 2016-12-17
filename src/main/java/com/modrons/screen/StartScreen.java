package com.modrons.screen;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

/**
 * Created by rhys on 12/17/16.
 */
public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel term) {
        term.write("Sanity: Tutorial Edition", 1, 1);
        term.writeCenter("-- press [enter] to start --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}