package com.doubleg.bolt.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.doubleg.bolt.Bunch;
import com.doubleg.bolt.Drawer;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.WorkSpace;
import com.doubleg.bolt.WorkSpaceComponent.GraphicComponent;
import com.doubleg.bolt.World;

/**
 * Created by Dimaska on 07.05.2017.
 */

public final class PlayScreen implements Screen {
    private World world;
    private Drawer drawer;
    private WorkSpace workSpace;
    private GlobalVar vars;


    public PlayScreen(GlobalVar vars){
        workSpace = new WorkSpace(vars);
        GraphicComponent tempV=new GraphicComponent(workSpace,vars);
        workSpace.setUI(tempV);
        world = new World();
        Bunch bunch=new Bunch(world.getPlayer(),workSpace);
        drawer=new Drawer(world,workSpace,vars);
        InputMultiplexer multiplexer = new InputMultiplexer(workSpace.getInput().getUI(), workSpace.getWindow().getUI());
        Gdx.input.setInputProcessor(multiplexer);
        this.vars=vars;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
     Gdx.gl.glClearColor( 1, 1, 1, 1 );
     Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT );
        drawer.draw();
        world.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
