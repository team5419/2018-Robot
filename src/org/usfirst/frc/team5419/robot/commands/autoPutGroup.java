package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team5419.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoPutGroup extends CommandGroup {
	String gameData;

	public autoPutGroup() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.charAt(0) == 'L')
		{
			addSequential(new autoDriveCommand(24));
			addSequential(new autoTurnCommand(45, -1));
			addSequential(new autoDriveCommand(70));
			addSequential(new autoTurnCommand(45, 1));
			addSequential(new autoDriveCommand(25));
			addSequential(new outtakeAutoCommand());

			System.err.println("left");
		} else {
			addSequential(new autoDriveCommand(24));
			addSequential(new autoTurnCommand(45, 1));
			addSequential(new autoDriveCommand(70));
			addSequential(new autoTurnCommand(45, -1));
			addSequential(new autoDriveCommand(25));
			addSequential(new outtakeAutoCommand());
			
			
			System.err.println("right");
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