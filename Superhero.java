import java.util.ArrayList;

public class Superhero implements Contract {

    private String name; 
    private String alias;
    
    private double maxSpeed;
    private double speed; // in meters per second
    
    private double defaultSize;
    private double size; // in feet
    
    private double energyLevel;
    
    ArrayList<String> things;



    public Superhero( String name, String alias, double maxSpeed, double defaultSize){
        this.name=name;
        this.alias=alias;
        this.maxSpeed=maxSpeed;
        this.defaultSize=defaultSize;

        this.speed=0;
        this.size=defaultSize;
        this.energyLevel=100.0;
        this.things= new ArrayList<>();
        
    }
    
    public String getName(){
        return this.name;
    }

    public String getAlias(){
        return this.alias;
    }

    public double getMaxSpeed(){
        return this.maxSpeed;
    }

    public double getSpeed(){
        return this.speed;
    }

    public double getDefaultSize(){
        return this.defaultSize;
    }

    public double getSize(){
        return this.size;
    }

    public double getEnergyLevel(){
        return energyLevel;
    }


    public void grab(String item){
        this.things.add(item);
        System.out.println("You have added " + item + " to your inventory.");
    }

    public String drop(String item){
        if (this.things.contains(item)){
        this.things.remove(item);
        return item;
        }else{
            System.out.println("Your "+ item + " could not be found in your inventory.");
            return item;
        }
    }

    public void examine(String item){
        if (this.things.contains(item)){
            System.out.println("This item is part of your inventory.");
        }else{
            System.out.println("This item is not part of your inventory.");
        }
    }

    public void use(String item){
        if((energyLevel>=20) && (this.things.contains(item))){
            energyLevel=energyLevel-20;
            System.out.println("You have sucessfully used your "+ item + ".");
            System.out.println("Energy level: "+ energyLevel);
            this.drop(item);
    }else if((energyLevel<20)&& (this.things.contains(item))){
        System.out.println("You do not have enough energy to use your " + item + ".");

    }else if (!this.things.contains(item)) {
        System.out.println("This item cannot be found in your inventory."); 
    }
    }
    
    public static void main(String[] args){





    
    }
    
}

