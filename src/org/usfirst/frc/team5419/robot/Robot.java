/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot;

import edu.wpi.first.wpilibj.DriverStation; 
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5419.robot.commands.*;
import org.usfirst.frc.team5419.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Intake intake;
	public static DriveTrain driveTrain;
	public static intakeArm intakeArm;
	public static OI oi;

	Command autoCommand;
	SendableChooser<String> chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		OI.gyro.calibrate();
		OI.gyro.reset();
		intake = new Intake();
		driveTrain = new DriveTrain();
		intakeArm = new intakeArm();
		oi = new OI();
		chooser = new SendableChooser<String>();
		//Here I want to add the drive straight to solely cross the baseline command
		//and the command to figure out switch color position and drop a crate in it
		//auto line is 10ft from wall
//		chooser.addDefault("Cross Base", new autoDriveCommand(120));
//		chooser.addObject("Put Block", new autoPutGroup());
		chooser.addDefault("Cross Base", "Base");
		chooser.addObject("Put Block", "Put");
		SmartDashboard.putData("Auto mode", chooser);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", OI.gyro.getAngle());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		if(chooser.getSelected().equals("Base")) {
			autoCommand = new autoDriveCommand(120);
		}
		else {
			autoCommand = new autoPutGroup();
		}
	//	autoCommand = chooser.getSelected();
		System.err.println(autoCommand);
		// schedule the autonomous command (example)
		if (autoCommand != null) {
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", OI.gyro.getAngle());

	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("EncoderLeft", OI.encoderLeft.getRaw());
		SmartDashboard.putNumber("EncoderRight", OI.encoderRight.getRaw());
		SmartDashboard.putNumber("Gyro", OI.gyro.getAngle());

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
