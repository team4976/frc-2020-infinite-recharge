package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.shooter.Aim;
import frc.robot.commands.shooter.RunShooter;
import frc.robot.commands.shooter.StopIndexer;
import frc.robot.commands.shooter.StopShooter;

public class ShootQuickly extends CommandGroup {

    public ShootQuickly(double rpm){
        addSequential(new RunShooter(rpm));
        addParallel(new Aim(), 3.25);
        addSequential(new Delay(750));
        addSequential(new RunIndexerAuto(), 2.5);
        addSequential(new StopShooterKeepIntaking());
        addSequential(new StopIndexer());
    }

    @Override
    protected void end() {
        System.out.println("Finished Shoot Sequence!");
    }
}
