package extensionComparator;

public interface FileExtensionAnalyzerIf {
    FileExtensionStatus getFileExtensionStatus();
    String getPathToFile();
    void addExtension(StringAndBytesArrayComparable extension);
}
