package frc.robot;

import frc.robot.commands.auto.AutoSequenceRight;
import frc.robot.commands.auto.AutoSequenceTest;
import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.auto.AutoSequenceLeft;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static Shooter shooter;
  private Scheduler scheduler;
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
    intake = new Intake();
    oi = new OI();

    Drive.leftParent.setSensorPhase(false);
    Drive.leftChild.setSensorPhase(false);
    Drive.rightParent.setSensorPhase(false);
    Drive.rightChild.setSensorPhase(false);

    Drive.leftParent.setInverted(false);
    Drive.leftChild.setInverted(false);
    Drive.rightParent.setInverted(true);
    Drive.rightChild.setInverted(true);

    shooter.indexer.setInverted(true);
    shooter.shooterChild.setInverted(true);
    shooter.shooterParent.setInverted(true);

    Drive.leftChild.follow(Drive.leftParent);
    Drive.rightChild.follow(Drive.rightParent);

    shooter.shooterParent.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    shooter.shooterParent.configContinuousCurrentLimit(42);
    shooter.shooterParent.configPeakCurrentLimit(60);
    shooter.shooterParent.configPeakCurrentDuration(300);
    shooter.shooterChild.configContinuousCurrentLimit(42);
    shooter.shooterChild.configPeakCurrentLimit(60);
    shooter.shooterChild.configPeakCurrentDuration(300);
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();
    if (oi.driver.getRawButton(5)) {
      //shooter.target();
//      double shooterOutput =  shooter.shooter.calculate(((-shooter.ShooterParent.getSelectedSensorPosition()/2048)*600)/1.75,  11000);
//      shooter.ShooterParent.set(ControlMode.PercentOutput, shooterOutput);
//      shooter.ShooterChild.set(ControlMode.PercentOutput, shooterOutput);
      //20 feet 58%
      //12 feet 60%
    }else{
      //shooter.shooterParent.set(ControlMode.PercentOutput, 0);
      //shooter.shooterChild.set(ControlMode.PercentOutput, 0);
    }


    System.out.println(shooter.shooterParent.getSelectedSensorVelocity());
    //SmartDashboard.putNumber("CurrentDraw", shooter.ShooterChild.getStatorCurrent());
    System.out.println(((-shooter.shooterParent.getSelectedSensorVelocity()/4096.0)*600)*1.75);
    SmartDashboard.putNumber("UPS", shooter.shooterParent.getSelectedSensorVelocity());
    SmartDashboard.putNumber("RPM", ((-shooter.shooterParent.getSelectedSensorVelocity()/4096.0)*600)*1.75);
    //System.out.println(Drive.leftParent.getSelectedSensorPosition());
    System.out.println(Drive.leftParent.getSelectedSensorPosition());
  }

  @Override
  public void autonomousInit() {

    new AutoSequenceTest().start();

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
