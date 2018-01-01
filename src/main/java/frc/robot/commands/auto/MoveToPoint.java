package frc.robot.commands.auto;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.drive.ShiftGearHigh;
import frc.robot.commands.drive.ShiftGearLow;
import frc.robot.subsystems.Drive;

public class MoveToPoint extends Command {

    int counts;
    boolean hasMoved;
    String message;

    public MoveToPoint(String message, double distance){
        this.message = message;
        counts = (int)(11583.333333333333333 * distance);
    }
    public void initialize(){
        System.out.println(message);
        hasMoved = false;
        Drive.leftParent.selectProfileSlot(0, 0);
        Drive.rightParent.selectProfileSlot(0, 0);
        Drive.leftParent.configMotionCruiseVelocity(3105);
        Drive.leftParent.configMotionAcceleration(3105);
        Drive.rightParent.configMotionAcceleration(3105);
        Drive.rightParent.configMotionCruiseVelocity(3105);

        double leftStart = Drive.leftParent.getSelectedSensorPosition();
        double rightStart = Drive.rightParent.getSelectedSensorPosition();

        Drive.leftParent.set(ControlMode.MotionMagic, counts + leftStart);
        Drive.rightParent.set(ControlMode.MotionMagic, counts + rightStart);
    }

    @Override
    protected void end() { }

    @Override
    protected boolean isFinished() {
////        if (Drive.leftParent.getSelectedSensorVelocity() > 10){
////            hasMoved = true;
////        }
////        if (Drive.leftParent.getSelectedSensorVelocity() == 0 && hasMoved){
////            hasMoved = false;
////            return true;
////        }else{
////            return false;
////        }
//        boolean finish = Math.abs(Drive.leftParent.getSelectedSensorPosition()) > (Math.abs(counts) - 100);
//
//        System.out.println(finish + " " + counts + " " + Drive.leftParent.getSelectedSensorPosition());
//
//        return finish;
        if (Drive.leftParent.getSelectedSensorVelocity() > 10){
            hasMoved = true;
        }
        if (Drive.leftParent.getSelectedSensorVelocity() == 0 && hasMoved){
            hasMoved = false;
            return true;
        }else{
            return false;
        }
    }
}
