package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Intake extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX intake = new WPI_TalonSRX(RobotMap.intake);	
	WPI_TalonSRX intakeReversed = new WPI_TalonSRX(RobotMap.intakeReversed);
	
	public void run() {
		intake.set(1);
		intakeReversed.set(-1);
	}
	public void stop() {
		intake.set(0);
		intakeReversed.set(0);	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}