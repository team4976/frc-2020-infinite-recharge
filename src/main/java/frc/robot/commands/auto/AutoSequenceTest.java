package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoSequenceTest extends CommandGroup {

    int i;

    public AutoSequenceTest(){

        addSequential(new TurnToDegrees("", 90));
        addSequential(new MoveToPoint("Starting First Move", 4));
        addSequential(new TurnToDegrees("Starting First Turn",-90));
        addSequential(new Shoot());

    }


    @Override
    public synchronized void start() {
        System.out.println("Starting");
        super.start();
    }
}
