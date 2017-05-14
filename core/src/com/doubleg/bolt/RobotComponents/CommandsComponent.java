package com.doubleg.bolt.RobotComponents;

import com.doubleg.bolt.GlobalVar;
import com.doubleg.bolt.Robot;
import com.doubleg.bolt.States.RobotState;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class CommandsComponent {
    Robot robot;
    String command;
    String answer;

    public CommandsComponent(Robot robot) {
        this.robot = robot;
        command = "";
        answer = "";
    }

    public void setCommand(String command) {
        this.command = command;
        if (command.equals("GoAhead")) {
            robot.getLinks().getStatesComponent().changeState(RobotState.GoAhead);
        } else if (command.equals(GlobalVar.GoBack)) {
            robot.getLinks().getStatesComponent().changeState(RobotState.GoBack);
        } else if (command.equals(GlobalVar.TurnLeft)) {
            robot.getLinks().getStatesComponent().changeState(RobotState.TurnLeft);
        } else if (command.equals(GlobalVar.TurnRight)) {
            robot.getLinks().getStatesComponent().changeState(RobotState.TurnRight);
        } else if (command.equals(GlobalVar.Stop)) {
            robot.getLinks().getStatesComponent().changeState(RobotState.Stand);
        }
    }

    public void update() {
        if (answer.equals("Error")) {
            robot.getLinks().getStatesComponent().changeState(RobotState.Stand);
        } else if (answer.equals("Good")) {
            robot.getBunch().sendAswer("Good");
        }
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
