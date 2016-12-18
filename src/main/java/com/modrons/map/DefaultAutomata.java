package com.modrons.map;

class DefaultAutomata implements LandscapeAutomata {

    private final int width;
    private final int height;

    DefaultAutomata(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Tile[][] randomizeTiles(Tile[][] tiles) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }

        return tiles;
    }

    public Tile[][] smooth(Tile[][] tiles, int times) {
        Tile[][] smoothed = new Tile[width][height];

        for (int time = 0; time < times; time++) {

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;

                    for (int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height) {
                                continue;
                            }

                            if (tiles[x + ox][y + oy] == Tile.FLOOR) {
                                floors++;
                            } else {
                                rocks++;
                            }
                        }
                    }
                    smoothed[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
        }

        return smoothed;
    }
}