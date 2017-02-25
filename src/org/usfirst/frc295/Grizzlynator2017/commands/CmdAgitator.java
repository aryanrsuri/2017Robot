package org.usfirst.frc295.Grizzlynator2017.commands;


import org.usfirst.frc295.Grizzlynator2017.*;

import edu.wpi.first.wpilibj.command.Command;

public class CmdAgitator extends Command
{
	private double _dSpeed = 0;


	public CmdAgitator(double speed)
	{
		//requires(Robot.sysAgitator);
		_dSpeed = speed;
	}


	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	protected void initialize()
	{

	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		// Robot.sysLift.setPercentVbus(Robot.oi.getJoystickDriver().getRawAxis(0));
		System.out.println("Started CmdAgitator");
		//Robot.sysAgitator.setOpenLoop(_dSpeed);
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
