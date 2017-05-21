package com.doubleg.bolt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class GlobalVar {
    public static final int ScreenWidth=2000;
    public static final int ScreenHeight=1000;
    public static final int TileSize=100;
    public static final String GoAhead="GoAhead";
    public static final String GoBack="GoBack";
    public static final String TurnLeft="TurnLeft";
    public static final String TurnRight="TurnRight";
    public static final String Stand="Stand";
    public static final String CurlUp="CurlUp";
    public static final String RollForward="RollForward";
    public static final String RollBackwards="RollBackwards";
    public static final String Stop = "Stop";
    public OrthographicCamera camera;
    public Skin skin;
    public SpriteBatch batch;
    public ExtendViewport port;
    public static boolean play = false;

    GlobalVar(){
        camera=new OrthographicCamera();
        camera.setToOrtho(false,GlobalVar.ScreenWidth,GlobalVar.ScreenHeight);
        port = new ExtendViewport(2000, 1000, camera);
        batch = new SpriteBatch(60);
        batch.setProjectionMatrix(camera.combined);

        skin=new Skin(Gdx.files.internal("skin/skin-composer-ui.json"),new TextureAtlas(Gdx.files.internal("skin/skin-composer-ui.atlas")));
    }
}
