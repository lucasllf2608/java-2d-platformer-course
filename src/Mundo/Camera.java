package Mundo;

public class Camera {
    public static int x, y;

    public static int clamp(int atual, int min, int max) {
        if (max < min) {
            return min;
        }
        if (atual < min) {
            atual = min;
        }
        if (atual > max) {
            atual = max;
        }
        return atual;
    }
}
