package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drive extends Subsystem {
    public static Joystick joystick = new Joystick(0);
    public static TalonSRX leftFront = new TalonSRX(43);
    public static TalonSRX rightFront = new TalonSRX(48);
    public TalonSRX leftRear = new TalonSRX(46);
    public TalonSRX rightRear = new TalonSRX(45);

    public void autoDrive(){
        
    }

    public void teleopDrive(){
        double throttle = deadBanded(joystick.getRawAxis(2) - joystick.getRawAxis(3));
        double steer = getCubicOf(joystick.getRawAxis(0));

        double leftOut = regularize(throttle - steer);
        double rightOut = regularize(-throttle - steer);

        driveMotors(leftOut, rightOut);
    }

    public void driveMotors(double left, double right){
        leftFront.set(ControlMode.PercentOutput, left);
        leftRear.set(ControlMode.PercentOutput, left);
        rightFront.set(ControlMode.PercentOutput, right);
        rightRear.set(ControlMode.PercentOutput, right);
    }

    public double regularize(double x){
        double y = deadBanded(x);
        if (y > 1){
            return 1.0;
        } else if (y < -1) {
            return -1.0;
        } else {
            return y;
        }
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
        leftFront.setInverted(true);
        rightFront.setInverted(true);
        leftRear.setInverted(true);
        rightRear.setInverted(true);
        setDefaultCommand(new JoystickDrive());
    }
}