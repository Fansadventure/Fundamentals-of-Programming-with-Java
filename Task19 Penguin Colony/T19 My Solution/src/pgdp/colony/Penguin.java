package pgdp.colony;

import static pgdp.MiniJava.*;

public class Penguin {
    // Teilaufgabe 2.1: Pinguin-Attribute:
    //Constants
    static final int MAX_HEALTH = 50;
    private final String name;
    private final Genome genome;
    private int ageInDays;
    private int size;
    private int health;
    private int numFish;  // static??
    private Penguin child;

    // Getters:
    public String getName() {
        return name;
    }

    public Genome getGenome() {
        return genome;
    }

    public int getAgeInDays() {
        return ageInDays;
    }

    public int getAge() {
        return ageInDays/5;
    }

    public int getSize() {
        return size;
    }

    public int getHealth() {
        return health;
    }

    public int getNumFish() {
        return numFish;
    }

    public Penguin getChild() {
        return child;
    }

    public String getGender() {
        if(this.getGenome().isMale())
            return "M";
        else
            return "F";
    }

    // Teilaufgabe 2.2: Pinguin-Konstruktoren
    public Penguin(Penguin mother, Penguin father){
        name = generateName();
        genome = Genome.combine(mother.getGenome(),father.getGenome());
        ageInDays = 0;
        size = genome.maxSize()/2;
        health = MAX_HEALTH;
        numFish = 0;
        child = null;
    }

    public Penguin(Genome genome, int ageInDays){
        name = generateName();
        this.genome = genome;
        this.ageInDays = ageInDays;
        size = genome.maxSize()/2;
        health = MAX_HEALTH;
        numFish = 0;
        child = null;
    }

    // Teilaufgabe 2.3: Pinguin-Liebe:
    public boolean canMate(){
        return child == null && health >=25 && ageInDays>=5;
    }

    public int checkSimilarity(Penguin partner){
        return Genome.similarity(this.getGenome(), partner.getGenome());
    }

    public Penguin mateWith(Penguin male){
        Penguin child = new Penguin(this, male);
        this.child = child;
        male.child = child;
        return child;
    }

    // Teilaufgabe 2.4: Pinguin-Alltag:
    public int hunt(int competition){
        int result = size/2 + randomInt(this.getGenome().skill()/2,this.getGenome().skill())/competition;
        numFish += result;
        return result;
    }

    public void eat(){   // do some self tests !!!
        if(this.getChild() != null) {
            child.numFish += this.getNumFish()/4;
            this.numFish -= this.getNumFish()/4;
        }
        if(this.getNumFish() >= this.getSize()) {
            this.numFish -= this.getSize();
            if(MAX_HEALTH-this.health > this.getNumFish()){
                this.health += this.getNumFish();
                this.numFish = 0;
            } else {
                this.numFish -= (MAX_HEALTH-this.health);
                this.health = MAX_HEALTH;
                if(this.getNumFish()>= (this.getGenome().maxSize()-this.getSize())){
                    this.numFish -= (this.getGenome().maxSize()-this.getSize());
                    this.size = this.getGenome().maxSize();
                } else {
                    this.size += this.getNumFish();
                    this.numFish = 0;
                }
            }
        } else {
            health -= (this.getSize() - this.getNumFish());
            this.numFish = 0;
        }
    }

    public boolean sleep(){
        boolean alive = true;
        if(this.child!=null){
            if(this.child.ageInDays>=5 || this.child.getHealth() <=0
                    ||this.child.getAgeInDays()>this.child.getGenome().lifespan())
                this.child = null;
        }
        if(this.ageInDays+1 <= this.getGenome().lifespan() && this.health>0){
            this.ageInDays ++;
        } else {
            alive = false;
            this.health = 0;
        }
        return alive;
    }

    public String toString(){
        String childName;
        if(getChild() == null)
            childName = "none";
        else
            childName = getChild().getName();

        StringBuilder info = new StringBuilder();
        info.append(getName()+" ("+getAge()+getGender()+"): DNA="+getGenome()+"; Health="+getHealth()+"; " +
                "Size="+getSize()+"/"+getGenome().maxSize()+"; Lifespan="+getGenome().lifespan()+"; Skill=" +
                getGenome().skill()+"; Num Fish="+getNumFish()+"; Color="+getGenome().color()+"; Child="+childName+";");
        return info.toString();
    }
}
