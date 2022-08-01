package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
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
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        //pega a matriz na posição dada e atribui a peça informada
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //verifica se a posicao ta dentro do tabuleiro dado uma linha e uma coluna
    private boolean positionExists(int row, int column) {
        if (!positionExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        /*
            rows = altura do tabuleiro
            columns = quantidade de colunas do tabuleiro
         */
        return row >= 0 && row < rows && column >= 0 &&  column < columns;
    }

    public boolean positionExists(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return piece(position) != null;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
