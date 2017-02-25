package org.usfirst.frc295.Grizzlynator2017.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{

	@Override
	protected boolean isFinished() {	
		if(timeSinceInitialized()> 3){
			return true;
			
		}
		else{
			return false;
		}
	}
	protected void end(){
	
	}
	
}
