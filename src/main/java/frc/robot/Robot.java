package frc.robot;

import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.auto.AutoSequenceLeft;
import frc.robot.subsystems.*;
import frc.robot.commands.auto.AutoSequenceLeft;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static Shooter shooter;
  private Scheduler scheduler;
  public static Shooter shooter;
  public static Drive drive;
  public static Intake intake;
  public static OI oi;

  public void robotInit() {


    scheduler = Scheduler.getInstance();

    Drive.leftParent.setSensorPhase(false);
    Drive.leftChild.setSensorPhase(false);
    Drive.rightParent.setSensorPhase(false);
    Drive.rightChild.setSensorPhase(false);

    Drive.leftParent.setInverted(false);
    Drive.leftChild.setInverted(false);
    Drive.rightParent.setInverted(true);
    Drive.rightChild.setInverted(true);


    drive = new Drive();
    shooter = new Shooter();

    shooter.indexer.setInverted(true);
    shooter.shooterParent.setInverted(true);
    shooter.shooterChild.setInverted(true);

    Drive.leftChild.follow(Drive.leftParent);
    Drive.rightChild.follow(Drive.rightParent);
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();
    System.out.println(Drive.leftParent.getSelectedSensorPosition());
  }

  @Override
  public void autonomousInit() {
    new AutoSequenceLeft().start();
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit(){

  }

  @Override
  public void testPeriodic() {
  }

  @Override
  public void disabledInit() {
    Drive.leftParent.set(ControlMode.PercentOutput, 0);
    Drive.rightParent.set(ControlMode.PercentOutput, 0);
    shooter.shooterParent.set(ControlMode.PercentOutput, 0);
    shooter.shooterChild.set(ControlMode.PercentOutput, 0);
    shooter.indexer.set(ControlMode.PercentOutput, 0);
  }
}
