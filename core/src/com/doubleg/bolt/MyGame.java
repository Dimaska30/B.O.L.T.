package com.doubleg.bolt;

import com.badlogic.gdx.Game;
import com.doubleg.bolt.Screens.MainMenuScreen;

public class MyGame extends Game {

    public GlobalVar var;
    @Override
    public void create() {
        var=new GlobalVar();
        setScreen(new MainMenuScreen(this));
    }
}
