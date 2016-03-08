package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Egor P on 01.03.2015.
 */
public class Main {
    private static final int SIZE_FIELD = 8;//размеры поля
    private static final int PAWN = 0;//пешка
    private static final int CASTLE = 1;//ладья
    private static final int HOSS = 2;//конь
    private static final int BISHOP = 3;//слон
    private static final int QUEEN = 4;//королева
    private static final int KING = 5;//король

    /*Вывод доски на экран*/
    public static void outputField(char field[][]) {
        char c;
        int i;
        System.out.print(" ");
        for (i = 0, c = 'a'; i < SIZE_FIELD; i++, c++)
            System.out.print(" " + c);
        for (i = 0; i < SIZE_FIELD; i++) {
            System.out.println();
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE_FIELD; j++)
                System.out.print(field[i][j] + " ");
        }
    }

    public static boolean isAvailable(StringBuilder inputC) {
        int line;
        char column;
        Scanner in = new Scanner(System.in);
        String inputCell = in.next();
        if (inputCell.length() < 2) {
            System.out.println("Введите два значения\n");
            return false;
        } else {
            column = inputCell.charAt(0);
            line = inputCell.charAt(1) - '0';
            if ((1 > line || line > 8) || (column > 'h' || column < 'a')) {
                System.out.println("Указана клетка за пределами поля, введите другое значение\n");
                return false;
            }
        }
        inputC.append(inputCell);
        return true;
    }

    /*Проверка верности введенной клетки*/
    public static String checkInputCell(char field[][], char value) {
        StringBuilder inputC = new StringBuilder();
        String inputCell;
        while (!isAvailable(inputC));
        inputCell = inputC.toString();
        field[inputCell.charAt(1) - '0' - 1][inputCell.charAt(0) - 'a'] = value;
        return inputCell;
    }

    /*Определение типа фигуры и определение допустимости хода*/
    public static boolean getAnswer(int typeFigure, String from, String to) {
        ChessFigure figure = new Pawn();
        switch (typeFigure) {
            case PAWN:
                figure = new Pawn();
                break;
            case CASTLE:
                figure = new Castle();
                break;
            case HOSS:
                figure = new Hoss();
                break;
            case BISHOP:
                figure = new Bishop();
                break;
            case QUEEN:
                figure = new Queen();
                break;
            case KING:
                figure = new King();
                break;
            default:
                break;
        }
        return figure.isRightMove(from, to);
    }

    /*Создание ассоциативного массива фигур*/
    public static void createArrayFigures(Map<String, Integer> figures) {
        figures.put("пешка", 0);
        figures.put("ладья", 1);
        figures.put("конь", 2);
        figures.put("слон", 3);
        figures.put("королева", 4);
        figures.put("король", 5);
    }

    /*Проверка верности ввода названия фигуры, ввод допускается, если такая фигура существует*/
    public static String getFigureName(Map<String, Integer> figures) {
        String figureName;
        Scanner in = new Scanner(System.in);
        figureName = in.next();
        while (!figures.containsKey(figureName.toLowerCase())) {
            System.out.println("\nНеверно введено название фигуры, повторите ввод");
            figureName = in.next();
        }
        return figureName.toLowerCase();
    }

    public static void main(String[] args) {
        char field[][] = {{'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'},
                {'_', '_', '_', '_', '_', '_', '_', '_'}};
        String figureName, from;
        String to;

        Map<String, Integer> figures = new HashMap<String, Integer>();
        createArrayFigures(figures);
        outputField(field);
        System.out.println("\nВведите название фигуры (Пешка, Ладья, Конь, Слон, Королева, Король):");
        figureName = getFigureName(figures);
        System.out.println("Введите начальную позицию фигуры:");
        from = checkInputCell(field, 'S');
        outputField(field);
        System.out.println("\nВведите конечную позицию фигуры:");
        to = checkInputCell(field, 'F');
        outputField(field);
        if (getAnswer(figures.get(figureName), from, to))
            System.out.println("\nМожно выполнить ход");
        else
            System.out.println("\nНельзя выполнить ход");
    }
}