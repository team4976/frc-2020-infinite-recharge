package frc.robot;

import frc.robot.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {

  private Scheduler scheduler;
  public static Drive drive;

  public void robotInit() {
    scheduler = Scheduler.getInstance();

    drive = new Drive();
  }

  @Override
  public void robotPeriodic() {
    scheduler.run();
  }

  @Override
  public void autonomousInit() {
    Drive.leftFront.startMotionProfile(MotionPoints.pointStream, 0, ControlMode.MotionMagic);
    Drive.rightFront.startMotionProfile(MotionPoints.pointStream, 0, ControlMode.MotionMagic);
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
