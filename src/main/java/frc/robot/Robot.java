package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  public static Shooter shooter;
  public static TalonSRX rightFront  = new TalonSRX(48);
public static TalonSRX leftFront = new TalonSRX(43);
public static TalonSRX rightBack = new TalonSRX(45);
public static TalonSRX leftBack = new TalonSRX(46);
public static Joystick driver = new Joystick(0);

  public void robotInit() {
    shooter = new Shooter();
    shooter.ShooterParent.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    shooter.ShooterParent.configContinuousCurrentLimit(42);
    shooter.ShooterParent.configPeakCurrentLimit(60);
    shooter.ShooterParent.configPeakCurrentDuration(300);
    shooter.ShooterChild.configContinuousCurrentLimit(42);
    shooter.ShooterChild.configPeakCurrentLimit(60);
    shooter.ShooterChild.configPeakCurrentDuration(300);
  }

  @Override
  public void robotPeriodic() {
    if (driver.getRawButton(5)) {
      shooter.target();
//      double shooterOutput =  shooter.shooter.calculate(((-shooter.ShooterParent.getSelectedSensorPosition()/2048)*600)/1.75,  11000);
//      shooter.ShooterParent.set(ControlMode.PercentOutput, shooterOutput);
//      shooter.ShooterChild.set(ControlMode.PercentOutput, shooterOutput);
      shooter.ShooterParent.set(ControlMode.PercentOutput, .7);
      shooter.ShooterChild.set(ControlMode.PercentOutput, .7);
    }else{
      shooter.ShooterParent.set(ControlMode.PercentOutput, 0);
      shooter.ShooterChild.set(ControlMode.PercentOutput, 0);
      double steer = driver.getRawAxis(0);
      double forward = driver.getRawAxis(2)-driver.getRawAxis(3);
      leftFront.set(ControlMode.PercentOutput,steer+forward);
      leftBack.set(ControlMode.PercentOutput,steer+forward);
      rightBack.set(ControlMode.PercentOutput, steer-forward);
      rightFront.set(ControlMode.PercentOutput,steer-forward);
    }

    if(driver.getRawButton(1)){
      shooter.Indexer.set(ControlMode.PercentOutput, 1);
    } else {
      shooter.Indexer.set(ControlMode.PercentOutput, 0);
    }

    SmartDashboard.putNumber("CurrentDraw", shooter.ShooterChild.getStatorCurrent());
    SmartDashboard.putNumber("RPM", ((-shooter.ShooterParent.getSelectedSensorVelocity()/2048)*600)*1.75);
  }

  @Override
  public void autonomousInit() {
      }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testPeriodic() {
  }
}
