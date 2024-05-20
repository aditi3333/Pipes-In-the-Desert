package PipeElement;

public class Pipe extends PipeElement {

    @Override
    public void breakPipeElement() {
        broken = true;
    }

    @Override
    public void fixPipeElement() {
        broken = false;
    }
}
