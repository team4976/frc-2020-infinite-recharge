package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceCentre extends CommandGroup {

    public AutoSequenceCentre(){
        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot(39000));
        addSequential(new AutoRunIntake());
        addSequential(new MoveToPoint("", 3.75 * 0.58));
        addSequential(new StopIntake());
        addSequential(new MoveToPoint("", -2.25));
        addSequential(new Shoot(39000));
    }

}
