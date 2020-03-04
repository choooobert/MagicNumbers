public class Main {

    public static void main(String[] args) {
	String[] filePaths = new String[]{"hamburg.jpg", "rainbow.gif", "kod.txt"};
	FileExtensionAnalyzer[] fileExtensionAnalyzers = new FileExtensionAnalyzer[filePaths.length];
		FileExtensionStatus.FileType[] fileTypes = new FileExtensionStatus.FileType[filePaths.length];
	try {
		for (int i = 0; i < filePaths.length; ++i) {
			fileExtensionAnalyzers[i] = new FileExtensionAnalyzer(filePaths[i]);
			fileExtensionAnalyzers[i].readExtensions();

			System.out.println(fileExtensionAnalyzers[i].getPathToFile() + " : " + fileExtensionAnalyzers[i].getFileType());
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
    }

}
