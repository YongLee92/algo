import java.util.Scanner;

public class Quitingjob {

    static int maxDay, maxMoney;
    static int []daySpend = new int [20], moneyEarn = new int [20];

    public static void dfs(int day, int result){
        if(day == maxDay) {
            maxMoney = Math.max(maxMoney, result);
            return;
        }
        dfs(day+1, result);
        if (day + daySpend[day] <= maxDay) {
            dfs(day+daySpend[day], result + moneyEarn[day]);
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        maxDay = scan.nextInt();
        for(int i= 0; i<maxDay; i++){
            daySpend[i] = scan.nextInt();
            moneyEarn[i] = scan.nextInt();
        }
        dfs(0,0);
        System.out.println(maxMoney);
        scan.close();
    }
}
