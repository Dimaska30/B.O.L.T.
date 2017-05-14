package com.doubleg.bolt.RobotComponents;

import com.doubleg.bolt.GlobalVar;
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
        int[][] map = world.getMaps();
        int x = (int) (robot.getPos().x / GlobalVar.TileSize);
        int y = (int) (map.length - 1 - robot.getPos().y / GlobalVar.TileSize);
        return (map[y + (int) robot.getDir().y][x + (int) robot.getDir().x] == 0)
                || (map[y + (int) robot.getDir().y][x + (int) robot.getDir().x] == 2)
                || (map[y + (int) robot.getDir().y][x + (int) robot.getDir().x] == 3);
    }

    public boolean BackFreely() {
        int[][] map = world.getMaps();
        int x = (int) (robot.getPos().x / GlobalVar.TileSize);
        int y = (int) (map.length - 1 - robot.getPos().y / GlobalVar.TileSize);
        return (map[y - (int) robot.getDir().y][x - (int) robot.getDir().x] == 0)
                || (map[y - (int) robot.getDir().y][x - (int) robot.getDir().x] == 2)
                || (map[y - (int) robot.getDir().y][x - (int) robot.getDir().x] == 3);
    }
}
