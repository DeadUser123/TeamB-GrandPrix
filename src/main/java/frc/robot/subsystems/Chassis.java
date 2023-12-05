package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class Chassis {
    private Victor drivemotor; // the motor that powers the speed
    private Victor rotatemotor; // the motor for turning the robot
    // private int time = 0;
    private double current_position = 0;

    public Chassis() {
        drivemotor = new Victor(Constants.DRIVEMOTORPORT);
        rotatemotor = new Victor(Constants.ROTATEMOTORPORT);
        drivemotor.set(0);
        rotatemotor.set(0);
    }

    public void setspeed(double speed) {
        drivemotor.set(speed); // should theoretically work
    }

    public void turn(double desired_position) {
        // old code (no ramping):
        // time += 1;
        // if (direction != 0) {
        // if (time > Constants.MAXTURNVALUE) {
        // time = Constants.MAXTURNVALUE;
        // rotatemotor.set(0);
        // } else {
        // if (direction > 0) {
        // rotatemotor.set(.1);
        // prevdirect = 1;
        // } else {
        // rotatemotor.set(-.1);
        // prevdirect = -1;
        // }
        // }
        // } else {
        // rotatemotor.set(-1 * prevdirect);
        // timer.delay(time / 0.2);
        // rotatemotor.set(0);
        // }
        // new code: should have ramping based on
        if (Math.abs(current_position - desired_position) > 0.05) {
            rotatemotor.set(0.1 * (current_position - desired_position)); // begins turning the motor
                                                                          // at a speed relative to
                                                                          // difference in current and
                                                                          // desired positions
            current_position += 0.01 * (current_position - desired_position);
        } else {
            rotatemotor.set(0);
        }
    }
}