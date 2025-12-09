//src/net/sf/freecol/common/model/SeasonManager.java
package net.sf.freecol.common.model;


 //Manages the current season and how often it changes.
 //Provides a simple production multiplier based on the season.

public class SeasonManager {

    private Season currentSeason;
    private int turnsPerSeason;
    private int turnsElapsed;

    
      //Create a SeasonManager.
     
     // param startingSeason the initial season
      //param turnsPerSeason number of turns each season lasts; must be > 0
     
    public SeasonManager(Season startingSeason, int turnsPerSeason) {
        if (turnsPerSeason <= 0) {
            throw new IllegalArgumentException("turnsPerSeason must be > 0.");
        }
        this.currentSeason = startingSeason;
        this.turnsPerSeason = turnsPerSeason;
        this.turnsElapsed = 0;
    }

    // Get the current season. @return the current Season
  
    public Season getCurrentSeason() {
        return currentSeason;
    }

    // Advance the turn counter and change the season when needed.
     
    public void advanceTurn() {
        turnsElapsed++;
        if (turnsElapsed >= turnsPerSeason) {
            currentSeason = currentSeason.next();
            turnsElapsed = 0;
        }
    }

    
     //Get a multiplier to apply to production based on the current season.
     //@return a double multiplier
     
    public double getProductionMultiplier() {
        switch (currentSeason) {
            case WINTER:
                return 0.8;
            case SPRING:
                return 1.1;
            case AUTUMN:
                return 1.05;
            case SUMMER:
            default:
                return 1.0;
        }
    }
}
