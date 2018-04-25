package com.enumeration;

/**
 * 说明：枚举类型
 *
 * @author acebrook
 * @date 2015-10-26 下午2:49:14
 */
public class EnumTest4 {

    enum Animal {
        DOG("dog"),
        CAT("cat"),
        TIGER("tiger"),
        FISH("fish"),
        NULL(null); // 枚举项，在分号之前定义完成。

        private String animalName;

        Animal(String animalName) {
            this.animalName = animalName;
        }
    }

    public static void select(Animal animal) {
        // 底层是使用int类型进行比较，因为Enum类型，底层默认会有name和ordinal属性，后者为Enum字段的升序序号
        switch (animal) {
            case CAT:
                System.out.println("This is a cat");
                break;
            case DOG:
                System.out.println("This is a dog");
                break;
            case FISH:
                System.out.println("This is a fish");
                break;
            case TIGER:
                System.out.println("This is a tiger");
                break;
            default:
                System.out.println("nothing, invalid argument.");
        }
    }

    public static void main(String[] args) {
        select(Animal.CAT);
        select(Animal.DOG);
        select(Animal.TIGER);
        select(Animal.NULL);
    }


    private static void print(Animal animal) {
        // 这里 name()，是定义字段名称的字面值，比如枚举变量DOG，对应的字面值是DOG，跟具体的赋值无关。
        System.out.println("name = " + animal.name() + ", ordinal = " + animal.ordinal());
    }
}
