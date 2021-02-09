package com.example.lift;

public abstract class LiftState
{
    // 拥有一个电梯对象，用于更新电梯当前状态
    protected Lift mLift;

    /**
     * 通过构造函数引入电梯的实例化对象
     *
     * @param lift
     */
    public LiftState(Lift lift) {
        this.mLift = lift;
    }

    /**
     * 行为：打开电梯门
     */
    public abstract void open();

    /**
     * 行为：关闭电梯门
     */
    public abstract void close();

    /**
     * 行为：电梯运行
     */
    public abstract void run();

    /**
     * 行为：电梯停止运行
     */
    public abstract void stop();

}
