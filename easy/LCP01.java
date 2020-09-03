/**
 * LCP 01. 猜数字
 */
public class LCP01 {


    public int game(int[] guess, int[] answer) {
        int res =0;
        int i =0;
        while (i<guess.length){
            if (guess[i]== answer[i]){
                res++;
            }
            i++;
        }

        return res;

    }
}
