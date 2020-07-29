/**
 * 面试题 08.10. 颜色填充
 */
public class LeetCodeFace0810 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color!= newColor){
            dfs(image,sr,sc,color,newColor);
        }

        return image;

    }

    public void dfs(int[][] image,int r,int c,int color,int newColor){
        if(image[r][c]==color){
            image[r][c] = newColor;
            // 上
            if(r>=1){
                dfs(image,r-1,c,color,newColor);
            }
            // 下
            if(r+1<image.length){
                dfs(image,r+1,c,color,newColor);
            }
            // 左
            if(c>=1){
                dfs(image,r,c-1,color,newColor);
            }
            // 右
            if(c+1<image[0].length){
                dfs(image,r,c+1,color,newColor);
            }

        }
    }
}
