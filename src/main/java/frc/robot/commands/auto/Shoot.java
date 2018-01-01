package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.Aim;
import frc.robot.commands.shooter.RunIndexer;
import frc.robot.commands.shooter.RunShooter;
import frc.robot.commands.shooter.StopShooter;

public class Shoot extends CommandGroup {

    public Shoot(){
        addSequential(new RunShooter());
        addSequential(new Aim(), 2);
        addSequential(new RunIndexer());
        addSequential(new Delay(3000));
        addSequential(new StopShooter());
    }

    public void start() {
        System.out.println("Run Shooter");
        super.start();
    }
}
