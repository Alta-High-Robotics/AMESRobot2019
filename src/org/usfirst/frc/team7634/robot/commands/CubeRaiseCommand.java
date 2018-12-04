package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class CubeRaiseCommand extends Command {

    public static double currentPos = 0.0;

    public CubeRaiseCommand() {
        requires(Robot.cubeLifter);
    }

    protected void initialize() {
        currentPos = Robot.cubeLifter.liftPos; //grabs position from last command
    }

    @Override
    protected void execute() {
        Robot.cubeLifter.raise();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.cubeLifter.liftPos = currentPos; //saves position for next command
        Robot.cubeLifter.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
