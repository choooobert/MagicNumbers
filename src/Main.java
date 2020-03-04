public class Main {

    public static void main(String[] args) {
	String[] filePaths = new String[]{"hamburg.jpg", "kod.txt", "rainbow.gif"};
	FileExtensionAnalyzer[] fileExtensionAnalyzers = new FileExtensionAnalyzer[filePaths.length];
	FileExtensionStatus[] fileExtensionStatuses = new FileExtensionStatus[filePaths.length];
	for(int i =0;i<filePaths.length;++i){
	    fileExtensionAnalyzers[i] = new FileExtensionAnalyzer(filePaths[i]);
	    fileExtensionAnalyzers[i].readExtensions();
	    fileExtensionStatuses[i]=fileExtensionAnalyzers[i].getFileExtensionStatus();
		System.out.println(fileExtensionStatuses[i].toString());
	}

    }

}
