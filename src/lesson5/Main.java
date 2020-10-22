package lesson5;

public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Иван",
                "Директор",
                "iv@example.com",
                "89111234567",
                500000,
                50);
        empArray[1] = new Employee("Сергей",
                "DevOps",
                "ts@example.com",
                "891114567890",
                240000,
                30);

        empArray[2] = new Employee("Анна",
                "Бухгалтер",
                "an@example.com",
                "891117891234",
                50000,
                45);
        empArray[3] = new Employee("Полина",
                "Секретарь",
                "pl@example.com",
                "891111595687",
                35000,
                23);
        empArray[4] = new Employee("Лилия",
                "Менеджер",
                "ll@example.com",
                "891113574523",
                60000,
                25);



        for (Employee emp : empArray) {
            emp.showInfo();
        }

        System.out.println("Сотрудники 40+ :");
        for (Employee emp : empArray) {
            if (emp.getAge() > 40)
                emp.showInfo();
        }

    }
}
