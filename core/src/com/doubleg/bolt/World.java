package com.doubleg.bolt;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by Dimaska on 07.05.2017.
 */

public class World {
    Robot player;
    int startX;
    int startY;
    boolean play;
    TiledMap maps;
    OrthographicCamera gameCamera;
    Array<Rectangle> wall;

    public World() {
        player = new Robot(this);
        wall = new Array<Rectangle>();
        loadMap();
        setStartCoordinate();
        setPlayer();
        play = false;
    }

    public void update(float deltaTime){
        player.update(deltaTime);
    }

    public void loadMap(){
        maps = new TmxMapLoader().load("2.tmx");
        Iterator<MapObject> i = maps.getLayers().get("objects").getObjects().iterator();
        MapObject temp;
        while (i.hasNext()) {
            temp = i.next();
            String type = (String) temp.getProperties().get("name");
            if (type != null && type.equals("Wall")) {
                Rectangle rect = new Rectangle();
                rect.setX((Float) temp.getProperties().get("x"));
                rect.setY((Float) temp.getProperties().get("y"));
                rect.setWidth((Float) temp.getProperties().get("width"));
                rect.setHeight((Float) temp.getProperties().get("height"));
                wall.add(rect);
            }
        }

    }

    private void setPlayer(){
        float x = (Float) maps.getLayers().get("objects").getObjects().get("Generate").getProperties().get("x");
        float y = (Float) maps.getLayers().get("objects").getObjects().get("Generate").getProperties().get("y");
        player.setStartPosition(x, y);
    }

    private void setStartCoordinate(){
        startX = 0;
        startY = 0;
    }

    public Robot getPlayer() {
        return player;
    }

    public TiledMap getMaps() {
        return maps;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public Array<Rectangle> getWall() {
        return wall;
    }

    public void setCamera(OrthographicCamera camera) {
        gameCamera = camera;
    }
}
