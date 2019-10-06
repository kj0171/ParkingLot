package Pojo;

public class Vehicle {

    protected String registrationNumber;
    protected String color;

    //Default Constructor
    public Vehicle(){

    }

    //Parameterized Construcor
    public Vehicle(String registrationNumber , String color){
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    //Getters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}
