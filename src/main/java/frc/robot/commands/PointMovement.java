package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PointMovement extends CommandGroup {

    public PointMovement(){
        addSequential(new MoveToPoint(3));
        addSequential(new TurnToDegrees(90));
        addSequential(new MoveToPoint(3));
        addSequential(new TurnToDegrees(90));
        addSequential(new MoveToPoint(3));
        addSequential(new TurnToDegrees(90));
        addSequential(new MoveToPoint(3));
        addSequential(new TurnToDegrees(90));
    }

}
