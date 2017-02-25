package org.usfirst.frc295.Grizzlynator2017.commands;

import org.usfirst.frc295.Grizzlynator2017.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CmdIntakeSetPercentVbusWhileHeld extends Command
{
	private double _dSpeed = 0;


	public CmdIntakeSetPercentVbusWhileHeld(double speed)
	{
		requires(Robot.sysIntake);
		_dSpeed = speed;
	}


	@Override
	protected void initialize()
	{
		Robot.sysLift.setPercentVbus(_dSpeed);
		System.out.println("Started CmdIntakePercentVbus");
	}


	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		// Robot.sysLift.setPercentVbus(Robot.oi.getJoystickDriver().getRawAxis(0));
	}


	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}


	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		Robot.sysLift.stop();
	}


	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
		end();
	}
}
