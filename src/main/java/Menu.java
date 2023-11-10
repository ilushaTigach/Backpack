import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Jackson jackson = new Jackson();
        /*
        Добавление из файла или создание нового предмета
         */

    public void startMenu() {

        System.out.println("Нажмите 1 если хотите добавить уже существующий рюкзак:");
        System.out.println("Нажмите 2 если хотите создать новый предмет:");
        System.out.println("Нажмите 3 если хотите завершить программу:");
        while (true) {
            try {
                int j = Integer.parseInt(scanner.nextLine());
                if (j == 1) {
                    try {
                        jackson.jsonToPojoString();
                        Item item = createItem();
                        Backpack backpack = interactionWithBackpack(item);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                } else if (j == 2) {
                    try {
                        Item item = createItem();
                        Backpack backpack = interactionWithBackpack(item);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else if (j == 3) {
                    System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Выберете действие");
            }
        }
    }

    /*
    Создание предмета
     */
    public Item createItem() {
        Item item = new Item();
        System.out.println("Введите класс предмета (WEAPON, ARMOR, POTION): ");
        while (true) {
            try {
                item.setClassItem(ClassItem.valueOf(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Класс введён не верно");
            }
        }
        System.out.println("Введите название предмета: ");
        while (true) {
            try {
                item.setName(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Название не введено");
            }
        }
        System.out.println("Введите размер предмета не больше 10: ");
        while (true) {
            try {
                item.setSize(Integer.parseInt(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Размер назначен не коректно");
            }
        }
        System.out.println("Класс предмета " + item.getClassItem());
        System.out.println("Название предмета " + item.getName());
        System.out.println("Размер предмета " + item.getSize());

        /*
        Классификация предмета
         */

        if (item.getClassItem() == ClassItem.WEAPON) {
            Weapon weapon = new Weapon();
            do {
                try {
                    System.out.println("Введите качество оружия от 1 до 10: ");
                    weapon.setQuality(Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Качество назначено не коректно");
                }
            } while (true);
            System.out.println(weapon.getQualityDescription());
        } else if (item.getClassItem() == ClassItem.ARMOR) {
            Armor armor = new Armor();
            do {
                try {
                    System.out.println("Введите качество брони от 1 до 10: ");
                    armor.setQuality(Integer.parseInt(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Качество назначено не коректно");
                }
            } while (true);
            System.out.println(armor.getQualityDescription());
        } else if (item.getClassItem() == ClassItem.POTION) {
            Potion potion = new Potion();
            do {
                try {
                    System.out.println("Введите тип зелья: HEALING, DEFENSE, DAMAGE");
                    potion.setType(PotionType.valueOf(scanner.nextLine()));
                    break;
                } catch (Exception e) {
                    System.out.println("Тип зелья назначен не коректно");
                }
            } while (true);
            System.out.println(potion.getTypeDescription());
        }
        return item;
    }

    /*
    Взаимодействие с рюкзаком
     */
    public Backpack interactionWithBackpack(Item item) throws JsonProcessingException {
        Backpack backpack = new Backpack();
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
                interactionWithFile(backpack);
                startMenu();
            }
        }
    }

    /*
    Запись в .json
    */
    public void interactionWithFile(Backpack backpack) throws JsonProcessingException {
        DataRecorder dataRecorder = new DataRecorder();
        dataRecorder.writeItem(jackson.pojoToJsonString(backpack));
    }
}


