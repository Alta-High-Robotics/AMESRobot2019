/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7634.robot.commands;

import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7634.robot.RobotSettings;

	/**
	 * An example command.  You can replace me with your own command.
	 */
	public class TankDriveCommand extends Command {
		public TankDriveCommand() {
			// Use requires() here to declare subsystem dependencies
			requires(Robot.driveTrain);
		}

		protected void initialize() {
		}

	@Override
	protected void execute() {
		Robot.driveTrain.left_axis = Robot.oi.getController().getRawAxis(RobotMap.CONTROLLER_AXIS_LEFT) * RobotSettings.DRIVE_DIRECTION;
		Robot.driveTrain.right_axis = Robot.oi.getController().getRawAxis(RobotMap.CONTROLLER_AXIS_RIGHT) * RobotSettings.DRIVE_DIRECTION;
		Robot.driveTrain.tankDrive();
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
