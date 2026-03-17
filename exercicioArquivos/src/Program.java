import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o caminho do arquivo: ");
        String strPath = scanner.nextLine();

        ///home/leonardo/Java/cursoJava/exercicioArquivos/venda.csv

        File path = new File(strPath);
        boolean success = new File(strPath + "/out").mkdir();
        System.out.println("Directory created successfully: " + success);

        List<String> listaDeProdutos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String summary = path.getPath() + "/out/summary.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
