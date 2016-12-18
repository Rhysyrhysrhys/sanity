package com.modrons.screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

/**
 * Created by rhys on 12/17/16.
 */
public class WinScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.write("You won.", 1, 1);
        terminal.writeCenter("-- press [enter] to restart --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new PlayScreen() : this;
    }
}
