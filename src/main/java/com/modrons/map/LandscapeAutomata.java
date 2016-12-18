package com.modrons.map;

interface LandscapeAutomata {

    Tile[][] randomizeTiles(Tile[][] tiles);

    Tile[][] smooth(Tile[][] tiles, int times);

}
