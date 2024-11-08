import java.util.Scanner;
/*----------------------------------------------------------------------------------------
 * Lab 3: FSM Safe
 *        This program demonstrates a combination safe as a FSM using classes
 * By: Kassandra Montgomery
 * Class: INFO 3235 S50
 * Date: March 28 2023
------------------------------------------------------------------------------------------
*/
public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        SafeCombo safeCombo = new SafeCombo();
        String state;
        int inputValue;


        System.out.println("Welcome to my safe. I have valuable treasure inside, can you figure out the lock?");
        //correct code is 5872
        System.out.println("Enter 201 to try to break the lock");
        System.out.println("Have a key? Lucky you! Unlock it with 202");
        System.out.println("Enter in the first digit from 1 - 9: ");
        
        
        System.out.println("Current state is: " + safeCombo.getState()); //-------------testing current state


        state = safeCombo.getState().toString(); 
        inputValue = input.nextInt();

        //alarm goes off
        if (inputValue == 201 && state != "Unlocked"){
            safeCombo.alarm();
            inputValue = input.nextInt();
                if (inputValue == 999){
                    safeCombo.locked();
                }
                else {
                    safeCombo.alarm();
                }

        }
        else if (inputValue == 202 & state != "Unlocked"){
            safeCombo.unlocked();
        }
        //first digit
        else if (inputValue == 5 && state != "Unlocked"){
            safeCombo.locked();
            inputValue = input.nextInt();

            //second digit
            if (inputValue == 8){
                safeCombo.locked();
                inputValue = input.nextInt();

                //third digit
                if (inputValue == 7){
                    safeCombo.locked();
                    inputValue = input.nextInt();

                    //fourth digit
                    if (inputValue == 2){
                        safeCombo.unlocked();
                    }          
                    else{
                        System.out.println("Try again");
                    }
                }
                else{
                    System.out.println("Try again");
                }
                
            }
            else{
                System.out.println("Try again");
            }
        }

        input.close();
    }
}