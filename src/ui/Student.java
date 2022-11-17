package ui;

public class Student {
    public String name;
    public String lastName;
    public String studentCondition;
    public int birthAt;
    public double points;

    public Student(String name, String lastName, String studentCondition, int birthAt, double points) {
        this.name = name;
        this.lastName = lastName;
        this.studentCondition = studentCondition;
        this.birthAt = birthAt;
        this.points = points;
    }
    public void print() {
        System.out.println(name + " " + lastName);
        System.out.println("Rok urodzenia: " + birthAt);
        System.out.println("Stan studenta: " + studentCondition);
        System.out.println("Punkty: " + points + "\n");
    }

}
