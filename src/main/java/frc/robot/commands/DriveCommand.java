package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NeoDrivetrainSubsystem;
import java.util.function.Supplier;

public class DriveCommand extends CommandBase {

    private final NeoDrivetrainSubsystem drivetrain;
    private final Supplier<Double> xAxis;
    private final Supplier<Double> yAxis;
    private final Supplier<Double> yAxisRotation;

    public DriveCommand(
        NeoDrivetrainSubsystem drivetrain, 
        Supplier<Double> xAxis, 
        Supplier<Double> yAxis, 
        Supplier<Double> yAxisRotation) {
            this.drivetrain = drivetrain;
            this.xAxis = xAxis;
            this.yAxis = yAxis;
            this.yAxisRotation = yAxisRotation;

            addRequirements(drivetrain);
        }

    @Override
    public void initialize() {}

    @Override 
    public void execute() {
        drivetrain.drive(deadzone(xAxis.get()), deadzone(yAxis.get()), deadzone(yAxisRotation.get())); //is this right
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
    
    public double deadzone(double input) {
        return Math.abs(input) < 0.15 ? 0 : input;
    }
}
