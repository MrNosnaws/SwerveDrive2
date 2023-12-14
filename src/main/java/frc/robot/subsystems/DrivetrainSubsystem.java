package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.swerve.SwerveDriveModule;

public class DrivetrainSubsystem extends SubsystemBase {

    private final SwerveDriveModule frontLeftWheel;
    private final SwerveDriveModule frontRightWheel;
    private final SwerveDriveModule backLeftWheel;
    private final SwerveDriveModule backRightWheel;

    public DrivetrainSubsystem () {

        frontLeftWheel = new SwerveDriveModule(0, 0, 0);

        frontRightWheel = new SwerveDriveModule(0, 0, 0);

        backLeftWheel = new SwerveDriveModule(0, 0, 0);

        backRightWheel = new SwerveDriveModule(0, 0, 0);

    }

    public void testRunSteerMotor() {
        frontLeftWheel.RunSteerMotor(45);
    }


    




}