public class VictorianChair extends Chair {
    int age;

    VictorianChair(int age) {
        this.age = age;
    }

    @Override
    int getAge() {
        return age;
    }
}