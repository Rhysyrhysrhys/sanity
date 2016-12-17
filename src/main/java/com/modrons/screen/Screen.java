package com.modrons.screen;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public interface Screen {

    void displayOutput(AsciiPanel term);

    Screen respondToUserInput(KeyEvent key);
}
