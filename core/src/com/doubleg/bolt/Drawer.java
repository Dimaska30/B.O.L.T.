package com.doubleg.bolt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.shaders.BaseShader;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Dimaska on 08.05.2017.
 */

public class Drawer {
    SpriteBatch batch;
    ShapeRenderer renderer;
    Array<TextureRegion> mapTexture;

    World world;
    WorkSpace workSpace;

    public Drawer(World world,WorkSpace workSpace,GlobalVar vars){
        this.world=world;
        this.workSpace=workSpace;

        mapTexture=new Array<TextureRegion>();
        batch=new SpriteBatch();
        renderer=new ShapeRenderer();

        vars.camera.setToOrtho(false,GlobalVar.ScreenWidth,GlobalVar.ScreenHeight);
        batch.setProjectionMatrix(vars.camera.combined);

        renderer.setProjectionMatrix(vars.camera.combined);

    }

    public void draw(){
        batch.begin();

        batch.disableBlending();
        drawMap(batch,world.getMaps());

        batch.enableBlending();
        world.player.draw(batch);

        batch.end();

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        renderer.setColor(Color.BLACK);
        renderer.rect(GlobalVar.ScreenWidth/8*5,0,GlobalVar.ScreenWidth/8*1.5f,GlobalVar.ScreenHeight);

        renderer.setColor(Color.BLUE);
        renderer.rect(GlobalVar.ScreenWidth/8*5,0,GlobalVar.ScreenWidth/8*1.5f,GlobalVar.ScreenHeight/4*1.5f);

        renderer.end();

        workSpace.UI.getUI().draw();
    }

    public void setMapTexture(Texture texture,int numTileX,int numTileY){
        mapTexture=new Array<TextureRegion>();

        for(int indexY=0;indexY<numTileY;indexY++){
            for(int indexX=0;indexX<numTileX;indexX++){
                mapTexture.add(new TextureRegion(texture,indexX*25,indexY*25,24,24));
            }
        }
    }

    public void drawMap(SpriteBatch sprite,int[][] map){
        for(int y=0;y<map.length;y++){
            for(int x=0;x<map[0].length;x++){
                sprite.draw(
                        mapTexture.get(map[y][x]),
                        x*GlobalVar.TileSize+world.getStartX(),
                        y*GlobalVar.TileSize+world.getStartY(),
                        GlobalVar.TileSize,
                        GlobalVar.TileSize);
            }
        }
    }
}
