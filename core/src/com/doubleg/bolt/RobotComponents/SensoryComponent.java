package com.doubleg.bolt.RobotComponents;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.doubleg.bolt.Robot;
import com.doubleg.bolt.World;

/**
 * Created by Администратор on 12.05.2017.
 */

public class SensoryComponent {
    private Robot robot;
    private World world;

    public SensoryComponent(Robot robot, World world) {
        this.robot = robot;
        this.world = world;
    }

    public boolean AheadFreely() {
        Array<Rectangle> walls = world.getWall();
        Rectangle playerBody = new Rectangle(robot.getPos().x + robot.getDir().y * 100, robot.getPos().y + robot.getDir().y * 100, 100, 100);
        for (Rectangle rect : walls) {
            if (rect.overlaps(playerBody)) {
                return false;
            }
        }
        return true;
    }

    public boolean BackFreely() {
        Array<Rectangle> walls = world.getWall();
        Rectangle playerBody = new Rectangle(robot.getPos().x - robot.getDir().y * 100, robot.getPos().y - robot.getDir().y * 100, 100, 100);
        for (Rectangle rect : walls) {
            if (rect.overlaps(playerBody)) {
                return false;
            }
        }
        return true;
    }

    public boolean FindFlag() {

        return true;
    }
}
