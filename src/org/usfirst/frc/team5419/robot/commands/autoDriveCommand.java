/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.Robot;
import org.usfirst.frc.team5419.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class autoDriveCommand extends Command {
	int distance;
	int time_max;
	Timer timer;
	
	public autoDriveCommand(int distance) {
		requires(Robot.driveTrain);
		this.distance = distance;
	}
	
	public autoDriveCommand(int distance, int time_max) {
		requires(Robot.driveTrain);
		this.distance = distance;
		this.time_max = time_max;
		timer = new Timer();
		timer.reset();
		timer.start();
	}
	
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		OI.encoderLeft.reset();
		OI.encoderRight.reset();
		
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrain.driveForward();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		System.out.println(OI.encoderLeft.get() + " "+ OI.encoderRight.getRaw());
		double encoderavg = (Math.abs(OI.encoderLeft.getRaw()) + Math.abs(OI.encoderRight.getRaw()))/2.0;
		double distanceavg = encoderavg * RobotMap.CIRCUMFERENCE / 720;
		System.out.println(distanceavg + " " + distance);
		if(distanceavg > distance) {
			return true;
		}else if(timer != null && timer.get() > time_max) {
			timer.stop();
			return true;
		}
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
