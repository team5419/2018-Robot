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
	/*
	 public static int leftBackMotor = 9;   // 9
	 public static int rightBackMotor = 2;  // 2
	 public static int leftFrontMotor = 0;  // 0
	 public static int rightFrontMotor = 10; // ?
	 //When looking at robot from front
	 public static int intakeLeft = 1;    //3
	 public static int intakeRight = 3; //?
	 public static int intakeArm = 6;  //6
	 public static int climberWinch = 4; // not sure if this is right
	 public static int climberHook = 5;
	 public static final double CIRCUMFERENCE = 5.0*Math.PI;*/

	 public static int SlotIdx = 0;
	 public static int TimeoutMs = 10;
	 
	 public static int maxSpeed = 5189;
	 
	 //PID Constants
	 
	 public static int PIDLoopIdx = 0;
	 public static double PIDkF = .1989;
	 public static double PIDkP = 1.111958 * .25;
	 public static double PIDkI = 0;
	 public static double PIDkD = 0;
	
	 public static int leftBackMotor = 9;   // 9
	 public static int rightBackMotor = 2;  // 2
	 public static int leftFrontMotor = 0;  // 0
	 public static int rightFrontMotor = 5; // ?
	 //When looking at robot from front
	 public static int intakeLeft = 3;    //3
	 public static int intakeRight = 8; //?
	 public static int intakeArm = 6;  //6
	 public static int climberWinch = 7; // not sure if this is right
	 public static int climberHook = 10;
	 public static int countsPerRev = 1024;
	 public static final double CIRCUMFERENCE = 5.0*Math.PI;
}
