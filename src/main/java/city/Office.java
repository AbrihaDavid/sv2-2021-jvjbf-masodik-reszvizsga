package city;

public class Office extends Building {

    private String company;
    private int numberOfTablesPerLevel;

    public Office(long area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        if (numberOfTablesPerLevel * 2L >= area || numberOfTablesPerLevel*5L <= area){
            throw new IllegalArgumentException();
        }
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;

    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }

    @Override
    int calculateNumberOfPeopleCanFit() {
        return (getLevels()-1)*getNumberOfTablesPerLevel();
    }

    @Override
    public long getFullArea() {
        return getLevels()*getArea();
    }
}
