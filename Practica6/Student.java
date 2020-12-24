import java.util.Scanner;

public class Student {
    private String name;
    private int InfMark;
    private int MathMark;
    private int EngMark;

    public Student() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя студента: ");
        this.name = in.nextLine();
        System.out.print("Введите оценку студента по информатике: ");
        this.InfMark = in.nextInt();
        System.out.print("Введите оценку студента по математике: ");
        this.MathMark = in.nextInt();
        System.out.print("Введите оценку студента по английскому: ");
        this.EngMark = in.nextInt();
    }

    public String compare(Student obj2) {
        double a = (double)(this.InfMark + this.EngMark + this.MathMark);
        double b = (double)(obj2.InfMark + obj2.EngMark + obj2.MathMark);
        if (a / 3.0D > b / 3.0D) {
            return ">";
        } else {
            return a / 3.0D == b / 3.0D ? "=" : "<";
        }
    }

    public String getName() {
        return this.name;
    }

    public int getInfMark() {
        return this.InfMark;
    }

    public int getMathMark() {
        return this.MathMark;
    }

    public int getEngMark() {
        return this.EngMark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfMark(int infMark) {
        this.InfMark = infMark;
    }

    public void setMathMark(int mathMark) {
        this.MathMark = mathMark;
    }

    public void setEngMark(int engMark) {
        this.EngMark = engMark;
    }
} 