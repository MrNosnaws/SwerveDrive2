package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import java.util.function.Supplier;

public class DriveCommand extends CommandBase {

    private final DrivetrainSubsystem drivetrain;
    private final Supplier<Double> xAxis;
    private final Supplier<Double> yAxis;
    private final Supplier<Double> zAxis;

    public DriveCommand(
        DrivetrainSubsystem drivetrain, 
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
        
    }

    @Override
    public boolean isFinished() {
        return true; //change later
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
