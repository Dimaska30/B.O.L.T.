package com.doubleg.bolt.WorkSpaceComponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Array;
import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.WorkSpace;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class GraphicComponent {
    private WorkSpace workSpace;
    Stage UI;
    Skin skin;
    Window area;
    Array<Label> codes;
    Label error;

    public GraphicComponent(WorkSpace workSpace,GlobalVar vars){
        this.workSpace=workSpace;
        this.skin=vars.skin;
        UI = new Stage(vars.port, vars.batch);
        codes = new Array<Label>();
        UI.getBatch().setProjectionMatrix(vars.camera.combined);
        area=new Window("Code",skin);
        area.setMovable(true);
        area.setPosition(0,0);
        area.setHeight(Gdx.graphics.getHeight());
        area.setWidth(Gdx.graphics.getWidth()/8*1.5f);
        area.setResizable(true);
        UI.addActor(area);

        error = new Label("Error:", skin);
        error.setColor(Color.RED);
        error.setPosition(0, GlobalVar.ScreenHeight / 2);
        UI.addActor(error);

        for(int index=0;index<workSpace.getCode().size;index++){
            Label temp=new Label(workSpace.getCode().get(index),skin);
            temp.setFontScale(2);
            temp.setPosition(0,index*temp.getHeight());
            temp.setColor(Color.BLACK);
            codes.add(temp);
            area.add(temp);
            area.row();
        }
    }

    public void updateWindow() {
        error.setText("Error:" + workSpace.getCountError());
        area.clearChildren();
        codes.clear();
        for (int index = 0; index < workSpace.getCode().size; index++) {
            Label temp = new Label(workSpace.getCode().get(index), skin);
            temp.setFontScale(2);
            temp.setPosition(0, index * temp.getHeight());
            temp.setColor(Color.BLACK);
            if (index == workSpace.getPointer())
                temp.setColor(Color.BLUE);
            area.add(temp);
            codes.add(temp);
            area.row();
        }
    }



    public Stage getUI() {
        return UI;
    }
}
