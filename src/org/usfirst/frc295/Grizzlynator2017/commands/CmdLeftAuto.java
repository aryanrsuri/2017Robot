package org.usfirst.frc295.Grizzlynator2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CmdLeftAuto extends CommandGroup{

	public CmdLeftAuto(){
		addSequential(new Waypoint(114.3,0,.7,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		addSequential(new CmdReleaseGear());
		addSequential(new Waypoint(12,0,-.7,false));
		addSequential(new CmdHoldGear());
		addSequential(new Wait());
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		//addSequential(new CmdShooterDefault());
	
	}
}
