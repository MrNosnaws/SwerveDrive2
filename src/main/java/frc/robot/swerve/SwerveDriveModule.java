package frc.robot.swerve;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;


public final class SwerveDriveModule {
    protected final CANCoder cancoder = new CANCoder(0);
    private final TalonFX driveMotor = new TalonFX(1);
    private final TalonFX steerMotor = new TalonFX(2);


}