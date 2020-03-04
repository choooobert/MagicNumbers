import java.io.*;
import java.util.Arrays;

public class FileExtension {
    private byte[] GIF_EXTENSION_1 = "GIF87a".getBytes();
    private byte[] GIF_EXTENSION_2 = "GIF89a".getBytes();
    private byte[] JPG_EXTENSION   = new byte[]{(byte) 0xff, (byte) 0xd8, (byte) 0xff};
    private byte[] firstBytesOfFile;
    private final String pathToFile;
    private FileType fileTypeFromPath;
    private FileType fileTypeFromFile;
    public FileExtension(String pathToFile) {
        this.pathToFile = pathToFile;
        this.firstBytesOfFile = null;
    }

    private enum FileType {
        JPG,
        TXT,
        GIF,
        UNDEFINED,
        NOT_INITIATED
    }

    private void determineFileTypeFromPath(){
        int dotIndex = pathToFile.indexOf('.');
        String fileExtensionFromPath = pathToFile.substring(dotIndex);
        if(fileExtensionFromPath.equals("txt")){
            fileTypeFromPath=FileType.TXT;
            return;
        }
        else if (fileExtensionFromPath.equals("gif")){
            fileTypeFromPath=FileType.GIF;
            return;
        }
        else if (fileExtensionFromPath.equals("jpg") || fileExtensionFromPath.equals("jpeg")){
            fileTypeFromPath=FileType.JPG;
            return;
        }
        else{
            fileTypeFromPath=FileType.UNDEFINED;
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
            fileTypeFromFile=FileType.JPG;
        } else if(Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,5), GIF_EXTENSION_1)
              || Arrays.equals(Arrays.copyOfRange(firstBytesOfFile,0,5), GIF_EXTENSION_2)){
            fileTypeFromFile=FileType.GIF;
        } else {
            fileTypeFromFile=FileType.UNDEFINED;
        }
    }
    
}
