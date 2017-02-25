package org.usfirst.frc295.Grizzlynator2017.commands;

import org.usfirst.frc295.Grizzlynator2017.*;

import edu.wpi.first.wpilibj.command.Command;

//when you're done making a command and want to make a button
//to activate the command, identify it in the OI.java
public class CmdIntakeDefault extends Command
{

	public CmdIntakeDefault()
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.sysIntake);
	}


	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		Robot.sysIntake.stop();
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
		return false;
	}


	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.sysIntake.stop();
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
