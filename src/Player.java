/**
 * @author aidancarey
 */
class Player {

    String name;
    Count zero_zero = new Count(0, 0);
    Count zero_one = new Count(0, 1);
    Count zero_two = new Count(0, 2);
    Count one_zero = new Count(1, 0);
    Count one_one = new Count(1, 1);
    Count one_two = new Count(1, 2);
    Count two_zero = new Count(2, 0);
    Count two_one = new Count(2, 1);
    Count two_two = new Count(2, 2);
    Count three_zero = new Count(3, 0);
    Count three_one = new Count(3, 1);
    Count three_two = new Count(3, 2);
    Count[][] counts = {{zero_zero, zero_one, zero_two}, {one_zero, one_one, one_two}, {two_zero, two_one, two_two}, {three_zero, three_one, three_two}};

    /**
     * @param playerName name of the player
     */
    Player(String playerName) {
        this.name = playerName;
    }


}
