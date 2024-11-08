public class Alarm implements SafeComboState {

    private static SafeComboState instance = new Alarm();

    public static SafeComboState getInstance() {
        return instance;
    }

    @Override
    public void locked (SafeCombo safeCombo){
        System.out.println("Phew. Good work, You've turned the alarm off and the safe is now locked.");
        System.out.println("Go ahead and try guessing the code again.");
        safeCombo.setState(Locked.getInstance());
    }

    @Override
    public void unlocked (SafeCombo safeCombo){
        System.out.println("Oh. How did you get to this state?");
        safeCombo.setState(Alarm.getInstance());
    }

    @Override
    public void alarm (SafeCombo safeCombo){
        System.out.println("Too late! The police gotcha!");
        System.out.println("Remember kids, stealing is a crime.");
        safeCombo.setState(Alarm.getInstance());
    }

}