package com.doubleg.bolt.RobotComponents;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ArrayMap;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.States.RobotState;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class GraphicComponent {
    ArrayMap<String,TextureRegion> textures;
    TextureRegion currentTexture;

    public GraphicComponent(){
        textures=new ArrayMap<String, TextureRegion>();
        String[] name={"CurlUpFrontal","CurlUpRight","CurlUpLeft", "CurlUpRear",
                "StandFrontal","StandRight","StandLeft","StandRear"};
        for(int a=1;a<name.length+1;a++){
            try {
                TextureRegion temp = new TextureRegion(new Texture(Gdx.files.internal("robots/" + a + ".png")));
                textures.put(name[a-1],temp);
            }catch (GdxRuntimeException e){
                e.printStackTrace();
                Gdx.app.exit();
            }
        }
    }

    public void setCurrentTexture(RobotState state, Vector2 dir){
        String first="Stand";
        String second="Frontal";
        if(state==RobotState.CurlUp || state==RobotState.RollBackwards || state==RobotState.RollForward){
            first="CurlUp";
        }else{
            first="Stand";
        }
        if(dir.x==1 && dir.y==0){
            second="Right";
        }else if(dir.x==-1 && dir.y==0){
            second="Left";
        }else if(dir.x==0 && dir.y==1){
            second="Rear";
        }else if(dir.x==0 && dir.y==-1){
            second="Frontal";
        }
        currentTexture=textures.get(first+second);
    }

    public void draw(SpriteBatch spriteBatch, float x, float y) {
        spriteBatch.draw(currentTexture, x, y, GlobalVar.TileSize, GlobalVar.TileSize);
    }
}
