package array;
/**
 * 419. Battleships in a Board
 * @author yutian
 *
 */
public class BattleshipsInABoard {
	
	public static int countBattleships(char[][] board) {
        int m = board.length;
        if (m == 0) return 0;
        int n = board[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] == '.') continue;
        		if (i > 0 && board[i - 1][j] == 'X') continue;
        		if (j > 0 && board[i][j - 1] == 'X') continue;
        		res++;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] test = new char[][]{
			{'X', '.', '.', 'X'},
			{'.', '.', '.', 'X'},
			{'.', '.', '.', 'X'}
		};
		
		System.out.println(countBattleships(test));
		
	}

}
