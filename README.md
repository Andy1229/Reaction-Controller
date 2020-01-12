# Reaction-Controller

## Problems

### Exercise 1 Simple Reaction Controller
Imagine that you have been hired by an electronics company to build the software for a simple Reaction-Timer game.\
The reaction timer has two inputs: a coin-slot that starts the game and a go/stop button that controls it.\
There is also a display that indicates to the player what he/she should do next. The machine behaves as follows.

* Initially, the display shows “Insert coin”, and the machine waits for a player to do so. • When the player inserts a coin, the machine displays “Press GO!” and waits for the player to do so.
* When the player presses the go/stop button, the machine displays “Wait...” for a random time between 1.0 and 2.5 seconds. After the random delay expires, the machine displays a time-value that increments every 10 milliseconds, starting at zero. The player must now press the go/stop button as soon as possible – the goal of the game is to show fast reactions! If the player presses the go/stop button during the random delay period, i.e. the player tries to “guess” when the delay will expire, the machine aborts the game and immediately demands another coin. To put it simply, there is no reward for trying to cheat! If the user has not pressed stop after two seconds, the machine will stop automatically – no living person could be that slow!
* Whether the player has pressed the go/stop button within the two seconds waiting time period or not, the machine displays the final timer value for three seconds, then the game is over until another coin is inserted. If the player presses the go/stop button while the measured reaction time is being displayed, the machine immediately displays “Insert coin”.

### Exercise 2 Enhanced Reaction Controller
After showing the basic reaction timer machine to potential customers, the marketing department has found that some of them would like to pay more for a deluxe reaction timer that allows multiple games after payment of a single coin.\
In this machine, when a coin is inserted, the player is allowed to play three games.\
The operating sequence is very similar to the previous one: insert coin, press the go/stop button, wait random delay, press the go/stop button, then display the time for three seconds. If the machine has not yet completed three games, it then displays “Wait...”.\
Subsequently, it waits a (new) random delay and proceeds further as in the first game. After displaying the time for the last game, the machine shows the average time “Average= t.tt” for five seconds, then the game is over. The enhanced reaction controller should fulfil the following requirements.

* If after inserting the coin the player fails to press go/stop within ten seconds, the game is over.
* If the player presses the go/stop button during the waiting period, the game is aborted, and the average value is not displayed. Once again, no reward for cheating! 
* If the player presses the go/stop button while the machine is displaying a reaction- time value, the machine immediately moves on to the next game (or shows the average time) without waiting for the full three seconds of display time.
* If the player presses the go/stop button while the machine is displaying the average time, the game is immediately over.

### Program Components
Your program must consist of the following parts.
* A controlling program named ReactionMachine is provided as a base to test your controllers.
* SimpleReactionController and EnhancedReactionController are the modules which you need to realize.\
The both components must conform to the interface Controller. This is the main body of the exercises. 
You are free to write these components in any way you choose, so long as they implement the required interfaces.\
You must write SimpleReactionController.java that functions like the simple reaction machine described above and EnhancedReactionController.java that behaves like the enhanced multi-game reaction machine.
* A Display is a GUI component which you need to write to test your reaction machine.\
It must conform to the Gui interface. The GUI must have a button labelled “Coin Inserted” and a button labelled “Go/Stop”.\ There must be a display region to show the messages of the machine. Times must be displayed with two decimal places.\
For example, a value of 1.5 seconds must be shown as 1.50. Do not go to too much effort to make your GUI “beautiful”.\
We are more concerned here with correct operation of your controllers rather than with your artistic ability! You must write Display.java that implements the necessary GUI functions.\
Important. To ensure that we can automatically test your program, you must comply with the following constraints.
* Obviously, your program needs a source of timing information. You must obtain this information by implementing the tick method in your controller. The ReactionMachine class guarantees to call this method every 10 milliseconds. Do not use a Java timer, or your program cannot be tested and will fail all the tests.
* Your program also needs a source of random numbers. You must obtain your random numbers by calling the getRandom() method in the interface Random. Do not use the Java Random class, or your program will fail all the tests.


## Running
You can run the driver program by typing: 
```
java ReactionMachine c
```
where c is the name of the controller you want to test.\
For example, java Reactionmachine SimpleReactionController will run the SimpleReactionController program. \
You are, of course, free to modify this program or build another one to help you with your testing.
