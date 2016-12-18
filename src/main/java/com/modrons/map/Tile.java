package com.modrons.map;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public enum Tile {

    FLOOR((char) 250, AsciiPanel.yellow),
    WALL((char) 177, AsciiPanel.yellow),
    BOUND('x', AsciiPanel.brightBlack);

    private final char glyph;
    private final Color color;

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public char getGlyph() {
        return glyph;
    }

    public Color getColor() {
        return color;
    }
}
