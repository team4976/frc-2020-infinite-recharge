package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.*;

public class Shoot extends CommandGroup {

    public Shoot(double rpm){
        addSequential(new RunShooter(rpm));
        addSequential(new Delay(100));
        addParallel(new Aim(), 4);
        addSequential(new Delay(750));
        addSequential(new RunIndexerAuto(), 3);
        addSequential(new StopShooter());
        addSequential(new StopIndexer());
    }

    @Override
    protected void end() {
        System.out.println("Finished Shoot Sequence!");
    }
}
