package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.intake.RunIntake;
import frc.robot.commands.intake.StopIntake;
import frc.robot.commands.shooter.Aim;

public class AutoSequenceTest extends CommandGroup {

    int i;

    public AutoSequenceTest(){

        addSequential(new RunIntake());
        addSequential(new MoveToPoint("",3));
        addSequential(new StopIntake());
        addSequential(new Delay(1000));
        addSequential(new MoveToPoint("",-3));
        addSequential(new Delay(1000));
        addSequential(new Shoot(SmartDashboard.getNumber("shooterFarSpeed", SmartDashboard.getNumber("shooterFarSpeed", 0))));

    }


    @Override
    public synchronized void start() {
        System.out.println("Starting");
        super.start();
    }
}
