package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceCentre extends CommandGroup {

    public AutoSequenceCentre(){

        //The autonomous sequence beginning in the CENTRE of the field.

        addSequential(new ResetEncoderCounts());
        addSequential(new Shoot(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 0))));
        addSequential(new AngleOfAttack(45));
        addSequential(new MoveToPoint("", 3));
        addSequential(new TurnToDegrees("", -45));
        addSequential(new RunIntake());
        addSequential(new MoveToPoint("",3));
        addSequential(new Delay(500));
        addSequential(new StopIntake());
        addSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));
    }

}
