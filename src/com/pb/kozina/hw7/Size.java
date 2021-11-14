package com.pb.kozina.hw7;

public enum Size {
    XXS("Детский размер", 32),
    XS("Взрослый размер", 34),
    S("Взрослый размер", 36),
    M("Взрослый размер", 38),
    L("Взрослый размер", 40);

    private String Description;
    private int EuroSize;

    Size(String Description, int EuroSize) {
       this.Description = Description;
       this.EuroSize = EuroSize;
    }

    public String getDescription() {
        return Description;
    }

    public int getEuroSize() {
        return EuroSize;
    }
    
    @Override
    public String toString() {
        return  Description + " " + EuroSize;
    }
}
