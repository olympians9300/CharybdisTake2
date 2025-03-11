// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TankDrive extends Command {

  private final DriveTrain m_DriveTrain;
  private DoubleSupplier m_left;
  private DoubleSupplier m_right;

  /** Creates a new TankDrive. */
  /*
  public TankDrive(double constantLeft double constantRight, DriveTrain m_driveTrain) {
   this(() -> constantLeft () -> constantRight, m_DriveTrain); 
  }  */ 
  public TankDrive(DoubleSupplier left, DoubleSupplier right, DriveTrain subsystem){
    m_left = left;
    m_right = right;

    m_DriveTrain = subsystem;
    addRequirements(m_DriveTrain);
  // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //m_DriveTrain.tankDrive(m_left.getAsDouble() * Constants.DriveConstants.kDriveDeadband, m_right.getAsDouble()  * Constants.DriveConstants.kDriveDeadband);
    //java.io.PrintStream.print("left: ", m_left.getAsDouble(), " right: ", m_right.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.tankDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
