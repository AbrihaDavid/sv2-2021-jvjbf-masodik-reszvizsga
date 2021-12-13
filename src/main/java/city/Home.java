package city;

public class Home extends Building {

    public static final int SQUARE_METERS_NEED_PER_PERSON = 20;

    public Home(long area, int levels, Address address) {
        super(area, levels, address);
        if (levels >= 3){
            throw new IllegalArgumentException();
        }
    }

    public Home(long area, Address address) {
        super(area, address);
    }

    @Override
    int calculateNumberOfPeopleCanFit() {
        return (int) getArea()/SQUARE_METERS_NEED_PER_PERSON*getLevels();
    }
}
