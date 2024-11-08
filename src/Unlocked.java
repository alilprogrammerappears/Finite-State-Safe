public class Unlocked implements SafeComboState {

    private static SafeComboState instance = new Unlocked();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("Oh no. still locked");
        System.out.println(safeCombo.getState().toString());
        safeCombo.setState(Unlocked.getInstance());
    }

    @Override
    public void unlocked (SafeCombo safeCombo){
        System.out.println("Good work, the safe is unlocked!");
        safeCombo.setState(Unlocked.getInstance());
        
    }

    @Override
    public void alarm (SafeCombo safeCombo){
        System.out.println("Oh no! You set the alarm off even thought the safe's unlocked!  WEE OOO WEE OOO WEE OOO");
        System.out.println("You can wait for the police to arrive or you can turn it off by typing 999");
        safeCombo.setState(Alarm.getInstance());
    }


}