package com.doubleg.bolt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.doubleg.bolt.WorkSpaceComponent.GraphicComponent;
import com.doubleg.bolt.WorkSpaceComponent.InputComponent;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class WorkSpace {
    private Array<String> code;
    private int pointer;
    private int countError;
    private GraphicComponent window;
    private InputComponent input;
    private Bunch bunch;

    public WorkSpace(GlobalVar var) {
        pointer = -1;
        countError = 0;
        code=new Array<String>();
        input = new InputComponent(this, var);
    }

    public void setUI(GraphicComponent window) {
        this.window = window;
    }

    public GraphicComponent getWindow() {
        return window;
    }

    public InputComponent getInput() {
        return input;
    }

    public void setBunch(Bunch bunch){
        this.bunch=bunch;
    }

    public void addCommand(String command){
        code.add(command);
    }

    public void sendCommand(String command){
        bunch.sendCommand(command);
    }

    public int getPointer() {
        return pointer;
    }

    public int getCountError() {
        return countError;
    }

    public void getAnswer(String answer) {
        if (answer.equals("Good")) {
            nextCommand();
        } else if (answer.equals("Error")) {
            countError++;
            Gdx.app.log("Error", "Error");
        } else {
            repeatCommand();
        }
    }

    public void nextCommand(){
        if (pointer + 1 < code.size) {
            pointer++;
            window.updateWindow();
            String command = code.get(pointer);
            sendCommand(command);
            input.reOrganization(bunch.getDir());
        } else {
            sendCommand(GlobalVar.Stop);
        }
    }

    public void repeatCommand() {
        String command=code.get(pointer);
        sendCommand(command);
    }

    public Array<String> getCode() {
        return code;
    }

    public void start() {
        nextCommand();
    }
}
