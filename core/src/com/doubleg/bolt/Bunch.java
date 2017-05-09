package com.doubleg.bolt;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class Bunch {
    private Robot robot;
    private WorkSpace workSpace;

    public Bunch(Robot robot,WorkSpace workSpace){
        this.workSpace=workSpace;
        this.workSpace.setBunch(this);
        this.robot=robot;
        this.robot.setBunch(this);
    }

    public void sendCommand(String command){

    }

    public void sendAswer(String answer){
    }
}
