package org.usfirst.frc295.Grizzlynator2017;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Different Joysticks have different button and Axis ID numbers The
 * JoystickDriver and JoystickOperator allows a call to get the proper button or
 * read a value from a button or axis
 *
 * For Each Joystick Type that needs a different mapping, Add a mapping.
 *
 * If the mapping is the same as the XBOX, a specific mapping is not required
 * and the default mapping (which is the same as the XBox) will be utilized.
 */
public class JoystickOperator extends Joystick
{

	// X-BOX OPERATOR JOYSTICK BUTTONS
	public static final short OPERATOR_BUTTON_SHOOTER_ON_XBOX  = 1;
	public static final short OPERATOR_BUTTON_GEAR_OPEN_XBOX   = 2;
	public static final short OPERATOR_BUTTON_GEAR_PUSH_XBOX   = 3;
	public static final short OPERATOR_BUTTON_AGITATOR_ON_XBOX = 4;
	public static final short OPERATOR_BUTTON_LIFT_RAISE_XBOX  = 5;
	public static final short OPERATOR_BUTTON_INTAKE_ON_XBOX   = 6;

	// LOGITECH (IF DIFFERENT FROM XBOX) OPERATOR JOYSTICK BUTTONS

	public static enum JoystickType
	{
		XBOX(0), LOGITECH(1);

		public final int value;


		private JoystickType(int value)
		{
			this.value = value;
		}
	}

	JoystickType _eJoystickType = JoystickType.XBOX;


	public JoystickOperator(int iPort, JoystickType eType)
	{
		super(iPort);
		_eJoystickType = eType;
	}


	JoystickButton getShooterOnButton()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOTER_ON_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_SHOOTER_ON_XBOX));
		}
	}


	JoystickButton getGearArmsOpen()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_GEAR_OPEN_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_GEAR_OPEN_XBOX));
		}
	}


	JoystickButton getGearPush()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_GEAR_PUSH_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_GEAR_PUSH_XBOX));
		}
	}


	JoystickButton getAgitator()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_AGITATOR_ON_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_AGITATOR_ON_XBOX));
		}
	}


	JoystickButton getLiftRaise()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_LIFT_RAISE_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_LIFT_RAISE_XBOX));
		}
	}


	JoystickButton getIntake()
	{
		switch (_eJoystickType)
		{
		case XBOX:
			return (new JoystickButton(this, OPERATOR_BUTTON_INTAKE_ON_XBOX));

		default:
			return (new JoystickButton(this, OPERATOR_BUTTON_INTAKE_ON_XBOX));
		}
	}

}
