import java.io.*;
import java.util.Arrays;
import java.util.Formatter;


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
        String fileExtensionFromPath = pathToFile.substring(dotIndex+1);
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
        if (Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,3), JPG_EXTENSION)){
            fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.JPG);
            return;
        } else if(Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,6), GIF_EXTENSION_1)
              || Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,6), GIF_EXTENSION_2)){
            fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.GIF);
            return;
        } else {
            for(byte b : firstBytesOfFile){
                //txt files do not have magic number. In this case we check if the bytes are readable characters.
                // in ASCII code readable sings are stored on bytes between 31 and 127
                if (b<32 || b>126) {
                    fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.UNDEFINED);
                    return;
                }
                else{
                    fileExtensionStatus.setFileTypeFromFile(FileExtensionStatus.FileType.TXT);
                    return;
                }
            }


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

    public FileExtensionStatus.FileType getFileType() throws Exception {
        if(fileExtensionStatus.getFileTypeFromFile()==FileExtensionStatus.FileType.NOT_INITIATED
        ||fileExtensionStatus.getFileTypeFromPath()==FileExtensionStatus.FileType.NOT_INITIATED)
            throw new Exception("NotInitializedException: cannot run this function when fileExtensionStatus was not read");

        if(fileExtensionStatus.getFileTypeFromFile() != fileExtensionStatus.getFileTypeFromPath())
            throw new Exception("The file extension and inner structure of file do not correspond\n type from file structure : "
                                + fileExtensionStatus.getFileTypeFromFile().toString() +
                                "\n  Type from path : " + fileExtensionStatus.getFileTypeFromPath().toString());

        return fileExtensionStatus.getFileTypeFromFile();
    }
}
