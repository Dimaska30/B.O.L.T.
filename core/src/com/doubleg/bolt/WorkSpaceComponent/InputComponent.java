package com.doubleg.bolt.WorkSpaceComponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Cell;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.WorkSpace;

import java.util.HashMap;

/**
 * Created by Администратор on 10.05.2017.
 */

public class InputComponent {
    private Stage UI;
    private WorkSpace workSpace;
    Array<Image> buttons;
    Window buttonWin;
    HashMap<String, Drawable> textures;

    public InputComponent(final WorkSpace workSpace, final GlobalVar vars) {
        this.workSpace = workSpace;
        UI = new Stage(vars.port, vars.batch);
        buttons = new Array<Image>();
        textures = new HashMap<String, Drawable>();
        Texture uop = new Texture(Gdx.files.internal("Buttons/up.png"));
        textures.put("Up", new TextureRegionDrawable(new TextureRegion(uop)));
        Texture downs = new Texture(Gdx.files.internal("Buttons/down.png"));
        textures.put("Down", new TextureRegionDrawable(new TextureRegion(downs)));
        Texture levt = new Texture(Gdx.files.internal("Buttons/left.png"));
        textures.put("Left", new TextureRegionDrawable(new TextureRegion(levt)));
        Texture rightt = new Texture(Gdx.files.internal("Buttons/right.png"));
        textures.put("Right", new TextureRegionDrawable(new TextureRegion(rightt)));
        Texture turnLeft = new Texture(Gdx.files.internal("Buttons/turnLeft.png"));
        textures.put("TurnLeft", new TextureRegionDrawable(new TextureRegion(turnLeft)));
        Texture turnRight = new Texture(Gdx.files.internal("Buttons/turnRight.png"));
        textures.put("TurnRight", new TextureRegionDrawable(new TextureRegion(turnRight)));

        //TextButton up = new TextButton("Go Back", vars.skin);
        Image up = new Image(textures.get("Down"));
        buttons.add(up);
        up.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.GoAhead);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        up.setHeight(100);

        //TextButton down = new TextButton("Go Ahead", vars.skin);
        Image down = new Image(textures.get("Up"));
        buttons.add(down);
        down.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.GoBack);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        down.setHeight(100);

        //TextButton left = new TextButton("Turn Left", vars.skin);
        Image left = new Image(textures.get("TurnLeft"));
        buttons.add(left);
        left.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.TurnLeft);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        left.setHeight(100);

        //TextButton right = new TextButton("Turn Right", vars.skin);
        Image right = new Image(textures.get("TurnRight"));
        buttons.add(right);
        right.addListener(new InputListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                workSpace.addCommand(GlobalVar.TurnRight);
                workSpace.getWindow().updateWindow();
                return true;
            }
        });
        right.setHeight(100);

        buttonWin = new Window("Functions", vars.skin);
        buttonWin.setMovable(true);
        buttonWin.setPosition(0, 0);
        buttonWin.setHeight(450);
        buttonWin.setWidth(450);
        buttonWin.setResizable(true);
        UI.addActor(buttonWin);


        Cell<Label> empty1 = buttonWin.add(" ");
        empty1.maxSize(150, 150);
        empty1.minSize(125, 125);
        Cell<Image> uppCell = buttonWin.add(down);
        uppCell.maxSize(150, 150);
        uppCell.minSize(125, 125);
        Cell<Label> empty2 = buttonWin.add(" ");
        empty2.maxSize(150, 150);
        empty2.minSize(125, 125);
        buttonWin.row();
        Cell<Image> leftCell = buttonWin.add(left);
        leftCell.maxSize(150, 150);
        leftCell.minSize(125, 125);
        Cell<Label> empty3 = buttonWin.add(" ");
        empty3.maxSize(150, 150);
        empty3.minSize(125, 125);
        Cell<Image> rightCell = buttonWin.add(right);
        rightCell.maxSize(150, 150);
        rightCell.minSize(125, 125);
        buttonWin.row();
        Cell<Label> empty4 = buttonWin.add(" ");
        empty4.maxSize(150, 150);
        empty4.minSize(125, 125);
        Cell<Image> downCell = buttonWin.add(up);
        downCell.maxSize(150, 150);
        downCell.minSize(125, 125);
        Cell<Label> empty5 = buttonWin.add(" ");
        empty5.maxSize(150, 150);
        empty5.minSize(125, 125);
        buttonWin.row();


        //TextButton play = new TextButton("play", vars.skin);
        Image play = new Image();
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

    public void reOrganization(Vector2 dir) {
        buttonWin.clearChildren();
        if (dir.x == 0 && dir.y == -1) {
            Cell<Label> empty1 = buttonWin.add(" ");
            empty1.maxSize(150, 150);
            empty1.minSize(125, 125);
            Cell<Image> uppCell = buttonWin.add(buttons.get(0));
            uppCell.maxSize(150, 150);
            uppCell.minSize(125, 125);
            Cell<Label> empty2 = buttonWin.add(" ");
            empty2.maxSize(150, 150);
            empty2.minSize(125, 125);
            buttonWin.row();
            Cell<Image> leftCell = buttonWin.add(buttons.get(2));
            leftCell.maxSize(150, 150);
            leftCell.minSize(125, 125);
            Cell<Label> empty3 = buttonWin.add(" ");
            empty3.maxSize(150, 150);
            empty3.minSize(125, 125);
            Cell<Image> rightCell = buttonWin.add(buttons.get(3));
            rightCell.maxSize(150, 150);
            rightCell.minSize(125, 125);
            buttonWin.row();
            Cell<Label> empty4 = buttonWin.add(" ");
            empty4.maxSize(150, 150);
            empty4.minSize(125, 125);
            Cell<Image> downCell = buttonWin.add(buttons.get(1));
            downCell.maxSize(150, 150);
            downCell.minSize(125, 125);
            Cell<Label> empty5 = buttonWin.add(" ");
            empty5.maxSize(150, 150);
            empty5.minSize(125, 125);
            buttonWin.row();

        } else if (dir.x == 0 && dir.y == 1) {
            Cell<Label> empty1 = buttonWin.add(" ");
            empty1.maxSize(150, 150);
            empty1.minSize(125, 125);
            buttons.get(1).setDrawable(textures.get("Up"));
            Cell<Image> uppCell = buttonWin.add(buttons.get(1));
            uppCell.maxSize(150, 150);
            uppCell.minSize(125, 125);
            Cell<Label> empty2 = buttonWin.add(" ");
            empty2.maxSize(150, 150);
            empty2.minSize(125, 125);
            buttonWin.row();
            Cell<Image> leftCell = buttonWin.add(buttons.get(2));
            leftCell.maxSize(150, 150);
            leftCell.minSize(125, 125);
            Cell<Label> empty3 = buttonWin.add(" ");
            empty3.maxSize(150, 150);
            empty3.minSize(125, 125);
            Cell<Image> rightCell = buttonWin.add(buttons.get(3));
            rightCell.maxSize(150, 150);
            rightCell.minSize(125, 125);
            buttonWin.row();
            Cell<Label> empty4 = buttonWin.add(" ");
            empty4.maxSize(150, 150);
            empty4.minSize(125, 125);
            buttons.get(0).setDrawable(textures.get("Down"));
            Cell<Image> downCell = buttonWin.add(buttons.get(0));
            downCell.maxSize(150, 150);
            downCell.minSize(125, 125);
            Cell<Label> empty5 = buttonWin.add(" ");
            empty5.maxSize(150, 150);
            empty5.minSize(125, 125);
            buttonWin.row();

        } else if (dir.x == 1 && dir.y == 0) {
            Cell<Label> empty1 = buttonWin.add(" ");
            empty1.maxSize(150, 150);
            empty1.minSize(125, 125);
            buttons.get(2).setDrawable(textures.get("TurnLeft"));
            buttons.get(2).setRotation(-90);
            Cell<Image> uppCell = buttonWin.add(buttons.get(2));
            uppCell.maxSize(150, 150);
            uppCell.minSize(125, 125);
            Cell<Label> empty2 = buttonWin.add(" ");
            empty2.maxSize(150, 150);
            empty2.minSize(125, 125);
            buttonWin.row();
            buttons.get(1).setDrawable(textures.get("Left"));
            Cell<Image> leftCell = buttonWin.add(buttons.get(1));
            leftCell.maxSize(150, 150);
            leftCell.minSize(125, 125);
            Cell<Label> empty3 = buttonWin.add(" ");
            empty3.maxSize(150, 150);
            empty3.minSize(125, 125);
            buttons.get(0).setDrawable(textures.get("Right"));
            Cell<Image> rightCell = buttonWin.add(buttons.get(0));
            rightCell.maxSize(150, 150);
            rightCell.minSize(125, 125);
            buttonWin.row();
            Cell<Label> empty4 = buttonWin.add(" ");
            empty4.maxSize(150, 150);
            empty4.minSize(125, 125);
            buttons.get(3).setDrawable(textures.get("TurnRight"));
            buttons.get(3).setRotation(-90);
            Cell<Image> downCell = buttonWin.add(buttons.get(3));
            downCell.maxSize(150, 150);
            downCell.minSize(125, 125);
            Cell<Label> empty5 = buttonWin.add(" ");
            empty5.maxSize(150, 150);
            empty5.minSize(125, 125);
            buttonWin.row();

        } else if (dir.x == -1 && dir.y == 0) {
            Cell<Label> empty1 = buttonWin.add(" ");
            empty1.maxSize(150, 150);
            empty1.minSize(125, 125);
            buttons.get(2).setDrawable(textures.get("TurnLeft"));
            buttons.get(2).setRotation(-90);
            Cell<Image> uppCell = buttonWin.add(buttons.get(2));
            uppCell.maxSize(150, 150);
            uppCell.minSize(125, 125);
            Cell<Label> empty2 = buttonWin.add(" ");
            empty2.maxSize(150, 150);
            empty2.minSize(125, 125);
            buttonWin.row();
            buttons.get(0).setDrawable(textures.get("Left"));
            Cell<Image> leftCell = buttonWin.add(buttons.get(0));
            leftCell.maxSize(150, 150);
            leftCell.minSize(125, 125);
            Cell<Label> empty3 = buttonWin.add(" ");
            empty3.maxSize(150, 150);
            empty3.minSize(125, 125);
            buttons.get(1).setDrawable(textures.get("Right"));
            Cell<Image> rightCell = buttonWin.add(buttons.get(1));
            rightCell.maxSize(150, 150);
            rightCell.minSize(125, 125);
            buttonWin.row();
            Cell<Label> empty4 = buttonWin.add(" ");
            empty4.maxSize(150, 150);
            empty4.minSize(125, 125);
            buttons.get(3).setDrawable(textures.get("TurnRight"));
            buttons.get(3).setRotation(-90);
            Cell<Image> downCell = buttonWin.add(buttons.get(3));
            downCell.maxSize(150, 150);
            downCell.minSize(125, 125);
            Cell<Label> empty5 = buttonWin.add(" ");
            empty5.maxSize(150, 150);
            empty5.minSize(125, 125);
            buttonWin.row();
        }
    }
}
