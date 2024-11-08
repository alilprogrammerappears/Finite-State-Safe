
public class SecondDigitPending implements SafeComboState {

    private static SafeComboState instance = new SecondDigitPending();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("Second digit correct, how about the third?");
        safeCombo.setState(ThirdDigitPending.getInstance());
    }

    //-------------------------------
    @Override
    public void unlocked (SafeCombo safeCombo){
        System.out.println("Nice, time to unlock the safe and get the goods!");
    }

    @Override
    public void alarm (SafeCombo safeCombo){
        System.out.println("Oh no! You set the alarm off!  WEE OOO WEE OOO WEE OOO");
        System.out.println("You can wait for the police to arrive or you can turn it off by typing 999");
    }


    public void secondDigitPending (SafeCombo safeCombo){
        System.out.println("Incorrect, please try the second digit again.");
        safeCombo.setState(SecondDigitPending.getInstance());
    }
    

}