/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team5419.robot.commands.*;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick driverStick = new Joystick(0);
	public static final Joystick operatorStick = new Joystick(1);
	Button intakeButton = new JoystickButton(operatorStick, 2);
	Button outtakeButton = new JoystickButton(operatorStick, 3);
	Button winchButtonWind = new JoystickButton(operatorStick, 6);
	Button winchButtonUnwind = new JoystickButton(operatorStick, 5);
	public static final Encoder encoderLeft = new Encoder(2,3,false,Encoder.EncodingType.k2X);
	//public static final Encoder encoderRight = new Encoder(4,5,false,Encoder.EncodingType.k2X);
	//public static final WPI_TalonSRX encoderLeft  = new WPI_TalonSRX(RobotMap.leftBackMotor);	
	public static final ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
		
	public OI() {
		intakeButton.whileHeld(new intakeCommand(0));
		outtakeButton.whileHeld(new intakeCommand(1));
		winchButtonWind.whileHeld(new climberWinchCommand(0));
		winchButtonUnwind.whileHeld(new climberWinchCommand(1));
		
	}
}
