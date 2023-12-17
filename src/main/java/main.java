import dataAccess.CreateDatabase;
import dataAccess.CreateTables;
import service.*;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CreateDatabase createDatabase = CreateDatabase.createNewDatabase();
        CreateTables.createTablesAndInsertData();

        System.out.println("\n\n");
        Scanner scanner = new Scanner(System.in);


        Integer makeAChoice;
        while (true) {
            System.out.println("\u001B[34m");
            System.out.println("*| Выберите команду:");
            System.out.println("*| Вводить нужно лишь цифры 1,2,3,4,5,6.");
            System.out.println("*| Описание ниже:");
            System.out.println("*| 1 - Добавление нового животного - название класса addAnimalApp");
            System.out.println("*| 2 - Показать список всех животных - название класса showAll");
            System.out.println("*| 3 - Показать команды животного по его id - название класса showCommandsById");
            System.out.println("*| 4 - Обучить животное новым командам - название класса learnNewCommand");
            System.out.println("*| 5 - Подсчитать количество животных - название класса animalCounter");
            System.out.println("*| 6 - Вывести id, имя животного и возраст в порядке возрастания в каждой таблице - название класса getAgeAndSort");
            System.out.println("\u001B[0m\n");


            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                makeAChoice = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Вы должены ввести числом. Попробуйте снова.");
            }
        }

        switch (makeAChoice) {
            case 1:
                AddAnimal addAnimalApp = new AddAnimal();
                addAnimalApp.addAnimal();
                break;
            case 2:
                ShowAll showAll = new ShowAll();
                showAll.showPets();
                showAll.showPackAnimals();
                break;
            case 3:
                ShowCommandsById showCommandsById = new ShowCommandsById();
                showCommandsById.showComandsById();
                break;
            case 4:
                LearnNewCommand learnNewCommand = new LearnNewCommand();
                learnNewCommand.learnNewCommand();
                break;
            case 5:
                AnimalCounter animalCounter = new AnimalCounter();
                animalCounter.countAnimals();
                break;
            case 6:
                GetAgeAndSort getAgeAndSort = new GetAgeAndSort();
                getAgeAndSort.animalSortByAge();
                break;
            default:
                System.out.println("Числа должны быть от 1 до 6.");

        }
    }
}
