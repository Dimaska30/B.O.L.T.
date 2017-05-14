package com.doubleg.bolt.RobotComponents;

import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.doubleg.bolt.Robot;
import com.doubleg.bolt.States.RobotState;

/**
 * Created by Dimaska on 09.05.2017.
 */

public class StatesComponent {
    private DefaultStateMachine<Robot, RobotState> stateMachine;

    public StatesComponent(Robot robot){
        stateMachine = new DefaultStateMachine<Robot, RobotState>(robot, RobotState.Stand);
    }

    public void update(){
        stateMachine.update();
    }

    public void changeState(RobotState state){
        stateMachine.changeState(state);
    }

    public RobotState getState(){
        return stateMachine.getCurrentState();
    }
}
