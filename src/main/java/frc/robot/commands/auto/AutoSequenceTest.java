package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.Aim;

public class AutoSequenceTest extends CommandGroup {

    int i;

    public AutoSequenceTest(){

        addSequential(new Shoot());

    }


    @Override
    public synchronized void start() {
        System.out.println("Starting");
        super.start();
    }
}
