package pgdp.objects;

public class CarPark {
    // Attribute:
    private Car [] spaces;
    // Contructor:
    public CarPark(int n){
        spaces = new Car[n];
    }
    // Methods:
    public Car[] getSpaces() {
        return spaces;
    }

    public void setSpaces(Car[] spaces) {
        this.spaces = spaces;
    }
    public int park(Car c){
        int result=-1;
        for(int i=0;i<spaces.length;i++){
            if(spaces[i]==null) {
                spaces[i] = c;
                result = i;
                break;
            }
        }
        return result;
    }
    public int search(LicensePlate lp){
        int result = -1;
        for(int i=0;i<spaces.length;i++){
            if(spaces[i].getlicensePlate().isEqual(lp)){
                result=i;
            }
        }
        return result;
    }
    public Car driveOff(LicensePlate lp){
        int index = search(lp);
        if(index==-1)
            return null;
        else {
            Car c = spaces[index];
            spaces[index] = null;
            return c;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Parkhaus:\n");
        for(int i=0;i<spaces.length;i++){
            sb.append(i + ": [");
            if(spaces[i]!=null)
                sb.append(spaces[i] +"]\n");
            else
                sb.append("]\n");
        }
        return sb.toString();
    }


}
