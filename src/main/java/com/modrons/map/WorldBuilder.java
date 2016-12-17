package com.modrons.map;

/**
 * Created by rhys on 12/17/16.
 */
public final class WorldBuilder {

    private Tile[][] tiles;
    private int width;
    private int height;

    private WorldBuilder() {
    }

    public static WorldBuilder aWorld() {
        return new WorldBuilder();
    }

    public WorldBuilder withDimensions(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];

        return this;
    }

    public WorldBuilder makeCaves(int smoothing) {
        return randomizeTiles().smooth(smoothing);
    }

    public World build() {
        return new World(tiles);
    }

    private WorldBuilder randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }

        return this;
    }

    // Cellular Automata - let's do some reading B O Y S.
    // This is a very messy algorithm and needs refactoring. I will comment out parts and cut into
    // private methods eventually. It also could be optimized severely, look at all those goddamn loops.
    private WorldBuilder smooth(int times) {
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
            tiles = smoothed;
        }

        return this;
    }
}
