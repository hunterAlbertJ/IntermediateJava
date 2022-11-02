package duckrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    //instance variables or fields
    private final int id;
    private String name;
    private final List<Reward> rewards = new ArrayList<>();

    //constructors
    public DuckRacer(int id, String name){
        this.id = id;
        setName(name);
    }

    //action methods
    public void win(Reward reward){
        rewards.add(reward);
    }

    //accessor methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins(){
        return rewards.size();
    }

    //NOTE: we are returning an internal reference to our internal list
    //we should return a read-only view of the internal List<Reward>
    public List<Reward> getRewards(){
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String toString(){
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s",
                getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());

    }
}