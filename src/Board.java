package src;

public class Board {

    private String[][] table;

    public Board() {
        resetBoard();
    }

    public void resetBoard() {
        table = new String[][]{
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", "1", "|", "2", "|", "3", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", "4", "|", "5", "|", "6", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
                {"|", "7", "|", "8", "|", "9", "|"},
                {"+", "-", "+", "-", "+", "-", "+"},
        };
    }

    public void printBoard() {
        for (String[] row : table) {
            for (String cell : row) {
                System.out.print(" " + cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean makeMove(String position, String player) {
        int row = -1, col = -1;

        switch (position) {
            case "1": row = 1; col = 1; break;
            case "2": row = 1; col = 3; break;
            case "3": row = 1; col = 5; break;
            case "4": row = 3; col = 1; break;
            case "5": row = 3; col = 3; break;
            case "6": row = 3; col = 5; break;
            case "7": row = 5; col = 1; break;
            case "8": row = 5; col = 3; break;
            case "9": row = 5; col = 5; break;
            default:
                System.out.println("Invalid position! Choose between 1-9.");
                return false;
        }

        if ("X".equals(table[row][col]) || "O".equals(table[row][col])) {
            System.out.println("Position already taken!");
            return false;
        }

        table[row][col] = player;
        return true;
    }

    public boolean checkWin(String player) {
        return (table[1][1].equals(player) && table[1][3].equals(player) && table[1][5].equals(player)) || // Row 1
                (table[3][1].equals(player) && table[3][3].equals(player) && table[3][5].equals(player)) || // Row 2
                (table[5][1].equals(player) && table[5][3].equals(player) && table[5][5].equals(player)) || // Row 3
                (table[1][1].equals(player) && table[3][1].equals(player) && table[5][1].equals(player)) || // Column 1
                (table[1][3].equals(player) && table[3][3].equals(player) && table[5][3].equals(player)) || // Column 2
                (table[1][5].equals(player) && table[3][5].equals(player) && table[5][5].equals(player)) || // Column 3
                (table[1][1].equals(player) && table[3][3].equals(player) && table[5][5].equals(player)) || // Diagonal 1
                (table[1][5].equals(player) && table[3][3].equals(player) && table[5][1].equals(player));   // Diagonal 2
    }

    public boolean isDraw() {
        for (int i = 1; i < table.length; i += 2) {
            for (int j = 1; j < table[i].length; j += 2) {
                if (!"X".equals(table[i][j]) && !"O".equals(table[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}

