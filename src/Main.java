import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		try {
			System.out.println("Give path to file : ");
			Scanner scanner = new Scanner(System.in);
			String filePath = scanner.nextLine();
			FileExtensionAnalyzer fileExtensionAnalyzer = new FileExtensionAnalyzer(filePath);
			fileExtensionAnalyzer.readExtensions();
			System.out.println(fileExtensionAnalyzer.getPathToFile() + ", fileType : " + fileExtensionAnalyzer.getFileType());
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
}
