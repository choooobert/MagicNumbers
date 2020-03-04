public class Main {

    public static void main(String[] args) {
	String[] filePaths = new String[]{"hamburg.jpg", "kod.txt", "rainbow.gif"};
	FileExtensionAnalyzer[] fileExtensionAnalyzers = new FileExtensionAnalyzer[filePaths.length];
	for(int i =0;i<filePaths.length;++i){
	    fileExtensionAnalyzers[i] = new FileExtensionAnalyzer(filePaths[i]);
	}

    }

}
