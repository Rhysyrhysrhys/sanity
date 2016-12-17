package com.modrons;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import asciiPanel.AsciiPanel;

import com.modrons.screen.Screen;
import com.modrons.screen.StartScreen;

public class AppMain extends JFrame implements KeyListener {

    private final AsciiPanel terminal;

    private Screen screen;

    AppMain() {
        terminal = new AsciiPanel();
    }

    void init() {
        add(terminal);
        pack();
        screen = new StartScreen();
        addKeyListener(this);
        repaint();
    }

    @Override
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }

    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}