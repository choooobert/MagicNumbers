import java.util.Objects;

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
        JPG("jpg"),
        TXT("txt"),
        GIF("gif"),
        UNDEFINED("undefined"),
        NOT_INITIATED("not initiated");
        String fileTypeString;
        private FileType(String fileTypeString){
            this.fileTypeString = fileTypeString;
        }
        @Override
        public String toString(){
            return fileTypeString;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileExtensionStatus that = (FileExtensionStatus) o;
        return fileTypeFromPath == that.fileTypeFromPath &&
                fileTypeFromFile == that.fileTypeFromFile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileTypeFromPath, fileTypeFromFile);
    }
}
