package org.usfirst.frc.team7634.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class ClawMovementCommand extends Command {

	public static double currentSpeed = 0.15;

    public ClawMovementCommand() {
        requires(Robot.cubeGrabber);
    }

    protected void initialize() {
    	currentSpeed = 0.15;
    }

    //debug: if ramp up doesn't work, test if current speed is actually being incremented. if not, use class type saved variable.
    @Override
    protected void execute() {
		double left_trigger = Robot.oi.getController().getTriggerAxis(GenericHID.Hand.kLeft);
		double right_trigger = Robot.oi.getController().getTriggerAxis(GenericHID.Hand.kRight);
		/*
		 * Set current speed to 0.97 for next iteration (will NEVER be above 1.0).
		 * Initialization of [currentSpeed] at 0.15 will take 28 iterations of +0.03 to equal 0.99.
		 */
		if (currentSpeed >= 0.99) {
			currentSpeed = 0.97;
		}
		if (right_trigger > 0.10) { //on right trigger press -- dominant, affects left release.
			if (left_trigger > 0) {
				currentSpeed = 0.15;
			}
			currentSpeed += 0.03;
			Robot.cubeGrabber.grab(currentSpeed);
		}
		else if  (left_trigger > 0.10) { //on left trigger press -- but no right
			Robot.cubeGrabber.release(left_trigger);
		} else {
			currentSpeed = 0.15; //default case, keep it spinning for holding cubes
			Robot.cubeGrabber.grab(currentSpeed);
		}

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
