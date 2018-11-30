package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class ClawInCommand extends Command {

    public ClawInCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cubeGrabber);
    }

    protected void initialize() {
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
