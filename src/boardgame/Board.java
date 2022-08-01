package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    //Retorna a matriz de peças na linha e coluna
    public Piece piece(int row, int column) {
        return pieces[row][column];
    }

    //Sobrecarga do metodo anterior, retornando a posicao
    public Piece piece(Position position) {
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        //pega a matriz na posição dada e atribui a peça informada
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
