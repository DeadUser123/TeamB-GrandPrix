package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import frc.robot.Constants;

public class Chassis {
    private Victor drivemotor; // the motor that powers the speed
    private Victor rotatemotor; // the motor for turning the robot
    private Timer timer;
    private int time = 0;
    private double current_position = 0;
    private int direct;

    public Chassis() {
        drivemotor = new Victor(Constants.DRIVEMOTORPORT);
        rotatemotor = new Victor(Constants.ROTATEMOTORPORT);
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
        if (current_position != desired_position || Math.abs(current_position - desired_position) > 0.05) {
            direct = (current_position - desired_position > 0) ? 1 : -1; // finds which direction the motor should turn
            rotatemotor.set(0.1 * Math.abs(current_position - desired_position) * direct); // begins turning the motor
                                                                                           // at a speed relative to
                                                                                           // difference in current and
                                                                                           // desired positions
            timer.delay(0.1); // constant time delay so turning won't take too long
            rotatemotor.set(0); // stops motor
            current_position = desired_position; // updates current position
        }
    }
}