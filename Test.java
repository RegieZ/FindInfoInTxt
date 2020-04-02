import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        //获取键盘录入对象,获取查询的球员姓名
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球员姓名 ：");
        String playerName = sc.next();

        //Player.txt文件放到项目根目录下
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\80626\\Desktop\\player.txt"));

        //进行文件读取
        String row = null;
        while ((row = in.readLine()) != null) {
            String[] rowArray = row.split("，"); //注意中英文的逗号不同，根据实际需要写
            String player = rowArray[0];
            String team = rowArray[1];
            //判断读取的球员是否存在
            if (playerName.equals(player)) {
                //如果存在就直接输出该球员的球队信息
                System.out.println(player + "所属球队为:" + team);
                //记得关流
                in.close();
                return;
            }
        }
        //如果读完了还没找到，就说明不存在
        System.out.println("没有该球员~~~");
        in.close();
    }
}
