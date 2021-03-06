package org.usfirst.frc.team2383.commands;


import java.util.function.DoubleSupplier;


import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team2383.robot.HAL.drivetrain;

public class TeleopDrive extends Command {

	private final DoubleSupplier rightStick;
	private final DoubleSupplier leftStick;

	public TeleopDrive(DoubleSupplier leftStick, DoubleSupplier rightStick) {
		super("Teleop Drive");
		requires(drivetrain);
		this.leftStick = leftStick;
		this.rightStick = rightStick;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		drivetrain.tank(leftStick.getAsDouble(), rightStick.getAsDouble());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain.tank(0, 0);
	}

	@Override
	protected void interrupted() {
		drivetrain.tank(0, 0);
	}

}
