package test.character.reflect;


public class ReflectClass {
    private int nums;
    private String name;

    public ReflectClass() {
        this.nums = 0;
        this.name = "default";
    }

    private ReflectClass(int nums, String name) {
        this.nums = nums;
        this.name = name;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ReflectClass{" +
                "nums=" + nums +
                ", name='" + name + '\'' +
                '}';
    }

}
