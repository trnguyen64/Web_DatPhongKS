package model;

public class Room {
    private String ID, Name, Type;
    private int NumberBed;
    private float Price;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public int getNumberBed() {
        return NumberBed;
    }

    public void setNumberBed(int NumberBed) {
        this.NumberBed = NumberBed;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    
}
