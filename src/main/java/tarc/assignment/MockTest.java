package tarc.assignment;


public class MockTest {
    public static void main(String[] args) {
        String str = "Hello";
        Integer num = 123;

        // 任何东西都可以变成号码
        int hash1 = str.hashCode();
        int hash2 = num.hashCode();

        System.out.println(hash1); // 输出一串数字
        System.out.println(hash2); // 输出数字
    }
}
