package PipeElement;

public abstract class PipeElement {
    boolean broken = false;

    public boolean getBrokenStatus()
    {
        return broken;
    }
    public abstract void breakPipeElement();
    public abstract void fixPipeElement();
}
