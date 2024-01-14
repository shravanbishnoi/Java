import java.io.File;

public class dir {
    public static void main(String[] args) {
        String path = "C:\\Users\\Shravan Bishnoi\\OneDrive\\Desktop\\GitHub\\JAVA";

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("File names with full paths:");
            listFilesWithFullPath(directory); 
            System.out.println("\nOnly file names:");
            listOnlyFileNames(directory);
        } else {
            System.out.println("Directory not found or is not a valid directory.");
        }
    }


    public static void listFilesWithFullPath(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    listFilesWithFullPath(file);
                }
            }
        }
    }

    public static void listOnlyFileNames(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    listOnlyFileNames(file);
                }
            }
        }
    }
}
