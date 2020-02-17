package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drive extends Subsystem {
    public static Solenoid shifter = new Solenoid(10, 7);

    public static TalonSRX leftParent = new TalonSRX(41);
    public static TalonSRX rightParent = new TalonSRX(42);
    public static VictorSPX rightChild = new VictorSPX(44);
    public static VictorSPX leftChild = new VictorSPX(43);

    public void shiftGearHigh(){
        shifter.set(true);
    }

    public void shiftGearLow(){
        shifter.set(false);
    }

    public void teleopDrive(){
//        if (Robot.oi.driver.getRawButton(4)){
//            Robot.shooter.target();
//        }else{
            double throttle = deadBanded(Robot.oi.driver.getRawAxis(2) - Robot.oi.driver.getRawAxis(3));
            double steer = getCubicOf(Robot.oi.driver.getRawAxis(0)) / 2;

            double leftOut = -throttle + steer;
            double rightOut = -throttle - steer;

            driveMotors(leftOut, rightOut);
        //}
    }

    public void driveMotors(double left, double right){
        leftParent.set(ControlMode.PercentOutput, left);
        rightParent.set(ControlMode.PercentOutput, right);
    }

    public double getCubicOf(double x){
        x = x*Math.abs(x);
        return x;
    }

    public double deadBanded(double x){
        if (x < 0.1 && x > -0.1){
            x = 0;
        }
        return x;
    }

    protected void initDefaultCommand(){
        setDefaultCommand(new JoystickDrive());
    }
}