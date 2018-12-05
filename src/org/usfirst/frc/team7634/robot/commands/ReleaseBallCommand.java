package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;

public class ReleaseBallCommand extends Command {

    public ReleaseBallCommand() {
        requires(Robot.ballReleaser);
    }

    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.ballReleaser.open();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.ballReleaser.close();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
