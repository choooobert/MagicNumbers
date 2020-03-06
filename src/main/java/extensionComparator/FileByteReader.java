package extensionComparator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

abstract class FileByteReader {
    protected final String pathToFile;

    public FileByteReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    public String getPathToFile(){
        return pathToFile;
    }
    protected byte[] readBytesFromFile(int numberOfBytes) throws IOException {
        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(pathToFile));){
            return  inputStream.readNBytes(numberOfBytes);
        }
    }
}
