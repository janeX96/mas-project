package mas.masproject.models;

public class StringedInstrument extends Instrument{
    private int countOfStrings;
    private boolean bowIncluded;

    public StringedInstrument(double prize, String name, String producer, boolean electronic) {
        super(prize, name, producer, electronic);
    }



}
