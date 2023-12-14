package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommands extends CommandBase {
    


    public void TestCommand(DrivetrainSubsystem drivetrain) {


        drivetrain.testRunSteerMotor();
        addRequirements(drivetrain);
    }






}
