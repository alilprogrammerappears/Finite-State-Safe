package NonClassFSMFiles;
import java.util.Scanner;

/*----------------------------------------------------------------------------------------
 * Lab 3: FSM Safe
 *        This program demonstrates a combination safe as a FSM using if-else statements
 * By: Kassandra Montgomery
 * Class: INFO 3235 S50
 * Date: March 28 2023
------------------------------------------------------------------------------------------
*/

public class RegularSafe {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ComboLock comboLock = new ComboLock();
           
        System.out.println("Welcome to my safe. I have valuable treasure inside, can you figure out the lock?");
        System.out.println("Press 201 at anytime to try to break the lock");
        System.out.println("Have a key? Lucky you! Unlock it with 202");
        System.out.print("Enter in the first digit from 1 - 9: ");
        System.out.println();
        
        do{
        comboLock.changeState(input.nextInt());
        //System.out.println(comboLock.getState()); --------> testing current state

        }
        while (comboLock.getState() != "unlocked" && comboLock.getState() != "idle");
        
        if (comboLock.getState() == "idle"){
            System.out.println("Remember kids, stealing is a crime.");
        }
        else {
        System.out.println("CONGRATULATIONS! YOU'RE THE BEST!");
        System.out.println();
        System.out.println();
        System.out.println("P.S. The congrats and the friends you made along the way was the valuable treasure :)");
        }

        input.close();
    }

}

class ComboLock{


private static String LOCKED = "locked";
private static String UNLOCKED = "unlocked";
private static String IDLE = "idle";
private static String ALARM = "alarm_sounding";
private static String SECOND_DIGIT_PENDING = "second_digit_pending";
private static String THIRD_DIGIT_PENDING = "third_digit_pending";
private static String FOURTH_DIGIT_PENDING = "fourth_digit_pending";

private String state;

public ComboLock(){
    state = LOCKED;
}

public void changeState(int input) {

    if (input == 201 && state != UNLOCKED){
        System.out.println("Oh no! You set the alarm off!  WEE OOO WEE OOO WEE OOO");
        System.out.println("You can wait for the police to arrive or you can turn it off by typing 999");
        state = ALARM;
    }
    else if (input == 202 && state !=UNLOCKED){
        System.out.println("Nice key, time to unlock the safe and get the goods!");
        state = UNLOCKED;
    }
    else if (input == 999 && state == ALARM){
        System.out.println("Phew. Good work, You've turned the alarm off and the safe is now locked.");
        System.out.println("Go ahead and try guessing the code again. Properly this time. Enter the first digit from 1-9: ");
        state = LOCKED;
    }
    else if (input != 999 && state == ALARM){
        System.out.println("Too late! The police gotcha!");
        state = IDLE;
    }
    else if (input == 999 && state != ALARM){
        System.out.println("There has been no change");

    }
    else if (input == 1 && state == LOCKED){
        System.out.println("First digit correct, how about the second?");
        state = SECOND_DIGIT_PENDING;
    }
    else if (input != 1 && input != 201 && state == LOCKED){
        System.out.println("The safe is still locked.");
    }
    else if (input == 2 && state == SECOND_DIGIT_PENDING){
        System.out.println("Second digit correct, how about the third?");
        state = THIRD_DIGIT_PENDING;
    }
    else if (input != 2 && input != 201 && state == SECOND_DIGIT_PENDING){
        System.out.println("Incorrect, please try the second digit again.");
    }
    else if (input == 3 && state == THIRD_DIGIT_PENDING){
        System.out.println("Third digit is right! One more to go, what is it? ");
        state = FOURTH_DIGIT_PENDING;
    }
    else if (input != 3 && input != 201 && state == THIRD_DIGIT_PENDING){
        System.out.println("Third digit is wrong, please try again ");
    }
    else if (input == 4 && state == FOURTH_DIGIT_PENDING){
        System.out.println("Nice, that's correct. Let's get this safe unlocked.");
        state = UNLOCKED;
    }
    else if (input != 4 && input != 201 && state == FOURTH_DIGIT_PENDING){
        System.out.println("Nope, try again. Still waiting for the forth digit.");
    }
    else{
        throw new IllegalArgumentException("Something may have gone wrong. Try running this program again.");
    }
}

public String getState(){
    return state;
}

public void setState(String state){
    this.state = state;
}

}
