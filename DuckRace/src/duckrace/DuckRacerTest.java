package duckrace;
import java.util.List;

import static duckrace.Reward.*;

class DuckRacerTest {
    public static void main(String[] args) {
        //create a DuckRacer object
        DuckRacer racer3 = new DuckRacer(3, "Chris");

        System.out.println(racer3);//toString automatically called

        //make it win
        racer3.win(PRIZES);
        racer3.win(PRIZES);
        racer3.win(DEBIT_CARD);
        System.out.println(racer3);

        //lets find out what the rewards are for this DuckRacer Object
        List<Reward> rewards = racer3.getRewards();
        System.out.println(rewards);

        racer3.win(DEBIT_CARD);
        racer3.win(DEBIT_CARD);
        System.out.println(rewards);

    }
}