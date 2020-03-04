public class FileExtensionStatus {
    public FileExtensionStatus() {
        this.fileTypeFromFile=FileType.NOT_INITIATED;
        this.fileTypeFromPath=FileType.NOT_INITIATED;
    }

    public FileType getFileTypeFromPath() {
        return fileTypeFromPath;
    }

    public void setFileTypeFromPath(FileType fileTypeFromPath) {
        this.fileTypeFromPath = fileTypeFromPath;
    }

    public FileType getFileTypeFromFile() {
        return fileTypeFromFile;
    }

    public void setFileTypeFromFile(FileType fileTypeFromFile) {
        this.fileTypeFromFile = fileTypeFromFile;
    }

    private FileType fileTypeFromPath;
    private FileType fileTypeFromFile;

    public enum FileType {
        JPG,
        TXT,
        GIF,
        UNDEFINED,
        NOT_INITIATED
    }

    
}
