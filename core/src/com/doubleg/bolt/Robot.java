package com.doubleg.bolt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Queue;
import com.doubleg.bolt.RobotComponents.GraphicComponent;
import com.doubleg.bolt.RobotComponents.StatesComponent;
import com.doubleg.bolt.States.RobotState;

/**
 * Created by Dimaska on 07.05.2017.
 */

public class Robot {
    private Vector2 pos;
    private Vector2 dir;
    private int speed=25;
    private float tempDeltaTime;
    StatesComponent states;
    GraphicComponent graphic;

    Bunch bunch;

    public Robot(){
        //currentTexture=new TextureRegion(new Texture("robotState.png"));
        states=new StatesComponent(this);
        graphic=new GraphicComponent();
        pos=new Vector2(0,0);
        dir=new Vector2(0,-1);
        graphic.setCurrentTexture(states.getState(),dir);
    }


    public void update(float deltaTime){
        tempDeltaTime=deltaTime;
        states.update();
    }

    public void setStartPosition(float x,float y){
        pos.x=x;
        pos.y=y;
    }

    public void draw(SpriteBatch spriteBatch){
        graphic.draw(spriteBatch,pos);
    }

    public void setBunch(Bunch bunch){
        this.bunch=bunch;
    }
}
