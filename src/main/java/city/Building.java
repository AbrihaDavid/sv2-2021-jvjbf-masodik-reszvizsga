package city;

public abstract class Building {

    private long area;
    private int levels;
    private Address address;

    public Building(long area, int levels, Address address) {
        this.area = area;
        this.levels = levels;
        this.address = address;
    }

    public Building(long area, Address address) {
        this.area = area;
        this.address = address;
        levels = 1;
    }

    public long getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }

    public long getFullArea(){
        return getLevels()*getArea();
    }

    abstract int calculateNumberOfPeopleCanFit();
}
