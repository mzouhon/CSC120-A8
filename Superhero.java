import java.util.ArrayList;

public class Superhero   {

    private String name; 
    private String alias;
    
    
    private double defaultSize;
    private double size; // in feet
    
    private double energyLevel;
    
    ArrayList<String> things;



    public Superhero( String name, String alias, double defaultSize){
        this.name=name;
        this.alias=alias;
        this.defaultSize=defaultSize;
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

        double costToWalk=1+(things.size()*0.05);

        if (this.energyLevel>=costToWalk){
            if((direction.toLowerCase().contains("north")) || (direction.toLowerCase().contains("south")) || (direction.toLowerCase().contains("east")) || (direction.toLowerCase().contains("west"))){
                energyLevel=energyLevel-costToWalk;
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

        double costToFly=(x+y)+(things.size()*(x+y)*(0.10));

        if (this.energyLevel>=costToFly){
            energyLevel=energyLevel-costToFly;
            System.out.println("You have flown "+ Math.sqrt((Math.pow(x,2))+(Math.pow(y,2))) + " miles.");
            System.out.println("Energy level: "+ energyLevel);
            return true;
        }else{
            System.out.println("You do not have enough energy to fly.");
            return false;
        }
    }

    public Number shrink(){
        if (this.size>=(1.0/16.0)*this.defaultSize){
            this.size=this.size*(0.5);
            System.out.println("New size: " + this.size+ " feet");
            return size;
        }else{
            System.out.println("Cannot shrink any further.");
            return size;
        }
    }

    public Number grow(){

        if(this.size<this.defaultSize){
            this.size=this.size*2;
            System.out.println("New size: " + this.size+ " feet.");
            return size;
        }else{
            System.out.println("You have reached your default size.");
            return size;
        }
    }

    public void rest(){
        if (energyLevel<100){
            System.out.println("Resting...");
        while (energyLevel<100){
            energyLevel++;
        
        }
        System.out.println("Your energy levels have been fully restored.");
    
    }else{
        System.out.println("You are already fully rested.");
    }
    }

    //dont forget to overwrite toString

    
    
    public static void main(String[] args){
        Superhero wanda= new Superhero("Wanda", "Scarlett Witch", 5.5);
        

        wanda.rest();
        wanda.fly(20,50);
        wanda.rest();


    
    }
    
}

