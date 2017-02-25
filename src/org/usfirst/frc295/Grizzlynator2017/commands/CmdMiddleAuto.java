package org.usfirst.frc295.Grizzlynator2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CmdMiddleAuto extends CommandGroup{

	public CmdMiddleAuto(){
		addSequential(new Waypoint(78.5,0,.7,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		addSequential(new CmdReleaseGear());
		addSequential(new Wait());
		addSequential(new CmdHoldGear());
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		//addSequential(new CmdShooterDefault());
	
	}
}
