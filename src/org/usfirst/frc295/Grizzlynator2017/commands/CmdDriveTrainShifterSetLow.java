// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc295.Grizzlynator2017.commands;

import org.usfirst.frc295.Grizzlynator2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CmdDriveTrainShifterSetLow extends Command
{

	public CmdDriveTrainShifterSetLow()
	{
		requires(Robot.sysDriveTrainShifter);
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.sysDriveTrainShifter.setLowGear();
		System.out.println("Cmd Low Gear");
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
	}


	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return true;
	}


	// Called once after isFinished returns true
	@Override
	protected void end()
	{
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}