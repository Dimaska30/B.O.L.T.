package com.doubleg.bolt.RobotComponents;

import com.doubleg.bolt.Robot;

/**
 * Created by Администратор on 12.05.2017.
 */

public class Mediator {
    BodyComponent bodyComponent;
    CommandsComponent commandsComponent;
    GraphicComponent graphicComponent;
    StatesComponent statesComponent;
    SensoryComponent sensoryComponent;
    Robot robot;

    public Mediator(
            BodyComponent bodyComponent,
            CommandsComponent commandsComponent,
            GraphicComponent graphicComponent,
            StatesComponent statesComponent,
            SensoryComponent sensoryComponent,
            Robot robot) {
        this.bodyComponent = bodyComponent;
        this.commandsComponent = commandsComponent;
        this.graphicComponent = graphicComponent;
        this.statesComponent = statesComponent;
        this.robot = robot;
        this.sensoryComponent = sensoryComponent;
    }

    public SensoryComponent getSensoryComponent() {
        return sensoryComponent;
    }

    public BodyComponent getBodyComponent() {
        return bodyComponent;
    }

    public CommandsComponent getCommandsComponent() {
        return commandsComponent;
    }

    public GraphicComponent getGraphicComponent() {
        return graphicComponent;
    }

    public StatesComponent getStatesComponent() {
        return statesComponent;
    }
}
