import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class Main {
    public static final int ONE_SECOND = 1000;
    public static final int DEFAULT_PERIOD = 30 * ONE_SECOND; // in ms

    public static void main(String[] args) throws AWTException {
        final MovableMouse mouse = new MovableMouse();
        final Point startLocation = mouse.getLocation();
        final Timer timer = new Timer();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("moving mouse to stay awake");
                mouse.buzz();
            }
        };

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Bye bye");
                mouse.setLocation(startLocation);
            }
        });

        timer.schedule(timerTask, 0, DEFAULT_PERIOD);
    }
}

class MovableMouse {
    private Robot robot;

    private int autoDelay = 100,
        buzzDistance = 5,
        buzzTimes = 3;

    MovableMouse() throws AWTException {
        this.robot = new Robot();

        robot.setAutoWaitForIdle(true);
        robot.setAutoDelay(autoDelay);
    }

    public void buzz() {
        Point originalLocation = getLocation();

        Point crestLocation = new Point(originalLocation);
        crestLocation.translate(buzzDistance, buzzDistance);

        Point troughLocation = new Point(originalLocation);
        troughLocation.translate(-buzzDistance, -buzzDistance);

        for (int i = 0; i < buzzTimes; i++) {
            setLocation(crestLocation);
            setLocation(troughLocation);
        }

        setLocation(originalLocation);
    }

    public Point getLocation() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public void setLocation(Point location) {
        robot.mouseMove((int) location.getX(), (int) location.getY());
    }

    /**
     * Minimum time differnce between two mouse actions
     * keep it high so that user sees mouse actions, but not so much that it blocks next action
     *
     * @return sefl
     */
    public MovableMouse setAutoDelay(int autoDelay) {
        this.autoDelay = autoDelay;
        return this;
    }

    /**
     * the number of pixles in which mouse is moved in one direction. In effect
     * mouse moves twice than this number and then finally returns to original location.
     *
     * @return self
     */
    public MovableMouse setBuzzDistance(int buzzDistance) {
        this.buzzDistance = buzzDistance;
        return this;
    }

    /**
     * the number of times mouse moves per buzz
     *
     * @return self
     */
    public MovableMouse setBuzzTimes(int buzzTimes) {
        this.buzzTimes = buzzTimes;
        return this;
    }

}
