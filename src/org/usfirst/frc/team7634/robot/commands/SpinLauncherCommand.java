package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class SpinLauncherCommand extends Command {

    public SpinLauncherCommand() {
        requires(Robot.ballLauncher);
    }

    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.ballLauncher.spin(RobotSettings.LAUNCHER_SPEED * RobotSettings.LAUNCHER_DIRECTION);
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
