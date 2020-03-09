package extensionComparator;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

abstract class FileByteReader  implements FileExtensionAnalyzerIf{
    protected final String pathToFile;

    public FileByteReader(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    @Override
    public String getPathToFile(){
        return pathToFile;
    }

    @Override
    abstract public FileExtensionStatus getFileExtensionStatus();

    protected byte[] readBytesFromFile(int numberOfBytes) throws IOException {
        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(pathToFile));){
            return inputStream.readNBytes(numberOfBytes);
        }
        catch (Error e){
            e.printStackTrace();
            return null;
        }
    }
}
