package poke;

public class Pokemon {
    private String id;
    private String name;
    private double weight;

    private Pokemon nextEvolution;
    private Pokemon prevEvolution;

    public Pokemon(String id, String name, double weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Pokemon(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setNextEvolution(Pokemon nextEvolution) {
        this.nextEvolution = nextEvolution;
    }

    public void setPrevEvolution(Pokemon prevEvolution) {
        this.prevEvolution = prevEvolution;
    }

    public boolean isThisPokemonHeavy() {
        return weight > 10.0;
    }

    public boolean isFirstEvolution() {
        return prevEvolution == null;
    }

    public boolean isLastEvolution() {
        return nextEvolution == null;
    }
}