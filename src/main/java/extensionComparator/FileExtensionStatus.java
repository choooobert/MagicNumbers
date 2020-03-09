package extensionComparator;

public class FileExtensionStatus {
    private final String extensionFromFile;
    private final String extensionFromPath;

    public FileExtensionStatus(String extensionFromPath , String extensionFromFile) {
        this.extensionFromFile = extensionFromFile;
        this.extensionFromPath = extensionFromPath;
    }

    public FileExtensionStatus(){
        this.extensionFromFile="undefined";
        this.extensionFromPath="undefined";
    }

    public String getExtensionString() throws Exception{
        if(!extensionFromFile.equals(extensionFromPath)) {
            StringBuilder stringBuilder = new StringBuilder("Extensions detected not equal.\nextension from file : ");
            stringBuilder.append(extensionFromFile).append("\n").append("extension from path : ").append(extensionFromPath);
            throw new Exception(stringBuilder.toString());
        }
        else return extensionFromFile;
    }


}
