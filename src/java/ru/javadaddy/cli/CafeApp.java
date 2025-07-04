package ru.javadaddy.cli;

import ru.javadaddy.model.Drink;
import ru.javadaddy.model.Food;
import ru.javadaddy.model.MenuItem;
import ru.javadaddy.service.OrderService;
import ru.javadaddy.service.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class CafeApp {
    private final Scanner scanner;
    private final OrderService orderService;
    private final List<MenuItem> menu;

    public CafeApp() {
        this.scanner = new Scanner(System.in);
        this.orderService = new OrderServiceImpl();
        this.menu = createMenu();
    }

    private List<MenuItem> createMenu() {
        return List.of(
                new Drink("Американо", 60, 0.2),
                new Drink("Латте", 120, 0.2),
                new Food("Бублик", 50, 100),
                new Food("Печенька", 20, 40)
        );
    }

    public void run() {
        printWelcomeMessage();

        while (true) {
            printMainMenu();
            int choice = readIntInput();

            switch (choice) {
                case 1 -> showMenu();
                case 2 -> addItemToOrder();
                case 3 -> viewCurrentOrder();
                case 4 -> applyPromocode();
                case 5 -> checkout();
                default -> System.out.println("Неверный ввод, попробуйте снова");
            }
        }
    }

    private void addItemToOrder() {
        showMenu();
        System.out.println("\nВыбирете номера товара: ");
        int itemNumber = readIntInput();

        if(itemNumber < 1 || itemNumber > menu.size()) {
            System.out.println("Неверный номер товара");
        }
    }

    private void showMenu() {
        System.out.println("\n=== МЕНЮ ===");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            String template = "%d. %s - %.2f руб. %s";

            String details = "";
            if (item instanceof Drink) {
                details = String.format("(%.1f л)", ((Drink) item).getVolume());
            } else if (item instanceof Food) {
                details = String.format("(%d г)", ((Food) item).getCalories());
            }

            System.out.println(
                    String.format(template, i + 1, item.getName(), item.getPrice(), details)
            );
        }
    }

    private int readIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Введите число: ");
            scanner.next();
        }

        int input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    private void printMainMenu() {
        System.out.println("\n=== Главное меню ===");
        System.out.println("1. Показать меню");
        System.out.println("2. Добавить в заказ");
        System.out.println("3. Просмотреть заказ");
        System.out.println("4. Применить промокод");
        System.out.println("5. Оформить заказ");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    private void printWelcomeMessage() {
        System.out.println("Добро пожаловать в CafeApp!");
        System.out.println("-----------------------------");
    }
}
