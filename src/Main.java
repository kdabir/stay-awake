import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

class Main {
    public static final long ONE_SECOND = 1000;
    public static final long DEFAULT_FREQUENCY = 30; //seconds

    /**
     * First argument to the program can be a number representing interval in seconds, after which mouse will move.
     * Recommended value is between 15 - 90.
     *
     * @param args
     * @throws AWTException
     */
    public static void main(String[] args) throws AWTException {
        final MovableMouse mouse = new MovableMouse();
        final Timer timer = new Timer();
        long frequencyInSeconds = DEFAULT_FREQUENCY;

        try {
            frequencyInSeconds = (args.length > 0) ? Long.parseLong(args[0]) : DEFAULT_FREQUENCY;
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }

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
            }
        });

        timer.schedule(timerTask, ONE_SECOND, frequencyInSeconds * ONE_SECOND );
    }
}

class MovableMouse {
    private final Robot robot;

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
