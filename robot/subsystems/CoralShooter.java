// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class CoralShooter extends SubsystemBase {
  /** Creates a new CoralShooter. */    
  private static PWMSparkMax shooterMotor;
  
  
  public CoralShooter() { 
    shooterMotor = new PWMSparkMax(Constants.ElevatorConstants.kCoralShooter);
  }

  public void setShooterSpeed(double speed) {
    shooterMotor.set(speed);
  }

  public void stop(){
    shooterMotor.set(0);
  }

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
