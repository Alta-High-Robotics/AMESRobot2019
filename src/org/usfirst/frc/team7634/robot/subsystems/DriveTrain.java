/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7634.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team7634.robot.RobotSettings;
import org.usfirst.frc.team7634.robot.commands.TankDriveCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
	Victor left1 = new Victor(RobotMap.VICTOR_LEFT1);
	Victor left2 = new Victor(RobotMap.VICTOR_LEFT2);
	Victor right1 = new Victor(RobotMap.VICTOR_RIGHT1);
	Victor right2 = new Victor(RobotMap.VICTOR_RIGHT2);

	//groups both motors as one drive, both motors required for movement
	public SpeedControllerGroup leftSideDrive = new SpeedControllerGroup(left1, left2);
	public SpeedControllerGroup rightSideDrive = new SpeedControllerGroup(right1, right2);
	public DifferentialDrive drive = new DifferentialDrive(leftSideDrive, rightSideDrive);

	public double left_axis = 0.0, right_axis = 0.0;

	public void tankDrive() {
		double spd = RobotSettings.DRIVE_SPEED;
		drive.tankDrive(left_axis * spd, right_axis * spd);
	}

	public void arcadeDrive() {
		drive.arcadeDrive(Robot.oi.getController().getY(GenericHID.Hand.kLeft), Robot.oi.getController().getX(GenericHID.Hand.kRight));
	}

	@Override
	public void initDefaultCommand() {
		this.setDefaultCommand(new TankDriveCommand());
	}
}
