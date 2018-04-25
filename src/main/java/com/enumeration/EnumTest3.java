package com.enumeration;

/**
 * 说明：枚举类型
 *
 * @author acebrook
 * @date 2015-10-26 下午2:49:14
 */
public class EnumTest3 {

    enum Animal {
        DOG("dog", 1),
        CAT("cat", 3),
        TIGER("tiger", 4),
        FISH("fish", 2); // 枚举项，在分号之前定义完成。

        private String animalName;
        private int animalAge;

        Animal(String animalName, int animalAge) {
            this.animalName = animalName;
            this.animalAge = animalAge;
        }
    }

    public static void main(String[] args) {
        print(Animal.DOG);
        print(Animal.CAT);
        print(Animal.TIGER);
        print(Animal.FISH);

        System.out.println("========================");
        Animal[] animals = Animal.values();
        for (Animal animal : animals) {
            print(animal);
        }
    }


    private static void print(Animal animal) {
        // 这里 name()，是定义字段名称的字面值，比如枚举变量DOG，对应的字面值是DOG，跟具体的赋值无关。
        System.out.println("name = " + animal.name() + ", ordinal = " + animal.ordinal());
    }
}
