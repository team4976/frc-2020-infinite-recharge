package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.RunShooter;

public class Shoot extends CommandGroup {

    public Shoot(){
        addSequential(new RunShooter());
        addSequential(new AutoAim());
        addSequential(new Index());
        addSequential(new Delay(3000));
        addSequential(new StopShooting());
    }
}
