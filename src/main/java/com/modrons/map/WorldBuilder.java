package com.modrons.map;

public final class WorldBuilder {

    private final LandscapeAutomata landscapeAutomata;
    private final int smoothing;

    private Tile[][] tiles;

    public WorldBuilder(int width, int height, int smoothing) {
        this.smoothing = smoothing;
        this.tiles = new Tile[width][height];

        landscapeAutomata = new DefaultAutomata(width, height);
    }

    public World build() {
        return new World(makeCaves(smoothing));
    }

    private Tile[][] makeCaves(int smoothing) {
        return landscapeAutomata.smooth(landscapeAutomata.randomizeTiles(tiles), smoothing);
    }

}
