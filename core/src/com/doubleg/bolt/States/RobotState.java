package com.doubleg.bolt.States;

import com.badlogic.gdx.ai.fsm.State;
import com.badlogic.gdx.ai.msg.Telegram;
import com.doubleg.bolt.Robot;

/**
 * Created by Dimaska on 08.05.2017.
 */

public enum RobotState implements State<Robot> {
    Stand(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    CurlUp(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    RollForward(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    RollBackwards(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    GoAhead(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    GoBack(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    TurnLeft(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    },
    TurnRight(){
        @Override
        public void enter(Robot entity) {

        }

        @Override
        public void update(Robot entity) {

        }

        @Override
        public void exit(Robot entity) {

        }
    }
    ;

    @Override
    public void enter(Robot entity) {

    }

    @Override
    public void update(Robot entity) {

    }

    @Override
    public void exit(Robot entity) {

    }

    @Override
    public boolean onMessage(Robot entity, Telegram telegram) {
        return false;
    }
}
