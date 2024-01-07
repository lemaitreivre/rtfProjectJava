public class Country {
    private final String name;
    private final String region;
    private final int happinessRank;
    private final double happinessScore;

    private final double standardError;
    private final double economy;
    private final double family;
    private final double health;
    private final double freedom;

    private final double trust;
    private final double generosity;
    private final double dystopiaResidual;

    public Country(String name, String region, int happinessRank, double happinessScore,
                   double standardError, double economy, double family, double health, double freedom,
                   double trust, double generosity, double dystopiaResidual) {
        this.name = name;
        this.region = region;
        this.happinessRank = happinessRank;
        this.happinessScore = happinessScore;
        this.standardError = standardError;
        this.economy = economy;
        this.family = family;
        this.health = health;
        this.freedom = freedom;
        this.trust = trust;
        this.generosity = generosity;
        this.dystopiaResidual = dystopiaResidual;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }
    public int getHappinessRank() {
        return happinessRank;
    }

    public double getHappinessScore() {
        return happinessScore;
    }


    public double getStandardError() {
        return standardError;
    }

    public double getEconomy() {
        return economy;
    }
    public double getFamily() {
        return family;
    }

    public double getHealth() {
        return health;
    }

    public double getFreedom() {
        return freedom;
    }

    public double getTrust() {
        return trust;
    }
    public double getGenerosity() {
        return generosity;
    }

    public double getDystopiaResidual() {
        return dystopiaResidual;
    }



}