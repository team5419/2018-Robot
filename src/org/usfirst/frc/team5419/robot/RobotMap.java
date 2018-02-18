/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5419.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	 public static int leftBackMotor = 9;
	 public static int rightBackMotor = 2;
	 public static int leftFrontMotor = 0;
	 public static int rightFrontMotor = 10;
	 //When looking at robot from front
	 public static int intakeLeft = 1;
	 public static int intakeRight = 3;
	 public static int intakeArm = 6;
	 public static final double CIRCUMFERENCE = 5.0*Math.PI;

}
