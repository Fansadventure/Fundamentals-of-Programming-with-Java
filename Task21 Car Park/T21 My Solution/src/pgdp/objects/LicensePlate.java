package pgdp.objects;

public class LicensePlate {
    // Attributes:
    private String regionalCode;
    private String letters;
    private int digits;
    // Constructor:
    public LicensePlate(String rc, String ltr, int dig){
        regionalCode = rc;
        letters = ltr;
        digits = dig;
    }
    // Methods:
    public String getRegionalCode() {
        return regionalCode;
    }

    public void setRegionalCode(String regionalCode) {
        this.regionalCode = regionalCode;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }
    public boolean isEqual(LicensePlate other){
        return regionalCode.equals(other.regionalCode) && letters.equals(other.letters) && digits == other.digits;
    }
    public String toString(){
        return regionalCode+":"+letters+" "+digits;
    }

}
