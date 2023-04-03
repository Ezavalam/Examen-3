import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lector {
    public void ejecutar(int id){
        
        String path = "emails.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentLine = "";
            int lineNumber = 0;
            FileWriter writer = new FileWriter("176895.txt"); // crea el archivo
            double[] sum = null; // variable para almacenar la suma de los valores por columna
        
            while ((currentLine = br.readLine()) != null && lineNumber <= 945) {
                lineNumber++;
                if (lineNumber < 895) {
                    continue; // saltar las primeras 894 líneas
                }
                String[] values = currentLine.split(",");
                if (sum == null) { // si es la primera línea, inicializar la variable sum
                    sum = new double[values.length - 1]; // restar 1 para omitir la primera columna
                }
                for (int i = 1; i < values.length; i++) { // comenzar en el índice 1 para omitir la primera columna
                    String stringValue = values[i];
                    double value = 0.0;
                    if (!stringValue.equals("") && !stringValue.equals(" ")) { // verifica si la cadena de entrada es un valor numérico válido
                        try {
                            value = Double.parseDouble(stringValue);
                        } catch (NumberFormatException e) {
                            System.out.println("El valor " + stringValue + " no es un número válido.");
                            continue;
                        }
                    }
                    if (!Double.isNaN(value)) { // verifica si el valor convertido es un número válido
                        sum[i - 1] += value; // agregar el valor a la suma de la columna actual
                    }
                }
            }   
            for (int i = 0; i < sum.length; i++) {
                writer.write("Columna "+ i + ", " + sum[i] + "\n"); // imprimir la suma de los valores por columna
            }
            
            writer.close(); // cerrar el archivo
        } catch (IOException e) {
            e.printStackTrace();
        }
           
    }
}
