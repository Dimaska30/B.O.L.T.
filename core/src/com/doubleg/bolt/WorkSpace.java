package com.doubleg.bolt;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Queue;
import com.doubleg.bolt.WorkSpaceComponent.GraphicComponent;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class WorkSpace {
    private Array<String> code;
    int pointer;
    int countError;
    private Robot player;
    public GraphicComponent UI;
    Bunch bunch;

    public WorkSpace(GlobalVar vars){
        pointer=0;
        code=new Array<String>();
        code.add("Up");
        code.add("Jump");
        this.bunch=bunch;
    }

    public void setUI(GraphicComponent UI) {
        this.UI = UI;
    }

    public void setBunch(Bunch bunch){
        this.bunch=bunch;
    }

    public void setPlayer(Robot player){
        this.player=player;
    }

    public void addCommand(String command){
        code.add(command);
    }

    public void sendCommand(String command){
        bunch.sendCommand(command);
    }

    public void nextCommand(){
        pointer++;
        String command=code.get(pointer);
        sendCommand(command);
    }

    public Array<String> getCode() {
        return code;
    }
}
