/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7634.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc.team7634.robot.RobotMap;

import edu.wpi.first.wpilibj.XboxController;
import org.usfirst.frc.team7634.robot.commands.CubeLowerCommand;
import org.usfirst.frc.team7634.robot.commands.CubeRaiseCommand;
import org.usfirst.frc.team7634.robot.controller.XboxButton;
import sun.misc.Launcher;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	int port = RobotMap.XBOX_PORT;
	XboxController controller = new XboxController(port);

	public OI() {
		Button raise = new XboxButton(controller, XboxButton.Button.BumperRight);
		Button lower = new XboxButton(controller, XboxButton.Button.BumperLeft);

		raise.whileHeld(new CubeRaiseCommand());
		lower.whileHeld(new CubeLowerCommand());
	}
	
	public XboxController getController() {
		return controller;
	}
}


