package others;

/*In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a \ is represented as "\\".)

Return the number of regions.



Example 1:

Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:

Example 2:

Input:
[
  " /",
  "  "
]
Output: 1
Explanation: The 2x2 grid is as follows:

Example 3:

Input:
[
  "\\/",
  "/\\"
]
Output: 4
Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.)
The 2x2 grid is as follows:

Example 4:

Input:
[
  "/\\",
  "\\/"
]
Output: 5
Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to \/.)
The 2x2 grid is as follows:

Example 5:

Input:
[
  "//",
  "/ "
]
Output: 3
Explanation: The 2x2 grid is as follows:



Note:

1 <= grid.length == grid[0].length <= 30
grid[i][j] is either '/', '\', or ' '.
*/public class RegionsCutBySlashes {

	/*
	 * Runtime: 8 ms, faster than 30.34% of Java online submissions for Regions Cut By Slashes.
	 * Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Regions Cut By Slashes.
	 */
	public int regionsBySlashes(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int cnt = 0;
        int[][] g = new int[n*3][m*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)=='/'){
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                }else if(grid[i].charAt(j)=='\\'){
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        for(int i=0;i<g.length;i++){
            for(int j=0;j<g[0].length;j++){
                if(g[i][j]==0){
                    dfs(g,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    void dfs(int[][] g, int i, int j){
        int n = g.length, m = g[0].length;
        if(i<0 || i>=n || j<0 || j>=m || g[i][j]==1) return;
        g[i][j]=1;
        int d[] = {0,-1,0,1,0};
        for(int k=0;k<4;k++){
            dfs(g,i+d[k],j+d[k+1]);
        }
    }

	public static void main(String[] args) {

		String[] grid = {};

		System.out.println(new RegionsCutBySlashes().regionsBySlashes(grid));
	}
}
