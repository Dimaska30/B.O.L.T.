package com.doubleg.bolt.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.MyGame;

/**
 * Created by Администратор on 21.05.2017.
 */

public class MainMenuScreen implements Screen, InputProcessor {
    MyGame game;
    Texture texture;

    public MainMenuScreen(MyGame game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
        texture = new Texture(Gdx.files.internal("menu.png"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        game.var.batch.begin();
        game.var.batch.draw(texture, 0, 0, GlobalVar.ScreenWidth, GlobalVar.ScreenHeight);
        game.var.batch.end();
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        game.setScreen(new PlayScreen(game.var));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
