package com.doubleg.bolt;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

/**
 * Created by Dimaska on 08.05.2017.
 */

public class Drawer {
    SpriteBatch mapBatch;
    OrthographicCamera mapCamera;
    TiledMapRenderer renderer;

    ShapeRenderer render;

    World world;
    WorkSpace workSpace;

    public Drawer(World world, final WorkSpace workSpace, GlobalVar vars) {
        this.world=world;
        this.workSpace=workSpace;
        mapCamera = new OrthographicCamera();
        mapCamera.setToOrtho(false, GlobalVar.ScreenWidth, GlobalVar.ScreenHeight);
        mapBatch = new SpriteBatch(30);
        mapBatch.setProjectionMatrix(mapCamera.combined);
        render = new ShapeRenderer();
        render.setProjectionMatrix(mapCamera.combined);
        renderer = new OrthogonalTiledMapRenderer(world.getMaps(), mapBatch);
        world.setCamera(mapCamera);
        mapCamera.translate(-(2000 / 8 * 5 / 2 - (Integer) world.getMaps().getProperties().get("width") * 50), -(500 - (Integer) world.getMaps().getProperties().get("height") * 50));
    }

    public void draw(){
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.setColor(Color.BLACK);
        render.rect(0, 0, 2000 / 8 * 5, 1000);
        render.end();
        mapCamera.update();
        renderer.setView(mapCamera);
        renderer.render();

        mapBatch.begin();

        mapBatch.enableBlending();
        world.player.draw(mapBatch, world.getStartX(), world.getStartY());

        mapBatch.end();

        workSpace.getWindow().getUI().draw();
        workSpace.getInput().getUI().draw();

    }

    public void translateCamera(float x, float y) {
        mapCamera.translate(x, y);
    }
}
