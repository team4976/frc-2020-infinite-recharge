package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.*;

public class Shoot extends CommandGroup {

    public Shoot(){
        addSequential(new RunShooter());
        addSequential(new Delay(100));
        addParallel(new Aim(), 4);
        addSequential(new Delay(1000));
        addSequential(new RunIndexerAuto(), 6);
        addSequential(new StopShooter());
        addSequential(new StopIndexer());
    }
}
