package org.usfirst.frc295.Grizzlynator2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CmdTestAuto extends CommandGroup{
//48 NEEDS to be changed for real distances
	public CmdTestAuto(){
		addSequential(new Waypoint(32,0,.7,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new CmdReleaseGear());
		addSequential(new Wait());
		addSequential(new CmdHoldGear());
		addSequential(new Wait());
	
	}
}
