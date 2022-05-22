package pgdp.colony;
import static pgdp.MiniJava.*;
public class Genome {
    // Teilaufgabe 1.1: DNA
    // Constants
    private static final int LENGTH = 13; //length of the String dna
    private final String dna;
    // Constructors:
    public Genome(String dna){
        this.dna = dna;
    }

    // Teilaufgabe 1.2: Gene
    public Genome(){
        StringBuilder dna = new StringBuilder(LENGTH);
        for(int i=0; i<LENGTH; i++){
            switch(randomInt(0,3)){
                case 0: {
                    dna.append("A");
                    break;
                }
                case 1: {
                    dna.append("C");
                    break;
                }
                case 2: {
                    dna.append("G");
                    break;
                }
                case 3: {
                    dna.append("T");
                    break;
                }
            }
        }
        this.dna = dna.toString();
    }

    // Methods:
    public String toString(){ // ?
        return dna;
    }

    public static int similarity(Genome a, Genome b){
        int result = 0;
        for(int i=0; i<LENGTH;i++){
            if(a.toString().charAt(i)== b.toString().charAt(i))
                result++;
        }
        return result;
    }

    public static Genome combine(Genome mother, Genome father){
        StringBuilder babyDna = new StringBuilder(LENGTH);
        for(int i=0; i<LENGTH; i++){
            if(randomBoolean(1000)){
                switch(randomInt(0,3)){
                    case 0: {
                        babyDna.append("A");
                        break;
                    }
                    case 1: {
                        babyDna.append("C");
                        break;
                    }
                    case 2: {
                        babyDna.append("G");
                        break;
                    }
                    case 3: {
                        babyDna.append("T");
                        break;
                    }
                }
            } else {
                if(randomBoolean())
                    babyDna.append(mother.dna.charAt(i)); // mother.toString().charAt(i)?
                else
                    babyDna.append(father.dna.charAt(i));
            }
        }
        return new Genome(babyDna.toString());
    }

    public String getGene(int genePos, int geneLength){
        StringBuilder result = new StringBuilder(geneLength);
        for(int i=genePos; i<genePos+geneLength; i++){
            result.append(dna.charAt(i));
        }
        return result.toString();
    }

    public static int interpretGene(String gene){
        int result = 0;
        for(int i=0; i<gene.length(); i++){
            switch(gene.charAt(i)){
                case 'A':{
                    result += 0;
                    break;
                }
                case 'C':{
                    result += (int) (Math.pow(4, gene.length() - 1 - i));
                    break;
                }
                case 'G':{
                    result += 2 * (int) (Math.pow(4, gene.length() - 1 - i));
                    break;
                }
                case 'T':{
                    result += 3 * (int) (Math.pow(4, gene.length() - 1 - i));
                    break;
                }
            }
        }
        return result;
    }

    // Teilaufgabe 1.3: Gen-Interpretation

    public int lifespan(){
        return 8+interpretGene(getGene(0,2));
    }

    public int maxSize(){
        return 16+interpretGene(getGene(2,2));
    }

    public int skill(){
        return interpretGene(getGene(4,5));
    }

    public byte color(){
        return (byte)(interpretGene(getGene(9,3)));
    }

    public boolean isMale(){
        return interpretGene(getGene(12,1))%2 == 0;
    }
}
