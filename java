package firstproject;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
public class Currency {

    private final static Scanner IN = new Scanner(System.in);
    private final static PrintStream OUT = System.out;

    private static final BigDecimal RUBLES = BigDecimal.valueOf(100);
    private static final BigDecimal RATE_USD = BigDecimal.valueOf(1.35);
    private static final BigDecimal RATE_EUR = BigDecimal.valueOf(1.20);
    private static final BigDecimal RATE_GBP = BigDecimal.valueOf(1.02);
    private static final BigDecimal RATE_JPY = BigDecimal.valueOf(153.29);
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
    public static void main(String[] args) {

        // Interface
        OUT.println("Welcome to the Currency Converter Program \n");
        OUT.println("Используйте одну из перечисленных валют для конвертации: \n 1 - Rubles \n 2 - US dollars \n 3 - Euros \n 4 - British Pounds \n 5 - Japanese Yen \n");
        OUT.println("Please choose the input currency");
        choose();
        OUT.println("Сколько денег у вас осталось до зарплаты?");
        BigDecimal moneyBeforeSalary = BigDecimal.valueOf(IN.nextDouble());
        OUT.println("Введите команду. Доступные команды: convert и advice.");
        String command = IN.next();
        if (command.equals("convert")) {
            convert(moneyBeforeSalary);
        } else if (command.equals("advice")) {
            OUT.println("Сколько дней до зарплаты?");
            BigDecimal daysBeforeSalary = BigDecimal.valueOf(IN.nextInt());
            advice(moneyBeforeSalary, daysBeforeSalary);
        } else {
            OUT.println("Извините, такой команды пока нет.");
        }
    }

    private static void advice(BigDecimal moneyBeforeSalary, BigDecimal daysBeforeSalary) {
        if (moneyBeforeSalary.compareTo(BigDecimal.valueOf(3000)) < 0) {
            OUT.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
        } else if (moneyBeforeSalary.compareTo(BigDecimal.valueOf(10000)) < 0) {
            if (daysBeforeSalary.compareTo(BigDecimal.valueOf(10)) < 0) {
                OUT.println("Окей, пора в Макдак!");
            } else {
                OUT.println("Сегодня лучше поесть дома. Экономьте, и вы дотянете до зарплаты!");
            }
        } else if (moneyBeforeSalary.compareTo(BigDecimal.valueOf(30000)) < 0) {
            if (daysBeforeSalary.compareTo(BigDecimal.valueOf(10)) < 0) {
                OUT.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            } else {
                OUT.println("Окей, пора в Макдак!");
            }
        } else {
            if (daysBeforeSalary.compareTo(BigDecimal.valueOf(10)) < 0) {
                OUT.println("Отлично! Заказывайте крабов!");
            } else {
                OUT.println("Неплохо! Прикупите долларов и зайдите поужинать в классное место. :)");
            }
        }
    }

    private static void choose() {
        int choice = IN.nextInt();
        String inType;
        switch (choice) {
            case 1 -> inType = "Rubles >> " + RUBLES;
            case 2 -> inType = "US Dollars >> " + RATE_USD;
            case 3 -> inType = "Euros >> " + RATE_EUR;
            case 4 -> inType = "British Pounds >> " + RATE_GBP;
            case 5 -> inType = "Japanese Yen >> " + RATE_JPY;
            default -> {
                OUT.println("Какая печаль, я пока не знаю такой валюты.\nПожалуйста, перезапустите программу и выберите валюту из списка :)");
                return;
            }
        }
        OUT.println("В валюте: " + inType);
    }

    private static void convert(BigDecimal moneyBeforeSalary) {
        OUT.println("Please choose the output currency");
        OUT.println("В какую валюту хотите конвертировать рубли? Доступные варианты: USD, EUR, JPY, GBP.");
        String currency = IN.next(); // считываю значения с помощью scanner
        if (currency.equals("RUB")) {
            OUT.println("Ваши сбережения в рублях: " + moneyBeforeSalary.divide(RUBLES, ROUNDING_MODE));
        }
        switch (currency) {
            case "RUS" -> OUT.println("Ваши сбережения в рублях:" + RUBLES);
            case "USD" -> OUT.println("Ваши сбережения в долларах: " + moneyBeforeSalary.divide(RATE_USD, ROUNDING_MODE));
            case "EUR" -> OUT.println("Ваши сбережения в евро: " + moneyBeforeSalary.divide(RATE_EUR, ROUNDING_MODE));
            case "GBP" -> OUT.println("Ваши сбережения в долларах: " + moneyBeforeSalary.divide(RATE_GBP, ROUNDING_MODE));
            case "JPY" -> OUT.println("Ваши сбережения в иенах: " + moneyBeforeSalary.divide(RATE_JPY, ROUNDING_MODE));
            default -> OUT.println("Валюта не поддерживается.");
        }
    }
}