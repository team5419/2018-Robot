/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot;

import edu.wpi.first.wpilibj.DriverStation; 
import edu.wpi.first.wpilibj.TimedRobot;

import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5419.robot.commands.*;
import org.usfirst.frc.team5419.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static Intake intake;
	public static ClosedDriveTrain driveTrain;
	public static intakeArm intakeArm;
	public static climberWinch climberWinch;
	public static climberHook climberHook;
	public static OI oi;

	public static SendableChooser<String> loopMode;
	
	Command autoCommand;
	SendableChooser<String> chooser;

	@Override public void robotInit() {
		
		//camera!
		CameraServer.getInstance().startAutomaticCapture();
		
		
		OI.gyro.calibrate();
		OI.gyro.reset();
		intake = new Intake();
		driveTrain = new ClosedDriveTrain();
		intakeArm = new intakeArm();
		climberHook = new climberHook();
		climberWinch = new climberWinch();
		oi = new OI();
		
		chooser = new SendableChooser<String>();
		chooser.addDefault("Put Block", "Put");
		chooser.addObject("Cross Base", "Base");
		chooser.addObject("Cross Base Left", "Left");
		chooser.addObject("Cross Base Right", "Right");
		SmartDashboard.putData("Auto mode", chooser);
		
		loopMode = new SendableChooser<String>();
		loopMode.addDefault("closed", "closed");
		loopMode.addObject("open", "open");
		SmartDashboard.putData("Loop mode", loopMode);
	}

	@Override public void disabledInit() {

	}

	@Override public void disabledPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Gyro", OI.gyro.getAngle());
		//SmartDashboard.putNumber("Left Encoder", OI.encoderLeft.get());
	}

	@Override public void autonomousInit() {
//		if(chooser.getSelected().equals("Put")) {
//			autoCommand = new autoPutGroup();
//		}
//		else {
//			autoCommand = new autoDriveCommand(120, 5);
//		}
		
		/*if(chooser.getSelected().equals("Put")) {
			autoCommand = new autoPutGroup();
			SmartDashboard.putString("Auto", "Put");
			
		}
		else if(chooser.getSelected().equals("Left")){
			autoCommand = new autoDriveGroupLeft();
			SmartDashboard.putString("Auto", "Left");

		}
		else if(chooser.getSelected().equals("Right")){
			autoCommand = new autoDriveGroupRight();
			SmartDashboard.putString("Auto", "Right");

		}
		else{
			autoCommand = new autoDriveCommand(10 / RobotMap.CIRCUMFERENCE * RobotMap.countsPerRev, 5);
			SmartDashboard.putString("Auto", "Base");

		}*/
		
		double target = 10000;
		autoCommand = new autoDriveCommand(target / RobotMap.CIRCUMFERENCE * RobotMap.countsPerRev);
		
		System.err.println(autoCommand);
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
		//SmartDashboard.putNumber("EncoderLeft", OI.encoderLeft.getRaw());
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
	@Override public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//SmartDashboard.putNumber("EncoderLeft", OI.encoderLeft.getRaw());
		//SmartDashboard.putNumber("EncoderRight", OI.encoderRight.getRaw());
		SmartDashboard.putNumber("Gyro", OI.gyro.getAngle());

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override public void testPeriodic() {
	}
}
