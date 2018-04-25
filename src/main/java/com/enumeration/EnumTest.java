package com.enumeration;

/**
 * 说明：枚举类型
 *
 * @author acebrook
 * @date 2015-10-26 下午2:49:14
 */
public class EnumTest {

    public enum ActionType {
        CREATE, // 任务箱的创建状态

        READY, // 任务箱的准备状态

        START, // 任务箱的开始运行状态

        WARN, // 任务箱的运行警告状态

        ERROR, // 任务箱的运行错误状态

        FINISH // 任务箱的运行完成状态
    }

    public static void run(ActionType type) {
        if (null == type) {
            System.out.println("actionType is null");
        } else {
            System.out.println("actionType = " + type);
        }
    }

    public static void main(String[] args) {
        run(ActionType.CREATE);
        run(ActionType.READY);
        run(ActionType.START);
        run(ActionType.WARN);
        run(ActionType.FINISH);
        run(ActionType.ERROR);
    }

}
