package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveOnceCommand extends CommandBase {

    private final double xSpeed;
    private final double ySpeed;
    private final double radians;

    public DriveOnceCommand(double xSpeed, double ySpeed, double radians, DrivetrainSubsystem drivetrain) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.radians = radians;
        
        drivetrain.drive(xSpeed, ySpeed, radians);
        addRequirements(drivetrain);
    }

}
