//package frc.robot.commands.auto;
//
//import com.ctre.phoenix.motorcontrol.ControlMode;
//import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.Robot;
//
//public class StopShooting extends Command {
//
//    @Override
//    protected void initialize() {
//        Robot.shooter.indexer.set(ControlMode.PercentOutput, 0);
//        Robot.shooter.shooterParent.set(ControlMode.PercentOutput, 0);
//        Robot.shooter.shooterChild.set(ControlMode.PercentOutput, 0);
//    }
//
//    @Override
//    protected boolean isFinished() {
//        return true;
//    }
//}
