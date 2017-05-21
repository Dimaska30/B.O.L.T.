package com.doubleg.bolt;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class Bunch {
    private Robot robot;
    private WorkSpace workSpace;
    String currentCommand;
    String currentAnswer;

    public Bunch(Robot robot,WorkSpace workSpace){
        this.workSpace=workSpace;
        this.workSpace.setBunch(this);
        this.robot=robot;
        this.robot.setBunch(this);
        currentAnswer = "";
        currentCommand = "";
    }

    public void sendCommand(String command){
        robot.getLinks().getCommandsComponent().setCommand(command);
    }

    public void sendAswer(String answer){
        workSpace.getAnswer(answer);
    }

    public Vector2 getDir() {
        return robot.getDir();
    }
}
