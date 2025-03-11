// RobotBuilder Version: 6.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

// The robot's subsystems
    private final DriveTrain m_driveTrain = new DriveTrain();
    private final CoralShooter m_CoralShooter = new CoralShooter();
    private final Elevator m_Elevator = new Elevator();;

// Joysticks
  private final XboxController operatorController = new XboxController(1); //consider changing to CommandXboxController for Trigger events
  private final XboxController driverController = new XboxController(0);
   
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  public XboxController getDriveController() {
    return driverController;
  }

  public XboxController getOperatorController() {
    return operatorController;
  }
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  public RobotContainer() { //In old code this was private...
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems
    SmartDashboard.putData(m_CoralShooter);
    SmartDashboard.putData(m_Elevator);
    SmartDashboard.putData(m_driveTrain);
    
    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand( m_driveTrain ));
    SmartDashboard.putData("Tank Drive: Xbox Controller 1", new TankDrive(() -> getDriveController().getLeftY(), 
    () -> getDriveController().getRightY(), m_driveTrain));
    SmartDashboard.putData("Shoot Coral", new R2toShootCoral(m_CoralShooter));
    SmartDashboard.putData("Elevator Up", new ytoElevatorUp(m_Elevator));

    // SmartDashboard.putData("MoveElevatorUp", new MoveElevatorUp( m_elevator ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
  
    configureButtonBindings();
    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    m_driveTrain.setDefaultCommand(new TankDrive(() -> getDriveController().getLeftY(), 
            () -> -getDriveController().getRightY(), m_driveTrain));   
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand( m_driveTrain ));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  
  public static RobotContainer getInstance() {
    return m_robotContainer;
  }
  
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

        m_driveTrain.setDefaultCommand(
            new RunCommand( //command.new ?
              () ->
                m_driveTrain.tankDrive(
                  -driverController.getLeftY(),-driverController.getRightY()),
                   m_driveTrain));
                   
//System.out.println("left: ", driverController.getRawAxis(2), "right: ", driverController.getRawAxis(5));  //Needs to be added to Lamda above


//m_robotDrive.arcadeDrive(-m_controller.getLeftY(), -m_controller.getRightX());
//Create some buttons
/*final JoystickButton ytoElevatorUp = new JoystickButton(operatorController, XboxController.Button.kY.value);        
ytoElevatorUp.onTrue(new MoveElevatorUp( m_elevator ).withInterruptBehavior(InterruptionBehavior.kCancelSelf));
*/

//This was an attempt to get the drive base to drive a bit with a button press, it never worked:

//driverController.x().onTrue(new DriveABit(m_driveTrain).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

//Commands needed: Shoot Coral, Move Elevator
//Trigger R2Button = operatorController.rightTrigger();
//Trigger yButton = operatorController.y();
/* 
R2Button
  .onTrue(new R2toShootCoral())
  .onFalse(R2toShootCoral.end());
*/
/*
 * *********************Copy from bolt.new:
 * 
 
private void configureButtonBindings() {
    // Drive controls
    m_driveTrain.setDefaultCommand(
        new RunCommand(
            () -> m_driveTrain.tankDrive(
                driverController.getLeftY(),
                driverController.getRightY()),
            m_driveTrain));

    // Button bindings using Triggers
    driverController.x()
        .onTrue(new DriveABit(m_driveTrain))
        .onFalse(new InstantCommand(() -> m_driveTrain.stop(), m_driveTrain));

    // Example of using triggers for other controls
    driverController.rightTrigger(0.5)  // 0.5 is the activation threshold
        .onTrue(new InstantCommand(() -> {
            // Command to execute when trigger pressed
        }))
        .onFalse(new InstantCommand(() -> {
            // Command to execute when trigger released
        }));

    // Operator controls
    operatorController.y()
        .onTrue(new InstantCommand(() -> {
            // Y button pressed command
        }))
        .onFalse(new InstantCommand(() -> {
            // Y button released command
        }));
}

 * 
 * 
 */
//CoralShooter runs when pressed, roll CoralShooter wheel

    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
}

