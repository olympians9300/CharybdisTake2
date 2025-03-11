// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.CoralShooter;
import edu.wpi.first.wpilibj.Timer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class R2toShootCoral extends InstantCommand {
  private CoralShooter m_coralShooter;
  private final Timer timer = new Timer();
  private final double kShooterSpeed = Constants.OtherConstants.kShooterSpeed;

  public R2toShootCoral(CoralShooter subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_coralShooter = subsystem;
    addRequirements(m_coralShooter);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  @Override
  public void execute() {
    m_coralShooter.setShooterSpeed(kShooterSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_coralShooter.setShooterSpeed(0);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= 0.5;
  }

}
