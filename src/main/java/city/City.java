package city;

import java.util.ArrayList;
import java.util.List;

public class City {

    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void addBuilding(Building building) {
        long areaOfBuildings = 0;
        for (Building b : buildings) {
            areaOfBuildings += b.getArea();
        }
        if (areaOfBuildings + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than " + getFullArea());
        }
    }

    public Building findHighestBuilding(){
        Building highestBuilding = null;

        for (Building b: buildings){
            if (highestBuilding == null || b.getLevels() > highestBuilding.getLevels()){
                highestBuilding = b;
            }
        }
        return highestBuilding;
    }

    public List<Building> findBuildingsByStreet(String street){
        List<Building> listOfBuildingsInSameStreet = new ArrayList<>();

        for (Building b : buildings){
            if(street.equals(b.getAddress().getStreet())){
                listOfBuildingsInSameStreet.add(b);
            }
        }
        return listOfBuildingsInSameStreet;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for (Building b: buildings){
            if (b.calculateNumberOfPeopleCanFit() > numberOfPeople){
                return true;
            }
        }
        return false;
    }

}
