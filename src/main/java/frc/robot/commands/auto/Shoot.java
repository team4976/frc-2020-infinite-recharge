package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.*;

public class Shoot extends CommandGroup {

    public Shoot(){
        addParallel(new Aim(), 4);
        addSequential(new RunShooter());
        addSequential(new Delay(1000));
        addSequential(new RunIndexerAuto(), 6);
        addSequential(new StopShooter());
        addSequential(new StopIndexer());
    }
}
