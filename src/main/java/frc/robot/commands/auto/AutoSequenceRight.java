package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceRight extends CommandGroup {

    public AutoSequenceRight(){

        //The autonomous sequence beginning on the right side of the field, from the driver's perspective;
        //In line with the trench run, just right of being centred with the power port.

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0))));
        addSequential(new AngleOfAttack(0));
        addSequential(new ResetEncoderCounts());
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("", 3));
        addSequential(new StopIntake());
        addSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));
    }

}
