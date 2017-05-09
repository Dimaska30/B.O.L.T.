package com.doubleg.bolt;

import com.badlogic.gdx.files.FileHandle;

/**
 * Created by Dimaska on 07.05.2017.
 */

public class World {
    Robot player;
    int[][] map;
    int startX;
    int startY;

    public World(WorkSpace work){
        player=new Robot(work);
        loadMap();
        setStartCoordinate();
        setPlayer();
    }

    public void update(float deltaTime){

    }

    public void loadMap(){
        map= new int[][]{
                {1,1,1},
                {1,0,1},
                {1,0,1},
                {1,0,1},
                {1,0,1},
                {1,2,1},
                {1,1,1}
        };
    }

    private void setPlayer(){
        int posStartX=-1;
        int posStartY=-1;
        for(int y=0;y<map.length;y++){
            for (int x=0;x<map[0].length;x++){
                if(map[y][x]==2){
                    posStartX=x;
                    posStartY=y;
                }
            }
            if(posStartX>=0 && posStartY>=0){
                break;
            }
        }
        player.setStartPosition(
                posStartX*GlobalVar.TileSize+startX,
                posStartY*GlobalVar.TileSize+startY);
    }

    private void setStartCoordinate(){
        startX=(GlobalVar.ScreenWidth/8*5)/2 - map[0].length/2*GlobalVar.TileSize;
        startY=GlobalVar.ScreenHeight/2 - map.length/2*GlobalVar.TileSize;
    }

    public Robot getPlayer() {
        return player;
    }

    public int[][] getMaps() {
        return map;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
