package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;

public class AutoSequenceFar extends CommandGroup {

    public AutoSequenceFar(){
        addSequential(new ResetEncoderCounts());
        addSequential(new FindTarget());
        addSequential(new Shoot(SmartDashboard.getNumber("shooterCloseSpeed", SmartDashboard.getNumber("shooterCloseSpeed", 39000))));
        addSequential(new AngleOfAttack(70));
        addSequential(new MoveToPoint("", 1.5));
        addSequential(new TurnToDegrees("", -70));

//        addSequential(new RunIntake());
//        addSequential(new MoveToPoint("",1.8288));
//        addSequential(new Delay(500));
//        addSequential(new StopIntake());
//        addSequential(new MoveToPoint("", (-1.8288)));
//        addSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));
//        addSequential(new StraightenOut());
    }

}
