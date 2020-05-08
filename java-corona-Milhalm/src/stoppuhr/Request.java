package stoppuhr;

/**
 *
 * @author lukasmilhalm
 */
class Request {

    private boolean master;
    private boolean start;
    private boolean stop;
    private boolean clear;
    private boolean end;

    public boolean isMaster() {
        return master;
    }

    boolean isStart() {
        return start;
    }

    boolean isClear() {
        return clear;
    }

    boolean isStop() {
        return stop;
    }

    boolean isEnd() {
        return end;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
