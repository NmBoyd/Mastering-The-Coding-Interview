/**
 * Reqire you to sketch out the classes and methods to implement technical 
 * problems or real-life objects. These problems give-or at least are believed to give-
 * an an interviewer insight into your coding style
 * 
 * Demonstrate you can create elegant, maintainable OO code.
 * 
 */

 /**
 * How to Approach Object-Oriented Design Questions
 * 
 * 1. Handle Ambiguity
 * Intentionally vague to test whether you will make assumptions or if you'll ask clarifying
 * questions. Ask: who is going to use it and how are they going to use it? Who, what, when,
 * where, how, and why?
 * 
 * 2. Define the Core Objects
 * Now that we understand what we're designing, we should consider what the "core objects"
 * in the system are. For example, for a restaraunt: Table, Guest, Party, Order, Meal, Employee,
 * Server, and Host
 * 
 * 3. Analyze Relationships
 * Find relationships many-to-many or one-to-many
 * - Party should have an Array of guests
 * - Server and Host inherit from Employee
 * - Each table has one Party, but each party may have multiple Tables
 * - There is one Host for the Restaurant
 * - Tables could have multiple Party's 
 * 
 * 4. Investigate Actions
 * Design key actions for your structure
 * - Party walks into Restaurant, and a Guest requests a Table from the Host. The
 * Host looks up the reservation and, if it exists, assigns the Party to a Table. 
 * Otherwise, the Party is added to the end of the list. When the Party leaves, the 
 * Table is freed and assigned to a new Party in the list
 */

 /**
  * Design Patterns
 */

 /**
  * Singleton Class
  * Ensures that a class has only one instance and ensures access to he instance throuhg
  * the application. It can be useful in cases where you have a "global" object with 
  * exactly one instance. For example, we may want to implement Restaurant such that
  * it has exactly one Restaurant instance
  */
  public class Restaurant {
      private static Restaurant _instance = null;
      public static Restaurant getInstance() {
          if (_instance == null) {
              _instance = new Restaurant();
          }
          return _instance;
      }
  }

  /**
   * Factory Method
   * The Factory Method offers an interface for creating an instance of a class, with its 
   * subclass deciding which class to instantiate. You might want to implement this with 
   * the creator class being abstract and not providing an implementation for the Factory 
   * method. Or, you could have the Creator class be a concrete class that provides an 
   * implementation for the Factory method. 
   */
public class CardGame {
    public static CardGame createCardGame(GameType type) {
        if (type == GameType.Poker) {
            return new PokerGame();
        }
        else if (type == GameType.BlackJack) {
            return new BlackJackGame();
        }
        return null;
    }
}