package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5419.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoPutGroup extends CommandGroup {
	public autoMap autoMap;
	String gameData;

	public autoPutGroup() {
		
		//Starting with left of robot on center line
		//Adjust for 17 inches to right
		autoMap = new autoMap();
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			System.err.println("left");

			addSequential(new autoDriveCommand(autoMap.left_autoDrive_distance_1));
			addSequential(new autoTurnCommand(45, -1));
			addSequential(new autoDriveCommand(autoMap.left_autoDrive_distance_2));
			addSequential(new autoTurnCommand(45, 1));
			addSequential(new autoDriveCommand(autoMap.left_autoDrive_distance_3));
			addSequential(new outtakeAutoCommand(autoMap.outtake_time));

		} else {
			
			System.err.println("right");
			addSequential(new autoDriveCommand(autoMap.right_autoDrive_distance_1));
			addSequential(new autoTurnCommand(45, 1));
			addSequential(new autoDriveCommand(autoMap.right_autoDrive_distance_2));
			addSequential(new autoTurnCommand(45, -1));
			addSequential(new autoDriveCommand(autoMap.right_autoDrive_distance_3));
			addSequential(new outtakeAutoCommand(autoMap.outtake_time));
			
			
		}
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
		//Robot.driveTrain.drive();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrain.stop();
		
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}