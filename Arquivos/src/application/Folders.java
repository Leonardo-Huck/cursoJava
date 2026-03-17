package application;

import java.io.File;
import java.util.Scanner;

public class Folders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = scanner.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("\nFOLDERS:");
        for (File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);
        System.out.println("\nFiles");
        for (File file : files){
            System.out.println(file);
        }

        boolean succes = new File(strPath + "/subdir").mkdir();
        System.out.println("\nDirectory created successfully: " + succes);

        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());

        scanner.close();
    }
}
