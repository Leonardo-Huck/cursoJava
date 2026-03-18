import java.io.*;
import java.util.*;


public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o caminho do arquivo: ");
        String strPath = scanner.nextLine();

        ///home/leonardo/Java/cursoJava/exercicioArquivos/src/venda.csv

        File path = new File(strPath);

        boolean success = new File(path.getParent() + "/out").mkdir();
        System.out.println("Directory created successfully: " + success);

        List<String> listaDeProdutos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] temporario;
                temporario = line.split(",");

                String produto = temporario[0];
                double valor = Double.parseDouble(temporario[1]);
                int quantidade = Integer.parseInt(temporario[2]);

                Double total = valor * quantidade;

                listaDeProdutos.add(produto + "," + String.format(Locale.US,"%.2f", total));

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        String summary = path.getParent() + "/out/summary.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(summary))) {
            for (String produto : listaDeProdutos) {
                bw.write(produto);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
