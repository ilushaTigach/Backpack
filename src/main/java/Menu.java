import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.SneakyThrows;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Item item = new Item();
    Backpack backpack = new Backpack();
    JacksonTest jacksonTest = new JacksonTest();
        /*
        Добавление из файла или создание нового предмета
         */
    @SneakyThrows
    public void startMenu() {
        System.out.println("Нажмите 1 если хотите добавить предмет из уже существующего файла.");
        System.out.println("Нажмите 2 если хотите создать новый предмет:");
        while (true) {
            try {
            int j = Integer.parseInt(scanner.nextLine());
            if (j == 1) {
                jacksonTest.jsonToPojoString();
                break;
            } else if (j == 2) {
                createItem();
            }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }
        /*
        Создание предмета
         */
        public void createItem() throws JsonProcessingException {

        System.out.println("Введите класс предмета (Weapon, Armor, Potion): ");
        item.setClassItem(scanner.nextLine());
        System.out.println("Введите название предмета: ");
        item.setName(scanner.nextLine());
        System.out.println("Введите размер предмета: ");
        item.setSize(scanner.nextInt());

        System.out.println("Класс предмета " + item.getClassItem());
        System.out.println("Название предмета " + item.getName());
        System.out.println("Размер предмета " + item.getSize());
        /*
        Классификация предмета
         */
        boolean weapon1 = item.getClassItem().equalsIgnoreCase("Weapon");
        boolean armor2 = item.getClassItem().equalsIgnoreCase("Armor");
        boolean potion3 = item.getClassItem().equalsIgnoreCase("Potion");
        if (weapon1 == true) {
            Weapon weapon = new Weapon();
            boolean test = true;
            do {
                try {
                    System.out.println("Введите качество оружия от 1 до 10: ");
                    weapon.setQuality(scanner.nextInt());
                    test = false;
                } catch (QualityException e) {
                    System.err.println((e.getMessage()));
                }
            } while (test);
            System.out.println(weapon.getQualityDescription());
        } else if (armor2 == true) {
            Armor armor = new Armor();
            boolean test = true;
            do {
                try {
                    System.out.println("Введите качество брони от 1 до 10: ");
                    armor.setQuality(scanner.nextInt());
                    test = false;
                } catch (QualityException e) {
                    System.err.println((e.getMessage()));
                }
            } while (test);
            System.out.println(armor.getQualityDescription());
        } else if (potion3 == true) {
            Potion potion = new Potion();
            boolean test = true;
            do {
                try {
                    System.out.println("Введите тип зелья согласно цифре: 1 - Лечение, 2 - Защита, 3 - Увеличение урона ");
                    potion.setType(scanner.nextInt());
                    test = false;
                } catch (TypeException e) {
                    System.err.println((e.getMessage()));
                }
            } while (test);
            System.out.println(potion.getTypeDescription());
        }
        /*
        Взаимодействие с рюкзаком
         */
        System.out.println("Нажмите 1, чтобы добавить предмет в рюкзак");
        System.out.println("Нажмите 2, чтобы очистить рюкзак");
        System.out.println("Нажмите 3, чтобы проверить рюкзак на содержимое");
        System.out.println("Нажмите 4, чтобы записать предмет в файл .json");

        while (true) {
            int i = scanner.nextInt();
            if (i == 1) {
                backpack.addItemInBackpack(item);
            } else if (i == 2) {
                backpack.removeItemsFromBackpack(item);
            } else if (i == 3) {
                backpack.takeItemFromBackpack();
            } else if (i == 4) {
                /*
                Запись в .json
                */
                DataRecorder dataRecorder = new DataRecorder();
                dataRecorder.writeItem(jacksonTest.pojoToJsonString(backpack));
                break;
            }
        }
    }
}
