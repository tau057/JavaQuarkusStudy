package naitou_pra2;

public class app {
    public static void main(String[] args) throws Exception {

        // 繰り返し処理
        // コメントアウトは ctrl + /

        // for（開始前の処理；継続条件；ループごとに行う処理）
        for (int i = 1; i <= 9; i++) {
            String resultStr = "";
            for (int j = 1; j <= 9; j++) {
                int result = i * j;// ←i,jが変化しながら、合計81回繰り返される
                resultStr += " " + result;// 表示のために計算結果を保持する
            }

            System.out.println(resultStr);

        }
        // forのインデックスの変数名は自由⇒iでもindexでもOK
        // インデックスを含め、forの中で宣言された変数は、forの中でしか使えない。
    }

}
