package org.usfirst.frc.team7634.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team7634.robot.Robot;
import org.usfirst.frc.team7634.robot.RobotMap;
import org.usfirst.frc.team7634.robot.RobotSettings;

public class AutonomousCommands extends CommandGroup {

    public AutonomousCommands() {
        addSequential(new DriveStraightCommand(RobotSettings.TRIAL_ONE,0.65, true));
        addSequential(new AutoLauncherCommand());
        addSequential(new DriveStraightCommand(RobotSettings.TRIAL_TWO, 0.65, false));
    }
}
