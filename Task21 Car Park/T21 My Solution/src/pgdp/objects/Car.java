package pgdp.objects;

public class Car {
    // Attributes:
    private String brand;
    private LicensePlate licensePlate;
    private int chassisNumber;
    private static int count=0;
    // Constructor:
    public Car(String br, LicensePlate lp){
        brand =br;
        licensePlate = lp;
        chassisNumber = count;
        count ++;
    }
    // Methods:
    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LicensePlate getlicensePlate() {
        return licensePlate;
    }
    public void setlicensePlate(LicensePlate licensePlate) {
        this.licensePlate = licensePlate;
    }
    public int getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(int chassisNumber) {
        this.chassisNumber = chassisNumber;
    }
    public String toString(){
        return "Auto " + chassisNumber + ": (Marke: " +
                brand + ", Kennzeichen: " + licensePlate +")";
    }

}
