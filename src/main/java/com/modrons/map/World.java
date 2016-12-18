package com.modrons.map;

import java.awt.Color;

public class World {

    private final Tile[][] tiles;
    private final int width;
    private final int height;

    World(Tile[][] tiles) {
        this.tiles = tiles;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getTileGlyph(int x, int y) {
        return tile(x, y).getGlyph();
    }

    public Color getTileColor(int x, int y) {
        return tile(x, y).getColor();
    }

    private Tile tile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return Tile.BOUND;
        }

        return tiles[x][y];
    }
}
