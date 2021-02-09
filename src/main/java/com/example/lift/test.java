package com.example.lift;

public class test
{
    public static void main(String[] args)
    {
        Lift lift = new Lift();
        lift.setState(new ClosingState(lift));
        //System.out.println(lift.getmCurState());
        lift.open();
        //System.out.println(lift.getmCurState());
        lift.close();
        //System.out.println(lift.getmCurState());
        lift.run();
        //System.out.println(lift.getmCurState());
        lift.open();
        //System.out.println(lift.getmCurState());
        lift.stop();
        //System.out.println(lift.getmCurState());
    }
}
