import java.io.*;
import java.util.Arrays;



public class FileExtensionAnalyzer {
    private byte[] GIF_EXTENSION_1 = "GIF87a".getBytes();
    private byte[] GIF_EXTENSION_2 = "GIF89a".getBytes();
    private byte[] JPG_EXTENSION   = new byte[]{(byte) 0xff, (byte) 0xd8, (byte) 0xff};
    private byte[] firstBytesOfFile;
    private final String pathToFile;
    private FileExtensionStatus fileExtensionStatus;
    public FileExtensionAnalyzer(String pathToFile) {
        this.fileExtensionStatus = new FileExtensionStatus();
        this.pathToFile = pathToFile;
        this.firstBytesOfFile = null;
    }

    public String getPathToFile() {
        return pathToFile;
    }

    private void determineFileTypeFromPath(){
        int dotIndex = pathToFile.indexOf('.');
        String fileExtensionFromPath = pathToFile.substring(dotIndex);
        if(fileExtensionFromPath.equals("txt")){
            fileExtensionStatus.setFileTypeFromPath(FileExtensionStatus.FileType.TXT);
            return;
        }
        else if (fileExtensionFromPath.equals("gif")){
            fileExtensionStatus.setFileTypeFromPath(FileExtensionStatus.FileType.GIF);
            return;
        }
        else if (fileExtensionFromPath.equals("jpg") || fileExtensionFromPath.equals("jpeg")){
            fileExtensionStatus.setFileTypeFromPath(FileExtensionStatus.FileType.JPG);
            return;
        }
        else{
            fileExtensionStatus.setFileTypeFromPath(FileExtensionStatus.FileType.UNDEFINED);
            return;
        }
    }

    private void readBytesFromFile() throws IOException {
        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(pathToFile));){
            firstBytesOfFile = inputStream.readNBytes(10);
        }
    }

    private void determineFileTypeFromFile(){
        if (Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,2), JPG_EXTENSION)){
            fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.JPG);
        } else if(Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,5), GIF_EXTENSION_1)
              || Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,5), GIF_EXTENSION_2)){
            fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.GIF);
        } else {
            fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.UNDEFINED);
        }
    }

    public void readExtensions(){
        try {
            determineFileTypeFromPath();
            readBytesFromFile();
            determineFileTypeFromFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public FileExtensionStatus getFileExtensionStatus() {
        if(fileExtensionStatus.getFileTypeFromFile()==FileExtensionStatus.FileType.NOT_INITIATED
        ||fileExtensionStatus.getFileTypeFromPath()==FileExtensionStatus.FileType.NOT_INITIATED)
            throw new RuntimeException("NotInitializedException: cannto run this function when fileExtensionStatus was not read");
        return fileExtensionStatus;
    }
}
