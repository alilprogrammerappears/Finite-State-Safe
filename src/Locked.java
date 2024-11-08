public class Locked implements SafeComboState {

    private static SafeComboState instance = new Locked();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("First digit correct, how about the second?");
        safeCombo.setState(SecondDigitPending.getInstance());
    }

    @Override
    public void unlocked (SafeCombo safeCombo){
        System.out.println("CONGRATULATIONS! YOU DID IT! YOU'RE THE BEST!");
        System.out.println();
        System.out.println();
        System.out.println("P.S. The congrats and the friends you made along the way was the valuable treasure :)");
    }

    @Override
    public void alarm (SafeCombo safeCombo){
        System.out.println("Oh no! You set the alarm off!  WEE OOO WEE OOO WEE OOO");
        System.out.println("You can wait for the police to arrive or you can turn it off by typing 999");
        safeCombo.setState(Alarm.getInstance());
    }


    public void secondDigitPending (SafeCombo safeCombo){
        System.out.println("First digit correct, how about the second?");
        safeCombo.setState(SecondDigitPending.getInstance());
    }
    

    public void thirdDigitPending (SafeCombo safeCombo){
        System.out.println("Oh. How did you get to this state?");
        System.out.println(safeCombo.getState().toString());
        safeCombo.setState(Locked.getInstance());
    }
    

    public void fourthDigitPending (SafeCombo safeCombo){
        System.out.println("Oh. How did you get to this state?");
        System.out.println(safeCombo.getState().toString());
        safeCombo.setState(Locked.getInstance());
    }

}