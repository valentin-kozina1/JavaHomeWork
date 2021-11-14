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


    public String getDescription(String size) {
        switch (size){
            case "XXS": Description = "Детский размер";
            case "XS":
            case "S":
            case "M":
            case "L": Description = "Взрослый размер";
            default:  Description = "Нет такого размера";
        }
        return Description;
    }


    public int getEuroSize(String size) {
        switch (size){
            case "XXS": EuroSize = 32; break;
            case "XS": EuroSize =  34; break;
            case "S": EuroSize =  36; break;
            case "M": EuroSize =  38; break;
            case "L": EuroSize =  40; break;
        }
        return EuroSize;
    }

    @Override
    public String toString() {
        return  Description + " " + EuroSize;
    }
}
