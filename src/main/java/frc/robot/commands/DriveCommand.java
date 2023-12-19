package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.NeoDrivetrainSubsystem;
import java.util.function.Supplier;

public class DriveCommand extends CommandBase {

    private final NeoDrivetrainSubsystem drivetrain;
    private final Supplier<Double> xAxis;
    private final Supplier<Double> yAxis;
    private final Supplier<Double> zAxis;

    public DriveCommand(
        NeoDrivetrainSubsystem drivetrain, 
        Supplier<Double> xAxis, 
        Supplier<Double> yAxis, 
        Supplier<Double> zAxis) {
            this.drivetrain = drivetrain;
            this.xAxis = xAxis;
            this.yAxis = yAxis;
            this.zAxis = zAxis;

            addRequirements(drivetrain);
        }

    @Override
    public void initialize() {}

    @Override 
    public void execute() {
        drivetrain.drive(xAxis.get(), yAxis.get(), zAxis.get()); //is this right
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
