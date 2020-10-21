package lesson5;

public class Employee {
    String fullName, position, email, phoneNumber;
    int salary, age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void showInfo() {
        System.out.println("ФИО - " + fullName + "; Должность - " + position + "; email  - " + email +
                        "; телефон - " + phoneNumber + "; ЗП - " + salary + "; Возраст - " + age);
    }

    public int getAge () {
        return age;
    }
}
