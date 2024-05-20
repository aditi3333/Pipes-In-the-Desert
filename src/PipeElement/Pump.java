package PipeElement;

public class Pump extends ActiveElement {

    @Override
    public void breakPipeElement() {
        broken = true;
    }

    @Override
    public void fixPipeElement() {
        broken = false;
    }
}
