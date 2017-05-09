package com.doubleg.bolt.WorkSpaceComponent;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
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

    public GraphicComponent(WorkSpace workSpace,GlobalVar vars){
        this.workSpace=workSpace;
        this.skin=vars.skin;
        UI=new Stage();
        UI.getBatch().setProjectionMatrix(vars.camera.combined);
        area=new Window("Code",skin);
        area.setMovable(true);
        area.setPosition(0,0);
        area.setHeight(Gdx.graphics.getHeight());
        area.setWidth(Gdx.graphics.getWidth()/8*1.5f);
        UI.addActor(area);

        for(int index=0;index<workSpace.getCode().size;index++){
            Label temp=new Label(workSpace.getCode().get(index),skin);
            temp.setPosition(0,index*temp.getHeight());
            temp.setColor(Color.BLACK);
            area.add(temp);
        }
    }

    public Stage getUI() {
        return UI;
    }
}
