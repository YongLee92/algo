import java.util.Scanner;

public class DragonCurve {

    static int[] dy = {0,-1,0,1};
    static int[] dx = {1,0,-1,0};

    public static void main(String[] args){

        int n =0;
        int[][] map = new int[102][102];

        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        for(int i =0; i< n; i++){
            int curve_size = 0;
            int[] curve = new int[1024];

            int x,y,d,g;
            x = scan.nextInt();
            y = scan.nextInt();
            d = scan.nextInt();
            g = scan.nextInt();

            curve[curve_size++] = d;
            map[y][x] = 1;

            for(int j= 0; j<g; j++){
                for(int k = curve_size-1;k>=0;k--){
                    curve[curve_size++] = (curve[k]+1)%4; //
                }
            }

            for (int j = 0 ; j<curve_size ; j++){
                y += dy[curve[j]];
                x += dx[curve[j]];
                if(y< 0 || y>= 101 || x<0 || x>101){
                    continue;
                }
                map[y][x] = 1;
            }
        }
        int result =  0;
        for(int y= 0; y<100; y++){
            for(int x = 0; x<100; x++){
                if(map[y][x] == 1 && map[y][x+1] == 1 && map[y+1][x] == 1 && map[y+1][x+1] == 1){
                        result++;
                }
            }
        }
        System.out.println(result);
    }

}
