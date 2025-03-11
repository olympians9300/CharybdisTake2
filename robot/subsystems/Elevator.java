// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  //Declarations
  private PWMSparkMax elevatorLeft;
  private PWMSparkMax elevatorRight;
  
  /** Creates a new Elevator. */
  public Elevator() {
    elevatorLeft = new PWMSparkMax(Constants.ElevatorConstants.kLeftElevatorPort);
      addChild("ElevatorLeft", elevatorLeft);
      elevatorLeft.setInverted(false);

    elevatorRight = new PWMSparkMax(Constants.ElevatorConstants.kRightElevatorPort);
      addChild("Elevator Right", elevatorRight);
      elevatorRight.setInverted(false);

    elevatorRight.addFollower(elevatorLeft);
  }
/*  public Command getElevatorCommand(){
    return this.startEnd(
      () -> {
        setElevatorSpeed(Constants.OtherConstants.kElevatorSpeed);
      }
      
      () -> {
        stop();
      });

  }
 */


  public void setElevatorSpeed(double speed) {
    elevatorRight.set(speed);
  }

  public void stop() {
    elevatorRight.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }
}
