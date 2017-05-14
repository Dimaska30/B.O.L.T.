package com.doubleg.bolt.WorkSpaceComponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.WorkSpace;

/**
 * Created by Администратор on 10.05.2017.
 */

public class InputComponent {
    private Stage UI;
    private WorkSpace workSpace;

    public InputComponent(final WorkSpace workSpace, final GlobalVar vars) {
        this.workSpace = workSpace;
        UI = new Stage();
        UI.getBatch().setProjectionMatrix(vars.camera.combined);
        TextButton up = new TextButton("Go Back", vars.skin);
        up.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.GoBack);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        TextButton down = new TextButton("Go Ahead", vars.skin);
        down.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.GoAhead);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        TextButton left = new TextButton("Turn Left", vars.skin);
        left.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.TurnLeft);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        TextButton right = new TextButton("Turn Right", vars.skin);
        right.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.TurnRight);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });

        Window buttons = new Window("Functions", vars.skin);
        buttons.setMovable(true);
        buttons.setPosition(0, 0);
        buttons.setHeight(Gdx.graphics.getHeight());
        buttons.setWidth(Gdx.graphics.getWidth() / 8 * 1.5f);
        buttons.setResizable(true);
        UI.addActor(buttons);

        buttons.add(up);
        buttons.row();
        buttons.add(down);
        buttons.row();
        buttons.add(right);
        buttons.row();
        buttons.add(left);
        buttons.row();

        TextButton play = new TextButton("play", vars.skin);
        play.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.start();
                GlobalVar.play = true;
                noneTouch();
                return true;
            }
        });
        play.setPosition(0, 0);
        play.setWidth(100);
        play.setHeight(100);
        UI.addActor(play);
    }

    public void noneTouch() {
        UI.unfocusAll();
    }

    public Stage getUI() {
        return UI;
    }
}
