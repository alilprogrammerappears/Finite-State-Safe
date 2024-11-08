class SafeCombo {

    private SafeComboState state = Locked.getInstance();

    public void setState(SafeComboState state){
        this.state = state;
    }

    public SafeComboState getState(){
        return state;
    }

    public void locked(){
        state.locked(this);
    }

    public void unlocked(){
        state.unlocked(this);
    }

    public void alarm(){
        state.alarm(this);
    }

}