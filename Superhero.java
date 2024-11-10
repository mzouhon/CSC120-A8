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

    public boolean walk(String direction){

        if (this.energyLevel>=energyLevel-1-(things.size()*0.5)){
            if((direction.toLowerCase().contains("north")) || (direction.toLowerCase().contains("south")) || (direction.toLowerCase().contains("east")) || (direction.toLowerCase().contains("west"))){
                energyLevel=energyLevel-1-(things.size()*0.5);
                System.out.println("You are currently walking "+ direction + ".");
                System.out.println("Energy level: "+ energyLevel);
                return true;
            }else{
                System.out.println("You can only walk north, south, east, or west.");
                return false;
            }
        }else{
            System.out.println("You do not have enough energy to walk. Try resting or removing things from your inventory first.");
            return false;
        }

    }

    public boolean fly(int x, int y){

        if (this.energyLevel>=energyLevel-(x+y)-(things.size()*(x*y)*(0.25))){
            energyLevel=energyLevel-(x+y)-(things.size()*(x*y)*(0.25));
            System.out.println("You have flown "+ Math.sqrt(x^2+y^2) + " miles.");
            System.out.println("Energy level: "+ energyLevel);
            return true;
        }else{
            System.out.println("You do not have enough energy to fly. Try resting or removing things from your inventory first.");
            return false;
        }
    }

    public Number shrink(){
        if (this.size>(1/16)*this.defaultSize){
            this.size=this.size*(1/2);
            System.out.println("New size: " + this.size+ " feet");
            return size;
        }else{
            System.out.println("Cannot shrink any further.");
            return size;
        }
    }
    
    public static void main(String[] args){





    
    }
    
}

