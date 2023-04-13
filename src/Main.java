import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el numero de materias");
        int tam = scanner.nextInt();
        String [] materiaCal = new String[tam];

        for (int i=0; i< materiaCal.length; i++){
            System.out.println("Ingresa materia y calificacion ");
            materiaCal [i] = scanner.nextLine();
            scanner.nextLine();
        }

        Main m = new Main();
        double[] calificacion = m.obtenerCalificaciones(materiaCal);
        String[] nombres = m.obtenerNombreMateria(materiaCal);
        int size = calificacion.length;
        double pro = 0;
        for (int i = 0; i < size; i++) {
            pro += calificacion[i] / size;
            System.out.println("Nombre de materia: " + nombres[i] + " Calificación de parcial: " + calificacion[i]);
        }
        System.out.println("El promedio del parcial es: " + m.truncar(pro));
    }

    public double[] obtenerCalificaciones(String[] arr) {
        int size = arr.length;
        double[] cal = new double[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf(" ");
            System.out.println("p1 " + p1);
            String c = arr[i].substring(p1 + 1);
            System.out.println("c " + c);
            cal[i] = Double.parseDouble(c);
        }
        return cal;
    }

    public String[] obtenerNombreMateria(String[] arr) {
        int size = arr.length;
        String[] mat = new String[size];
        for (int i = 0; i < size; i++) {
            int p1 = arr[i].indexOf(" ");
            String c = arr[i].substring(0, p1);
            mat[i] = c;
        }
        return mat;
    }

    public String truncar(double numero) {
        DecimalFormat df = new DecimalFormat("#.0");
        return df.format(numero);
    }
}