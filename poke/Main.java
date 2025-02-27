package poke;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            FileReader reader = new FileReader("src/pokedex.json");
            JSONParser parser = new JSONParser();

            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            JSONArray jsonArray = (JSONArray) jsonObject.get("pokemon");

            for (int i = 0; i < jsonArray.size(); i++){
                JSONObject currentPokemon = (JSONObject) jsonArray.get(i);
    
                String weightOfPoke = (String) currentPokemon.get("weight");
    
                String weightValue = weightOfPoke.split(" ") [0];
    
                double weightOfPokeDOUBLE = Double.parseDouble(weightValue);

                Pokemon myPokemon = new Pokemon((String) currentPokemon.get("num"),(String) currentPokemon.get("name"),weightOfPokeDOUBLE);
                
                if (currentPokemon.containsKey("next_evolution")) {
                    JSONArray nextEvolutions = (JSONArray) currentPokemon.get("next_evolution");

                    JSONObject firstEvolution = (JSONObject) nextEvolutions.get(0);

                    Pokemon myNextPokemon = new Pokemon((String) firstEvolution.get("num"), (String) firstEvolution.get("name"));
                    
                    //System.out.println(myPokemon.getName() + " -> " + myNextPokemon.getName());

                    myPokemon.setNextEvolution(myNextPokemon);
                }
            
                if (myPokemon.isThisPokemonHeavy()) {
                    //System.out.println(myPokemon.getName() + " : " + myPokemon.getWeight() + " kg");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void displayHeavyPoke(JSONArray jsonArray) {
        
    }
}
