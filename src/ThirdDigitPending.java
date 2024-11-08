public class ThirdDigitPending implements SafeComboState {

    private static SafeComboState instance = new ThirdDigitPending();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("Third digit is right! One more to go, what is it? ");
        safeCombo.setState(FourthDigitPending.getInstance());
    }

    @Override
    public void unlocked (SafeCombo safeCombo){
        System.out.println("Nice, time to unlock the safe and get the goods!");
        safeCombo.setState(Unlocked.getInstance());
    }

    @Override
    public void alarm (SafeCombo safeCombo){
        System.out.println("Oh no! You set the alarm off!  WEE OOO WEE OOO WEE OOO");
        System.out.println("You can wait for the police to arrive or you can turn it off by typing 999");
    }
    
    public void thirdDigitPending (SafeCombo safeCombo){
        System.out.println("Third digit is wrong, please try again ");
        safeCombo.setState(ThirdDigitPending.getInstance());
    }
    
    public void fourthDigitPending (SafeCombo safeCombo){

    }

}