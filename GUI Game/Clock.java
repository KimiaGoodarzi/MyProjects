package ca.concordia.algos;

public class Clock {


    private float millisPerCycle;

    private long lastUpdate;

    private int elapsedCycles;

    private float excessCycles;


    private boolean isPaused;


    public Clock(float cyclesPerSecond) {
        setCyclesPerSecond(cyclesPerSecond);
        reset();
    }


    public void setCyclesPerSecond(float cyclesPerSecond) {
        this.millisPerCycle = (1.0f / cyclesPerSecond) * 1000;
    }


    public void reset() {
        this.elapsedCycles = 0;
        this.excessCycles = 0.0f;
        this.lastUpdate = getCurrentTime();
        this.isPaused = false;
    }


    public void update() {
        //Get the current time and calculate the delta time.
        long currUpdate = getCurrentTime();
        float delta = (float)(currUpdate - lastUpdate) + excessCycles;

        //Update the number of elapsed and excess ticks if we're not paused.
        if(!isPaused) {
            this.elapsedCycles += (int)Math.floor(delta / millisPerCycle);
            this.excessCycles = delta % millisPerCycle;
        }

        //Set the last update time for the next update cycle.
        this.lastUpdate = currUpdate;
    }


    public void setPaused(boolean paused) {
        this.isPaused = paused;
    }


    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Checks to see if a cycle has elapsed for this clock yet. If so,
     * the number of elapsed cycles will be decremented by one.
     * @return Whether or not a cycle has elapsed.
     * @see peekElapsedCycle
     */
    public boolean hasElapsedCycle() {
        if(elapsedCycles > 0) {
            this.elapsedCycles--;
            return true;
        }
        return false;
    }

    /**
     * Checks to see if a cycle has elapsed for this clock yet. Unlike
     * {@code hasElapsedCycle}, the number of cycles will not be decremented
     * if the number of elapsed cycles is greater than 0.
     * @return Whether or not a cycle has elapsed.
     * @see hasElapsedCycle
     */
    public boolean peekElapsedCycle() {
        return (elapsedCycles > 0);
    }

    /**
     * Calculates the current time in milliseconds using the computer's high
     * resolution clock. This is much more reliable than
     * {@code System.getCurrentTimeMillis()}, and quicker than
     * {@code System.nanoTime()}.
     * @return The current time in milliseconds.
     */
    private static final long getCurrentTime() {
        return (System.nanoTime() / 1000000L);
    }

}