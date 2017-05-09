package com.doubleg.bolt;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.fsm.DefaultStateMachine;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Queue;
import com.doubleg.bolt.States.RobotState;

/**
 * Created by Dimaska on 07.05.2017.
 */

public class Robot {
    Queue<String> commands;
    private Vector2 pos;
    private Vector2 dir;
    private int speed=25;
    private float tempDeltaTime;
     TextureRegion currentTexture;
    private DefaultStateMachine stateMachine;
    WorkSpace work;
    Bunch bunch;

    public Robot(WorkSpace work){
        commands=new Queue<String>();
        currentTexture=new TextureRegion(new Texture("robotState.png"));
        stateMachine=new DefaultStateMachine(this, RobotState.Stand);
        pos=new Vector2(0,0);
        dir=new Vector2(0,-1);
        this.work=work;
        work.setPlayer(this);
    }


    public void update(float deltaTime){
        tempDeltaTime=deltaTime;
        stateMachine.update();
    }

    public void setStartPosition(float x,float y){
        pos.x=x;
        pos.y=y;
    }

    public void draw(SpriteBatch spriteBatch){
        spriteBatch.draw(currentTexture,pos.x,pos.y,GlobalVar.TileSize,GlobalVar.TileSize);
    }

    public void getCommand(String command){
        commands.addLast(command);
    }

    public void setBunch(Bunch bunch){
        this.bunch=bunch;
    }
}
