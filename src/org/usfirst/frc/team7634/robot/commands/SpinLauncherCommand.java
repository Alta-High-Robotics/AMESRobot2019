package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;

public class SpinLauncherCommand extends Command {

    public SpinLauncherCommand() {
        requires(Robot.ballLauncher);
    }

    protected void initialize() {
        Robot.ballLauncher.spinning = !Robot.ballLauncher.spinning; //on or off
    }

    @Override
    protected void execute() {
        if (!Robot.ballLauncher.spinning) {
            Robot.ballLauncher.spin(1.0); //create acceleration logic later.
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.ballLauncher.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
