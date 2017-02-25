package org.usfirst.frc295.Grizzlynator2017.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CmdRightAuto extends CommandGroup{
//48 NEEDS to be changed for real distances
	public CmdRightAuto(){
		addSequential(new Waypoint(114.3,0,.7,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		addSequential(new CmdReleaseGear());
		addSequential(new Wait());
		addSequential(new CmdHoldGear());
		addSequential(new Waypoint(20,45,.7,false));
		addSequential(new Waypoint(60,0,-.7,false));
		addSequential(new Waypoint(20,90,.7,false));
		addSequential(new Waypoint(240,0,.7,false));
		addSequential(new Waypoint_Vision(0,0,false));
		addSequential(new Wait());
		addSequential(new Waypoint_Track(.7,true));
		addSequential(new Wait());
		addSequential(new CmdShooterDefault());
	
	}
}
