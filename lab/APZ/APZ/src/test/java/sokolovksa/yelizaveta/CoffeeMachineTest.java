package sokolovksa.yelizaveta;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeMachineTest {

  CoffeeMachine cm;

  @BeforeEach
  void setUp() {
    cm = new CoffeeMachine();
  }

  // Базовий сценарій: стандартне еспресо
  @Test
  void testDefaultEspresso() {
    String result = cm.makeCoffee();
    assertTrue(result.contains("espresso"), "Повинно приготуватись еспресо");
  }

  // Без води
  @Test
  void testNoWater() {
    cm.setHasWater(false);
    assertTrue(cm.makeCoffee().contains("відсутня вода"));
  }

  // Без зерен
  @Test
  void testNoBeans() {
    cm.setHasBeans(false);
    assertTrue(cm.makeCoffee().contains("немає кавових зерен"));
  }

  // Поломка млинка
  @Test
  void testBrokenGrinder() {
    cm.setGrinderWorking(false);
    assertTrue(cm.makeCoffee().contains("млинок несправний"));
  }

  // Поломка нагрівача
  @Test
  void testHeaterBroken() {
    cm.setHeaterWorking(false);
    assertTrue(cm.makeCoffee().contains("нагрівач не працює"));
  }

  // Лате без спінювача
  @Test
  void testLatteWithoutFrother() {
    cm.setCoffeeType("latte");
    cm.setMilkFrotherOn(false);
    assertTrue(cm.makeCoffee().contains("спінювач молока вимкнений"));
  }

  // Лате зі спінювачем
  @Test
  void testLatteWithFrother() {
    cm.setCoffeeType("latte");
    cm.setMilkFrotherOn(true);
    String result = cm.makeCoffee();
    assertTrue(result.contains("Молоко спінено успішно"));
  }

  // Американо
  @Test
  void testAmericano() {
    cm.setCoffeeType("americano");
    assertTrue(cm.makeCoffee().contains("americano"));
  }

  // Дуже міцна кава
  @Test
  void testStrongCoffee() {
    cm.setStrength(3);
    assertTrue(cm.makeCoffee().contains("Дуже міцна кава"));
  }

  // Слабка кава
  @Test
  void testWeakCoffee() {
    cm.setStrength(1);
    assertTrue(cm.makeCoffee().contains("Слабка кава"));
  }

  // Некоректна міцність
  @Test
  void testInvalidStrength() {
    cm.setStrength(5);
    assertTrue(cm.makeCoffee().contains("Некоректна міцність"));
  }

  // Мала чашка
  @Test
  void testSmallCup() {
    cm.setCupSize(100);
    assertTrue(cm.makeCoffee().contains("100 мл"));
  }

  // Велика чашка
  @Test
  void testBigCup() {
    cm.setCupSize(400);
    assertTrue(cm.makeCoffee().contains("400 мл"));
  }

  // Еспресо зі спінювачем (не обов’язково)
  @Test
  void testEspressoWithFrother() {
    cm.setCoffeeType("espresso");
    cm.setMilkFrotherOn(true);
    assertTrue(cm.makeCoffee().contains("Напій готовий"));
  }

  // Лате + максимальна міцність
  @Test
  void testLatteStrong() {
    cm.setCoffeeType("latte");
    cm.setMilkFrotherOn(true);
    cm.setStrength(3);
    String result = cm.makeCoffee();
    assertTrue(result.contains("Дуже міцна кава"));
    assertTrue(result.contains("Молоко спінено"));
  }

  // Відсутня вода і зерна
  @Test
  void testNoWaterAndBeans() {
    cm.setHasWater(false);
    cm.setHasBeans(false);
    assertTrue(cm.makeCoffee().contains("вода"));
  }

  // Американо середньої міцності
  @Test
  void testAmericanoMedium() {
    cm.setCoffeeType("americano");
    cm.setStrength(2);
    assertTrue(cm.makeCoffee().contains("Середня міцність"));
  }

  // Лате без зерен
  @Test
  void testLatteNoBeans() {
    cm.setCoffeeType("latte");
    cm.setMilkFrotherOn(true);
    cm.setHasBeans(false);
    assertTrue(cm.makeCoffee().contains("немає кавових зерен"));
  }

  // Капучино зі спінювачем
  @Test
  void testCappuccinoWithFrother() {
    cm.setCoffeeType("cappuccino");
    cm.setMilkFrotherOn(true);
    assertTrue(cm.makeCoffee().contains("Молоко спінено"));
  }

  // Повний робочий цикл (ідеальний сценарій)
  @Test
  void testPerfectCycle() {
    cm.setCoffeeType("latte");
    cm.setMilkFrotherOn(true);
    cm.setStrength(2);
    cm.setCupSize(250);
    String result = cm.makeCoffee();
    assertTrue(result.contains("Напій готовий"));
  }
}
