package org.usfirst.frc.team7634.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {
        addSequential(new DriveStraightCommand(RobotSettings.TRIAL_ONE));
        //addSequential(new *somelaunchername*Command());
        addSequential(new DriveStraightCommand(RobotSettings.TRIAL_TWO));
    }
}
