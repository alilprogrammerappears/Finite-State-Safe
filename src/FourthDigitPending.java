public class FourthDigitPending implements SafeComboState {

    private static SafeComboState instance = new FourthDigitPending();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("Nope, still locked!");
        safeCombo.setState(FourthDigitPending.getInstance());
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
    }
    
    public void fourthDigitPending (SafeCombo safeCombo){
        System.out.println("Nope, try again. Still waiting for the forth digit.");
        safeCombo.setState(FourthDigitPending.getInstance());
    }

}