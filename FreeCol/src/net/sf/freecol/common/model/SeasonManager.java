package net.sf.freecol.common.model;

/**
 * Manages the current season and applies seasonal effects
 * on production for the new feature.
 */
public class SeasonManager {

    public enum Season {
        SPRING, SUMMER, FALL, WINTER
    }

    private Season currentSeason;

    public SeasonManager() {
        this.currentSeason = Season.SPRING; // Start at Spring
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }

    /**
     * Advance to the next season.
     * SPRING → SUMMER → FALL → WINTER → SPRING
     */
    public void advanceSeason() {
        switch (currentSeason) {
            case SPRING:
                currentSeason = Season.SUMMER;
                break;
            case SUMMER:
                currentSeason = Season.FALL;
                break;
            case FALL:
                currentSeason = Season.WINTER;
                break;
            case WINTER:
                currentSeason = Season.SPRING;
                break;
        }
    }

    /**
     * Apply seasonal production effects.
     * @param base Amount before modifiers
     * @param s Season to apply modifier for
     */
    public int applySeasonalModifier(int base, Season s) {
        switch (s) {
            case SPRING:
                return (int)(base * 1.0);  // Slight boost
            case SUMMER:
                return (int)(base * 1.2);  // Highest production
            case FALL:
                return (int)(base * 0.9);  // Small decrease
            case WINTER:
                return (int)(base * 0.6);  // HARSH penalty
            default:
                return base;
        }
    }
}

