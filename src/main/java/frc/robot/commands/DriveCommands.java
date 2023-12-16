package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveCommands extends CommandBase {
    protected final DrivetrainSubsystem drivetrain;

    //setting up needed stuff for the drive commands
    private final DoubleSupplier xSupplier; //forward velocity
    private final DoubleSupplier ySupplier; //sideward velocity
    private final DoubleSupplier rotationSupplier; //angular velocity

    //power limiters for the above
    private final SlewRateLimiter xLimiter;
    private final SlewRateLimiter yLimiter;
    private final SlewRateLimiter rotaionLimiter;

  

    public DriveCommands (DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier rotationSupplier, DrivetrainSubsystem drivetrain) {

        // setting things up so we use local versions and don't get errors

        this.drivetrain = drivetrain;

        this.xSupplier = xSupplier;

        this.ySupplier = ySupplier;

        this.rotationSupplier = rotationSupplier;

        //set up limits

        //NOTE: SET UP LIMITERS TO WHATEVER VALUE

        rotaionLimiter = new SlewRateLimiter(0);

        yLimiter = new SlewRateLimiter(0);

        xLimiter = new SlewRateLimiter(0);

        addRequirements(drivetrain);
    } 





    public void TestCommand(DrivetrainSubsystem drivetrain) {


        drivetrain.testRunSteerMotor();
        addRequirements(drivetrain);
    }







}
