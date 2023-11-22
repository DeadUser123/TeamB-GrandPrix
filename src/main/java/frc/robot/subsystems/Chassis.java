package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class Chassis {
    private Victor drivemotor; // the motor that powers the speed
    private Victor rotatemotor; // the motor for rotation

    public Chassis() {
        drivemotor = new Victor(Constants.DRIVEMOTORPORT);
        rotatemotor = new Victor(Constants.ROTATEMOTORPORT);
    }

    public void drive(double speed) {
        drivemotor.set(speed); // should theoretically work
    }

    public void turn(double speed) {
        rotatemotor.set(speed); // unsure if this would work with the chassis, needs testing
    }
}
