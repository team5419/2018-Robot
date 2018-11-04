package org.usfirst.frc.team5419.robot.subsystems;

import org.usfirst.frc.team5419.robot.OI;
import org.usfirst.frc.team5419.robot.RobotMap;

import org.usfirst.frc.team5419.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	WPI_TalonSRX leftBackMotor = new WPI_TalonSRX(RobotMap.leftBackMotor);	
	WPI_TalonSRX rightBackMotor = new WPI_TalonSRX(RobotMap.rightBackMotor);
	WPI_TalonSRX leftFrontMotor = new WPI_TalonSRX(RobotMap.leftFrontMotor);
	WPI_TalonSRX rightFrontMotor = new WPI_TalonSRX(RobotMap.rightFrontMotor);

	SpeedControllerGroup left = new SpeedControllerGroup(leftFrontMotor, leftBackMotor);
	SpeedControllerGroup right = new SpeedControllerGroup(rightFrontMotor, rightBackMotor);
	DifferentialDrive drive = new DifferentialDrive(left, right);
	
	public void drive() {
		
		drive.arcadeDrive(-OI.driverStick.getRawAxis(1), OI.driverStick.getRawAxis(4));

	}
	public void driveForward(){
		drive.arcadeDrive(0.5, 0);
	}
	public void turn(int direction) {
		if(direction==1)
			drive.arcadeDrive(0, 0.6);
		else {
			drive.arcadeDrive(0, -0.6);
		}
	}
	
	public void stop() {
		drive.arcadeDrive(0, 0);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveCommand());
	}
}