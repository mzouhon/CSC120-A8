import java.util.ArrayList;

/**
 * class represents a superhero that can walk, fly, shrink, grow, and use different tools and gadgets
 */
public class Superhero implements Contract {

  private String name;
  private String alias;

  private double defaultHeight;
  private double height; // in feet

  private double energyLevel;

  private ArrayList < String > inventory;

  private String lastItemUsed;
  private boolean oneChance;

  /**
   * creates an instance of a superhero that has a name, alias, and default height, and sets other important attributes to default values
   * 
   * @param name name of superhero
   * @param alias alias of superhero
   * @param defaultHeight default height of superhero
   */
  public Superhero(String name, String alias, double defaultHeight) {
    this.name = name;
    this.alias = alias;
    this.defaultHeight = defaultHeight;
    this.height = defaultHeight;
    this.energyLevel = 100.0;
    this.inventory = new ArrayList < > ();
    this.oneChance = false;
    this.lastItemUsed = null;
  }

  /**
   * returns name of superhero
   * 
   * @return name of superhero
   */
  public String getName() {
    return this.name;
  }

  /**
   * returns alias of superhero
   * 
   * @return alias of superhero
   */
  public String getAlias() {
    return this.alias;
  }

  /**
   * returns default height of superhero
   * 
   * @return defualt height of superhero
   */
  public double getDefaultHeight() {
    return this.defaultHeight;
  }

  /**
   * returns current height of superhero
   * 
   * @return current height of superhero
   */
  public double getHeight() {
    return this.height;
  }

  /**
   * returns energy level of superhero
   * 
   * @return energy level of superhero
   */
  public double getEnergyLevel() {
    return energyLevel;
  }

  /**
   * adds an item to the superhero's inventory
   * 
   * @param item item that is being added to the inventory
   */
  public void grab(String item) {
    this.inventory.add(item);
    System.out.println("You have added " + item + " to your inventory.");
  }

  /**
   * removes an item from the superhero's inventory if it is present
   * 
   * @param item item is being removed from the inventory
   * 
   * @return string of item removed/item attempting to be removed
   */
  public String drop(String item) {
    if (this.inventory.contains(item)) {
      this.inventory.remove(item);
      return item;
    } else {
      System.out.println("Your " + item + " could not be found in your inventory.");
      return item;
    }
  }

  /**
   * checks if an item can be found in the superhero's inventory
   * 
   * @param item item being checked against superhero's inventory
   */
  public void examine(String item) {
    if (this.inventory.contains(item)) {
      System.out.println("This item is part of your inventory.");
    } else {
      System.out.println("This item is not part of your inventory.");
    }
  }

  /**
   * uses an item from the superhero's inventory if present, decreases energy level accordingly, and removes item from inventory
   * 
   * @param item item attempting to be used
   */
  public void use(String item) {
    if ((energyLevel >= 20) && (this.inventory.contains(item))) {
      energyLevel = energyLevel - 20;
      System.out.println("You have sucessfully used your " + item + ".");
      System.out.println("Energy level: " + energyLevel);
      lastItemUsed = item;
      this.drop(item);
    } else if ((energyLevel < 20) && (this.inventory.contains(item))) {
      System.out.println("You do not have enough energy to use your " + item + ".");

    } else if (!this.inventory.contains(item)) {
      System.out.println("This item cannot be found in your inventory.");
    }
  }

  /**
   * undoes the use of the last item used by the superhero upon first use of this method (restores energy level as well), denies the request otherwise
   */
  public void undo() {
    if ((this.oneChance == false) && (lastItemUsed != null)) {
      this.inventory.add(lastItemUsed);
      energyLevel = energyLevel + 20;
      oneChance = true;
      System.out.println("You have sucessfully gone back in time and undid your last action using your " + lastItemUsed + ". Your " + lastItemUsed + " has been returned to your inventory and your energy level has been restored.");
    } else if (lastItemUsed == null) {
      System.out.println("In order to go back in time and undo an action using an item, you must first use an item.");
    } else {
      System.out.println("You have already used your one chance to go back in time and undo your last action.");
    }
  }

  /**
   * allows superhero to walk in a specific direction if they have enough energy, decreases energy level accordingly
   * 
   * @param direction direction that superhero id attempting to walk
   * 
   * @return true if a logical direction is taken as a parameter and superhero has enough energy, returns false otherwise
   */
  public boolean walk(String direction) {

    double costToWalk = 1 + (inventory.size() * 0.05);

    if (this.energyLevel >= costToWalk) {
      if ((direction.toLowerCase().contains("north")) || (direction.toLowerCase().contains("south")) || (direction.toLowerCase().contains("east")) || (direction.toLowerCase().contains("west"))) {
        energyLevel = energyLevel - costToWalk;
        System.out.println("You are currently walking " + direction + ".");
        System.out.println("Energy level: " + energyLevel);
        return true;
      } else {
        System.out.println("You can only walk north, south, east, or west.");
        return false;
      }
    } else {
      System.out.println("You do not have enough energy to walk. Try resting or removing things from your inventory first.");
      return false;
    }
  }

  /**
   * allows superhero to fly a specified distance if they have enough energy, decrease energy level accordingly
   * 
   * @param x distance in the x direction
   * @param y distance in the y direction
   * 
   * @return true if superhero has enough energy, false otherwise
   */
  public boolean fly(int x, int y) {

    double costToFly = (x + y) + (inventory.size() * (x + y) * (0.10));

    if (this.energyLevel >= costToFly) {
      energyLevel = energyLevel - costToFly;
      System.out.println("You have flown " + Math.sqrt((Math.pow(x, 2)) + (Math.pow(y, 2))) + " miles.");
      System.out.println("Energy level: " + energyLevel);
      return true;
    } else {
      System.out.println("You do not have enough energy to fly.");
      return false;
    }
  }

  /**
   * shrinks height of superhero if they are bigger than 1/16 of their default height
   * 
   * @return height of superhero
   */
  public Number shrink() {
    if (this.height > (1.0 / 16.0) * this.defaultHeight) {
      this.height = this.height * (0.5);
      System.out.println("New height: " + this.height + " feet");
      return height;
    } else {
      System.out.println("Cannot shrink any further.");
      return height;
    }
  }

  /**
   * increases height of superhero if they are smaller than their default height
   * 
   * @return height of superhero
   */
  public Number grow() {

    if (this.height < this.defaultHeight) {
      this.height = this.height * 2;
      System.out.println("New height: " + this.height + " feet.");
      return height;
    } else {
      System.out.println("You have reached your default height.");
      return height;
    }
  }

  /**
   * returns energy level of superhero to 100 if less than 100
   */
  public void rest() {
    if (energyLevel < 100) {
      System.out.println("Resting...");
      while (energyLevel < 100) {
        energyLevel++;

      }
      System.out.println("Your energy levels have been fully restored.");

    } else {
      System.out.println("You are already fully rested.");
    }
  }

  /**
   * prints inventory of superhero
   */
  public void printInventory() {
    if (inventory.size() > 0) {
      System.out.println();
      System.out.println("Current Inventory: ");
      for (String thing: inventory) {
        System.out.println(thing);
      }
      System.out.println();
    } else {
      System.out.println("Your inventory is currently empty.");
    }
  }

  /**
   * returns a string representation of the superhero object
   * 
   * @returns a string representation of the superhero object
   */
  public String toString() {
    return ("\n----------------------------------------\nName: " + name + "\nAlias: " + this.alias + "\nHeight: " + height + " feet" + "\nCurrent Energy Level: " + this.energyLevel + "\nHas gone back in time: " + oneChance + "\n----------------------------------------\n");
  }
}