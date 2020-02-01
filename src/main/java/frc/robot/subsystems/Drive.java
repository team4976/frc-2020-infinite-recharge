package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Joystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drive extends Subsystem {
    public static Joystick joystick = new Joystick(0);
    public static TalonSRX leftParent = new TalonSRX(43);
    public static VictorSPX rightChild = new VictorSPX(60);
    public static VictorSPX leftChild = new VictorSPX(46);
    public static TalonSRX rightParent = new TalonSRX(48);

    public void autoDrive(){
        
    }

    public void teleopDrive(){
        double throttle = deadBanded(joystick.getRawAxis(2) - joystick.getRawAxis(3));
        double steer = getCubicOf(joystick.getRawAxis(0));

        double leftOut = -throttle + steer;
        double rightOut = -throttle - steer;

        driveMotors(leftOut, rightOut);
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