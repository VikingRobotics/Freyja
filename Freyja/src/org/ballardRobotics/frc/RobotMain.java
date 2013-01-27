/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.ballardRobotics.frc;


import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Jaguar leftDrive;
    Jaguar rightDrive;
    Victor pickup;
    Joystick joy1;
    RobotDrive drive;
    ToggleButton rollIn;
    JoystickButton button3;
    ToggleButton rollOut;
    JoystickButton button4;
    public void robotInit() {
        leftDrive = new Jaguar(1);
        rightDrive = new Jaguar(2);
        pickup = new Victor(3);
        joy1 = new Joystick(1);
        drive = new RobotDrive(leftDrive, rightDrive);
        button3 = new JoystickButton(joy1, 3);
        button4 = new JoystickButton(joy1, 4);
        rollIn = new ToggleButton(button3);
        rollOut = new ToggleButton(button4);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.arcadeDrive(joy1.getY(), joy1.getTwist());
        if(rollOut.isPressed && !rollIn.isPressed){
            pickup.set(1);
        }else if(!rollOut.isPressed && rollIn.isPressed){
            pickup.set(-1);
        }else{
            pickup.set(0);
        }
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
