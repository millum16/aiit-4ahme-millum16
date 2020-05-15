package stoppuhr;

/**
 *
 * @author lukasmilhalm
 */
public class Response {

    private boolean master;
    private long count;
    private boolean run;
    private long time;

    public Response(boolean master, long count, boolean run, long time) {
        this.master = master;
        this.count = count;
        this.run = run;
        this.time = time;
    }

    public boolean isMaster() {
        return master;
    }

    public boolean isRunning() {
        return run;
    }

    public long getCount() {
        return count;
    }

    public boolean isRun() {
        return run;
    }

    public long getTime() {
        return time;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
