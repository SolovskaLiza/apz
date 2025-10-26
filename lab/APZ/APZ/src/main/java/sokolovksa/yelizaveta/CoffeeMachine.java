package sokolovksa.yelizaveta;

import lombok.Setter;

@Setter
public class CoffeeMachine {

  // Частини кавомашини
  private boolean hasWater; // чи є вода
  private boolean hasBeans; // чи є кава в зернах
  private boolean grinderWorking; // чи працює млинок
  private boolean heaterWorking; // чи працює нагрівач
  private boolean milkFrotherOn; // чи активний спінювач молока

  // Налаштування користувача
  private String coffeeType; // тип кави: espresso, latte, americano
  private int strength; // міцність (1–3)
  private int cupSize; // розмір чашки (мл)

  public CoffeeMachine() {
    // Стандартні налаштування
    this.hasWater = true;
    this.hasBeans = true;
    this.grinderWorking = true;
    this.heaterWorking = true;
    this.milkFrotherOn = false;
    this.coffeeType = "espresso";
    this.strength = 2;
    this.cupSize = 200;
  }

  // Основний метод — бізнес-логіка
  public String makeCoffee() {
    // Перевірка базових умов
    if (!hasWater) return "Помилка: відсутня вода";
    if (!hasBeans) return "Помилка: немає кавових зерен";
    if (!grinderWorking) return "Помилка: млинок несправний";
    if (!heaterWorking) return "Помилка: нагрівач не працює";

    // Початок приготування
    StringBuilder result = new StringBuilder("Готується " + coffeeType + "...\n");

    // Врахування міцності кави
    switch (strength) {
      case 1 -> result.append("• Слабка кава\n");
      case 2 -> result.append("• Середня міцність\n");
      case 3 -> result.append("• Дуже міцна кава\n");
      default -> result.append("• Некоректна міцність, встановлено середню\n");
    }

    // Врахування типу кави
    if (coffeeType.equalsIgnoreCase("latte") || coffeeType.equalsIgnoreCase("cappuccino")) {
      if (!milkFrotherOn) {
        return "Помилка: спінювач молока вимкнений для " + coffeeType;
      }
      result.append("• Молоко спінено успішно\n");
    }

    // Імітація процесу приготування
    result.append("Обʼєм чашки: ").append(cupSize).append(" мл\n");
    result.append("Напій готовий: ").append(coffeeType);

    return result.toString();
  }
}
