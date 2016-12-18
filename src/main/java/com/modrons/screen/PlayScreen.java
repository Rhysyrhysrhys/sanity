package com.modrons.screen;

import java.awt.event.KeyEvent;

import asciiPanel.AsciiPanel;

import com.modrons.map.World;
import com.modrons.map.WorldBuilder;

public class PlayScreen implements Screen {

    private final World world;
    private final int screenWidth;
    private final int screenHeight;

    private int centerX;
    private int centerY;


    PlayScreen(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        world = new WorldBuilder(screenWidth, screenHeight, 1).build();
    }

    public void displayOutput(AsciiPanel term) {
        displayTiles(term, getScrollX(), getScrollY());
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_H:
                scrollBy(-1, 0);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_L:
                scrollBy(1, 0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_K:
                scrollBy(0, -1);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_J:
                scrollBy(0, 1);
                break;
            case KeyEvent.VK_Y:
                scrollBy(-1, -1);
                break;
            case KeyEvent.VK_U:
                scrollBy(1, -1);
                break;
            case KeyEvent.VK_B:
                scrollBy(-1, 1);
                break;
            case KeyEvent.VK_N:
                scrollBy(1, 1);
                break;
        }

        return this;
    }

    private int getScrollX() {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
    }

    private int getScrollY() {
        return Math.max(0, Math.min(centerY - screenHeight / 2, world.getHeight() - screenHeight));
    }

    private void scrollBy(int mx, int my) {
        centerX = Math.max(0, Math.min(centerX + mx, world.getWidth() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.getHeight() - 1));
    }

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.getTileGlyph(wx, wy), x, y, world.getTileColor(wx, wy));
            }
        }
    }
}
