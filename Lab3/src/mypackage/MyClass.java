package mypackage;


//Интерфейсы
interface IOperation {
 void printName();          // название операции
 void printSign();          // знак операции
 double apply(double a, double b); // именно выполняет операцию
}

//Максимум
class MaxOperation implements IOperation {
 @Override
 public void printName() {
     System.out.println("Максимум");
 }

 @Override
 public void printSign() {
     System.out.println("max");
 }

 @Override
 public double apply(double a, double b) {
     return Math.max(a, b);
 }
}

//Минимум
class MinOperation implements IOperation {
 @Override
 public void printName() {
     System.out.println("Минимум");
 }

 @Override
 public void printSign() {
     System.out.println("min");
 }

 @Override
 public double apply(double a, double b) {
     return Math.min(a, b);
 }
}

//Расстояние от одного до другого числа
class DistanceOperation implements IOperation {
 @Override
 public void printName() {
     System.out.println("Расстояние");
 }

 @Override
 public void printSign() {
     System.out.println("|a - b|");
 }

 @Override
 public double apply(double a, double b) {
     return Math.abs(a - b);
 }
}

//Основной класс, переменные, демонстрация
public class MyClass {
 public static void main(String[] args) {
     IOperation[] operations = {
         new MaxOperation(),
         new MinOperation(),
         new DistanceOperation()
     };

     double x = 5.0;
     double y = -3.0;

     for (IOperation op : operations) {
         op.printName();
         op.printSign();
         double result = op.apply(x, y);
         System.out.println("Результат для " + x + " и " + y + ": " + result);
         System.out.println("------------------------");
     }
 }
}