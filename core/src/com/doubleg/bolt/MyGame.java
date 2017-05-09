package com.doubleg.bolt;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.doubleg.bolt.Screens.PlayScreen;

public class MyGame extends Game {

    public GlobalVar var;
    @Override
    public void create() {
        var=new GlobalVar();
        setScreen(new PlayScreen(var));
    }
}
