/**
 * @author aidancarey
 */
class Count {

    int strikes;
    int balls;
    int swings = 0;
    int balls_in_play = 0;
    int singles = 0;
    int doubles = 0;
    int triples = 0;
    int home_runs = 0;
    int strikeouts_looking = 0;
    int strikeouts_swinging = 0;
    int walks = 0;
    int hit_by_pitches = 0;
    int sac_flies = 0;
    int fielders_choices = 0;
    int ground_outs = 0;
    int fly_outs = 0;
    int line_outs = 0;
    int hard_hit_balls = 0;

    /**
     * @param balls number of balls unique to this count
     * @param strikes number of strikes unique to this count
     */
     Count(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    /**
     * @return int
     */
    public int getStrikeouts() {
        return strikeouts_looking + strikeouts_swinging;
    }

    /**
     * @return int
     */
    public int getHits() {
        return singles + doubles + triples + home_runs;
    }

    /**
     * @return int
     */
    public int getABs() {
        return getHits() + getOuts();
    }

    /**
     * @return int
     */
    private int getOuts() {
        return fielders_choices + ground_outs + fly_outs + line_outs + getStrikeouts();
    }

    /**
     * @return int
     */
    public int getPAs() {
        return getABs() + walks + hit_by_pitches + sac_flies;
    }

    /**
     * @return double
     */
    public double getBattingAverage() {
        return (double) getHits() / getABs();
    }

    /**
     * @return double
     */
    public double getOnBasePercentage() {
        return (double) (getHits() + walks + hit_by_pitches) / (getPAs());
    }

    /**
     * @return double
     */
    public double getSluggingPercentage() {
        return (double) (singles + 2 * doubles + 3 * triples + 4 * home_runs) / (getPAs());
    }

    /**
     * @return double
     */
    public double getOPS() {
        return getOnBasePercentage() + getSluggingPercentage();
    }

    /**
     * @return double
     */
    public double getwOBA() {
        return (.69 * walks + .72 * hit_by_pitches + .89 * singles + 1.27 * doubles + 1.62 * triples + 2.10 * home_runs) / (getABs() + walks + hit_by_pitches);
    }

    /**
     * @return double
     */
    public double getHardHitRate() {
        return (double) hard_hit_balls / balls_in_play;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "AVF: " + getBattingAverage() +
                "\nOBP: " + getOnBasePercentage() +
                "\nSLG: " + getSluggingPercentage() +
                "\nOPS: " + getOPS() +
                "\nHard-hit rate: " + getHardHitRate() +
                "\nwOBA: " + getwOBA();
    }
}
