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

    PlayScreen() {
        screenWidth = 80;
        screenHeight = 21;
        world = new WorldBuilder(90, 32, 8).build();
    }

    public void displayOutput(AsciiPanel terminal) {
        int left = Math.max(0, Math.min(centerX - screenWidth / 2, world.getWidth() - screenWidth));
        int top = Math.max(0, Math.min(centerY - screenHeight / 2, world.getHeight() - screenHeight));

        displayTiles(terminal, left, top);

        terminal.write('X', centerX - left, centerY - top);

        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 22);
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                return new LoseScreen();
            case KeyEvent.VK_ENTER:
                return new WinScreen();
            case KeyEvent.VK_H:
                scrollBy(-1, 0);
                break;
            case KeyEvent.VK_L:
                scrollBy(1, 0);
                break;
            case KeyEvent.VK_K:
                scrollBy(0, -1);
                break;
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

    private void displayTiles(AsciiPanel terminal, int left, int top) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.getTileGlyph(wx, wy), x, y, world.getTileColor(wx, wy));
            }
        }
    }

    private void scrollBy(int mx, int my) {
        centerX = Math.max(0, Math.min(centerX + mx, world.getWidth() - 1));
        centerY = Math.max(0, Math.min(centerY + my, world.getHeight() - 1));
    }
}
