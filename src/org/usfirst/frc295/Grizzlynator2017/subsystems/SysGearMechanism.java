// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc295.Grizzlynator2017.subsystems;

import org.usfirst.frc295.Grizzlynator2017.RobotMap;
import org.usfirst.frc295.Grizzlynator2017.commands.CmdGearMechanismDefault;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SysGearMechanism extends Subsystem
{
	DoubleSolenoid solDouble = new DoubleSolenoid(RobotMap.CAN_PCM_PORT_GEAR_LEFT, RobotMap.CAN_PCM_PORT_GEAR_RIGHT);


	public SysGearMechanism()
	{
		holdGear();
	}


	@Override
	public void initDefaultCommand()
	{
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new CmdGearMechanismDefault());

	}


	public void releaseGear()
	
	{
		solDouble.set(DoubleSolenoid.Value.kReverse);
	}


	public void holdGear()
	{
		solDouble.set(DoubleSolenoid.Value.kForward);
	}


	public void pushGear()
	{

	}

}
