package com.doubleg.bolt;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.doubleg.bolt.RobotComponents.BodyComponent;
import com.doubleg.bolt.RobotComponents.CommandsComponent;
import com.doubleg.bolt.RobotComponents.GraphicComponent;
import com.doubleg.bolt.RobotComponents.Mediator;
import com.doubleg.bolt.RobotComponents.SensoryComponent;
import com.doubleg.bolt.RobotComponents.StatesComponent;
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
    BodyComponent body;
    Mediator links;
    SensoryComponent eyes;
    CommandsComponent cpu;

    Bunch bunch;

    public Robot(World world) {
        states=new StatesComponent(this);
        graphic=new GraphicComponent();
        pos=new Vector2(0,0);
        dir=new Vector2(0,-1);
        graphic.setCurrentTexture(states.getState(),dir);
        body = null;
        cpu = new CommandsComponent(this);
        eyes = new SensoryComponent(this, world);
        links = new Mediator(body, cpu, graphic, states, eyes, this);

    }



    public void update(float deltaTime){
        tempDeltaTime=deltaTime;
        cpu.update();
        states.update();
    }

    public void setStartPosition(float x,float y){
        pos.x=x;
        pos.y=y;
    }

    public void draw(SpriteBatch spriteBatch, float worldX, float worldY) {
        graphic.draw(spriteBatch, pos.x + worldX, pos.y + worldY);
    }

    public void setBunch(Bunch bunch){
        this.bunch=bunch;
    }

    public Vector2 getPos() {
        return pos;
    }

    public Vector2 getDir() {
        return dir;
    }

    public Bunch getBunch() {
        return bunch;
    }

    public void goAhead() {
        pos.x += dir.x * GlobalVar.TileSize;
        pos.y += dir.y * GlobalVar.TileSize;
    }

    public void goBack() {
        pos.x -= dir.x * GlobalVar.TileSize;
        pos.y -= dir.y * GlobalVar.TileSize;
    }

    public Mediator getLinks() {
        return links;
    }
}
