public class App {

    public static void main(String[] args) throws Exception {

        int clucResult1;
        double clucResult2;

        clucResult1 = culcMulti(5, 6);
        clucResult2 = culcMulti(5.2, 6.5);

        System.out.println(clucResult1);
        System.out.println(clucResult2);

    }

    // 累上を計算する
    public static int culcMulti(int a, int b) {
        int c;

        c = a * b;

        return c;
    }

    // 累上を計算する(オーバーロード)
    public static double culcMulti(double a, double b) {
        double c;

        c = a * b;

        return c;
    }

}
