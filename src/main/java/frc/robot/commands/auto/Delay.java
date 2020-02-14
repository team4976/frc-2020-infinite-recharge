package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

    long startTime;
    int milliseconds;

    public Delay(int ms){
        milliseconds = ms;
    }

    @Override
    protected void initialize() {
        startTime = System.currentTimeMillis();

    }

    @Override
    protected boolean isFinished() {
        return (System.currentTimeMillis() - startTime) > milliseconds;
    }
}
