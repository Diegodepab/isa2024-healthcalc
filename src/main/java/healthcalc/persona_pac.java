package healthcalc;

public class persona_pac implements Person{
    private float weight;
    private float height;
    private int age;
    private Gender gender;

    public persona_pac(float weight, float height, int age, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public persona_pac(float height, Gender gender) {
        this.gender = gender;
        this.height = height;
    }

    @Override
    public float weight() {
        return this.weight;
    }

    @Override
    public float height() {
        return this.height;
    }

    @Override
    public Gender gender() {
        return this.gender;
    }

    @Override
    public int age() {
        return this.age;
    }
}
