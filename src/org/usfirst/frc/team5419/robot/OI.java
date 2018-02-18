/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team5419.robot.commands.*;

import com.ctre.CANTalon;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final Joystick stick = new Joystick(0);
	Button intakeButton = new JoystickButton(stick, 1);
	Button outtakeButton = new JoystickButton(stick, 2);
	Button upArmButton = new JoystickButton(stick, 5);
	Button downArmButton = new JoystickButton(stick, 6);
	public static final Encoder encoderLeft = new Encoder(1,2,false,Encoder.EncodingType.k2X);
	public static final Encoder encoderRight = new Encoder(3,4,false,Encoder.EncodingType.k2X);
	
	
	public OI() {
		intakeButton.whileHeld(new intakeCommand(0));
		outtakeButton.whileHeld(new intakeCommand(1));
		downArmButton.whileHeld(new intakeArmCommand(0));
		upArmButton.whileHeld(new intakeArmCommand(1));
	}
}
