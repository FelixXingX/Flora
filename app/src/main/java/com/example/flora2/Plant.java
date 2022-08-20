package com.example.flora2;

public class Plant {

    // Instance Variables
    private int daysPerWater;  // A constant variable that doesnt change, daysUntilWater will reset to this number
    private int daysUntilWater;  // A countdown variable
    private String plantName;
    private String plantType;
    private int plantAge;

    // Constructors
    public Plant(String plantName, String plantType, String daysPerWater) {
        this.plantName = plantName;
        this.plantType = plantType;
        this.daysPerWater = Integer.parseInt(daysPerWater);
        this.daysUntilWater = this.daysPerWater;
        this.plantAge = 0;
    }

    public Plant (String plantType){
        this.plantType = plantType;
    }

    // Add plant age
    public void addPlantAge(int plantAge){
        this.plantAge = plantAge + 1;
    }

    //Subtract days until plant needs to be watered
    public void subtractDaysUntilWater(int daysUntilWater){
        this.daysUntilWater = daysUntilWater - 1;
    }

    // Getter Methods

    public int getDaysUntilWater(){
        return daysUntilWater;
    }

    public int getDaysPerWater(){
        return daysPerWater;
    }

    public String getPlantName(){
        return plantName;
    }

    public String getPlantType(){
        return plantType;
    }

    public int getPlantAge(){
        return getPlantAge();
    }

    // Setter Methods

    public void setDaysPerWater(int daysPerWater){
        this.daysPerWater = daysPerWater;
    }

    public void setDaysUntilWater(int daysUntilWater){
        this.daysPerWater = daysUntilWater;
    }

    public void setPlantName(String plantName){
        this.plantName = plantName;
    }

    public void setPlantType(String plantType){
        this.plantType = plantType;
    }

    public void setPlantAge(int plantAge){
        this.plantAge = plantAge;
    }
}
