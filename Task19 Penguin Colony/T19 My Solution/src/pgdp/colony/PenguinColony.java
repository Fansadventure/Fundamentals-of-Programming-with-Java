package pgdp.colony;

public class PenguinColony {
	// Constants
	static final int ADULT_AGE = 1;
	static final int DAYS_PER_YEAR = 5;
	private int time = 0; // this refers to the number of days in the past
	private PenguinList population =new PenguinList();  // sort the list from oldest to youngest
	// getters:
	public int getTime() {
		return time;
	}
	public PenguinList getPopulation() {
			return population;
	}
 	// Methods:
	public Penguin createPenguin(Genome genome) {
		Penguin newPenguin = new Penguin(genome,5);
		this.population.add(newPenguin);
		return newPenguin;
	}
	public void simulateDay(){
		time++;
		population.sort();
		// hunt and eat:
        for(int i=0; i<population.size();i++){
			population.get(i).hunt(population.size());
			population.get(i).eat();
		}
        // sleep:
        for(int i= population.size()-1;i>=0;i--){
        	if(!population.get(i).sleep())
				population.remove(i);
		}
        // mate:
        for(int i=population.size()-1; i>=0;i--){
        	Penguin currentPenguin = population.get(i);
			PenguinList temp = population.copy();
        	if(time%5==0 && currentPenguin.canMate() && !currentPenguin.getGenome().isMale()) {
        		// create a similarity array:
        		Penguin findMale;
				int [] similar = new int [population.size()];
				for(int j=0; j<similar.length;j++){
 					if(temp.get(j).getGenome().isMale() && temp.get(j).canMate()) { // is male & canMate
						findMale = temp.get(j);
						similar[j] = currentPenguin.checkSimilarity(findMale);
					} else {
						similar[j] = 14; // the penguin can't mate
					}
				}
				// find the index of the last minimum in the array, if there are more than one min values:
				int min = similar[0];
				int minIndex = 0;
				for(int k=1; k<similar.length;k++){
					if(similar[k]<=min) {
						min = similar[k];
						minIndex = k;
					}
				}
				if(min!=14)
					population.add(currentPenguin.mateWith(population.get(minIndex)));
        	}
        }
	}
}
