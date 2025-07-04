package ru.javadaddy.cli;

import ru.javadaddy.enums.PromoCode;
import ru.javadaddy.model.Drink;
import ru.javadaddy.model.Food;
import ru.javadaddy.model.MenuItem;
import ru.javadaddy.service.OrderService;
import ru.javadaddy.service.OrderServiceImpl;

import java.util.List;
import java.util.Scanner;

public class CafeApp {
    private final Scanner scanner;
    private final OrderService orderService;
    private final List<MenuItem> menu;
    private PromoCode appliedPromo;

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

    private void checkout() {
        if (orderService.findItems().isEmpty()) {
            System.out.println("\nСписок пуст");
        }

        viewCurrentOrder();
        System.out.println("\nСпасибо за заказ! Приятного аппетита!");
        System.exit(0);
    }

    private void applyPromocode() {
        System.out.println("\nДоступные промокоды:");
        System.out.println("- WELCOME10 (100 руб.)");

        System.out.println("Введите промокод");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("WELCOME10")) {
            appliedPromo = PromoCode.WELCOME10;
            System.out.println("Скидка 100 руб. применена!");
        } else {
            System.out.println("Неверный промокод!");
        }
    }

    private void viewCurrentOrder() {
        List<MenuItem> items = orderService.findItems();
        if (items.isEmpty()) {
            System.out.println("Ваш заказ пуст!");
        }

        System.out.println("===Ваш заказ===");
        items.forEach(item ->
                System.out.printf("- %s (%.2f руб.)\n", item.getName(), item.getPrice())
        );

        System.out.printf("Итого: %.2f руб.\n", orderService.calculateTotalPrice());
    }

    private void addItemToOrder() {
        showMenu();
        System.out.println("\nВыбирете номера товара: ");
        int itemNumber = readIntInput();

        if (itemNumber < 1 || itemNumber > menu.size()) {
            System.out.println("Неверный номер товара");
            return;
        }

        MenuItem selectedItem = menu.get(itemNumber - 1);
        orderService.addItem(selectedItem);
        System.out.printf("\nДобавлено: %s (%.2f руб.)\n",
                selectedItem.getName(), selectedItem.getPrice());
    }


    private void showMenu() {
        System.out.println("\n=== МЕНЮ ===");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);

            StringBuilder sb = new StringBuilder()
                    .append(i + 1).append(". ")
                    .append(item.getName()).append(" - ")
                    .append(String.format("%.2f руб.", item.getPrice()));

            if (item instanceof Drink) {
                sb.append(" (").append(((Drink) item).getVolume()).append(" л)");
            } else if (item instanceof Food) {
                sb.append(" (").append(((Food) item).getCalories()).append(" ккал)");
            }

            System.out.println(sb.toString());
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

    public static void main(String[] args) {
        CafeApp cafeApp = new CafeApp();
        cafeApp.run();
    }
}
