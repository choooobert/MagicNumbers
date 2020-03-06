package extensionComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ExtensionComparator {

    public static void main(String[] args) {
		try {
			System.out.println("Give path to file : ");
			Scanner scanner = new Scanner(System.in);
			String filePath = scanner.nextLine();

			FileExtensionAnalyzerIf fileExtensionAnalyzer = new FileExtensionAnalyzer(filePath, 10);
			fileExtensionAnalyzer.addExtension(new Extension("gif",
					Arrays.asList("GIF87a".getBytes(), "GIF89a".getBytes())));

			fileExtensionAnalyzer.addExtension(new Extension("jpg",
												Arrays.asList(new byte[]{ (byte)0xff, (byte) 0xd8, (byte) 0xff})));
			fileExtensionAnalyzer.addExtension(new Extension("png",
												Arrays.asList(new byte[]{(byte)0x89, (byte)0x50, (byte)0x4E,(byte) 0x47,
																		(byte) 0x0D,(byte) 0x0A,(byte) 0x1A,(byte) 0x0A})));

			fileExtensionAnalyzer.addExtension(new Extension("txt", new ArrayList<>()));
			String fileExtension = fileExtensionAnalyzer.getFileExtensionStatus().getExtensionString();
			System.out.println(new StringBuilder("path to file : ").append(fileExtensionAnalyzer.getPathToFile()).append(" file extension : ").append(fileExtension).toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
    }
}
