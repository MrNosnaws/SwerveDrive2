package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommands extends CommandBase {

    public void TestCommand(DrivetrainSubsystem drivetrain) {
        //call setstates on all swerve modules in given drivetrain
        addRequirements(drivetrain);
    }

}
