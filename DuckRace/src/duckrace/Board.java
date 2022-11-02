package duckrace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board {
    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    public void update(int id, Reward reward){
        DuckRacer racer = null;

        if(racerMap.containsKey(id)){//existing DuckRacer
             racer = racerMap.get(id);
        }else{ // not in amp so create new and put in map
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);
        }
        racer.win(reward);
    }

    public void show(){
        if(racerMap.isEmpty()){
            System.out.println("The board is currently empty");
        } else {
            Collection<DuckRacer> racers = racerMap.values();
            for (DuckRacer racer : racers) {
                System.out.println(racer);
            }
        }
    }

    //just to see if studentMapId was indeed correctly populated - will likely delete later
    void dumpStudentIdMap(){
        System.out.println(studentIdMap);
    }

    /*
     * Loads studentIdMap from conf/student-ids.csv
     * More accurately, it creates a Map<Interger, String>, populates it and returns it

     */
    private Map<Integer, String> loadStudentIdMap(){
        Map<Integer, String> idMap = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Path.of("conf/student-ids.csv"));
            //for each line we spilt it on the comma into two tokens
            for(String line : lines){
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                idMap.put(id,name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return idMap;
    }
}