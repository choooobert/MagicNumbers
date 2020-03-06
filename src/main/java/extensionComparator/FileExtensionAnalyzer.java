package extensionComparator;
import java.util.ArrayList;
import java.util.List;

public class FileExtensionAnalyzer extends FileByteReader{

    private byte[] firstBytesOfFile;
    private List<StringAndBytesArrayComparable> extensions;
    private final int numberOfBytes;
    public FileExtensionAnalyzer(String pathToFile, int numberOfBytes) {
        super(pathToFile);
        this.firstBytesOfFile = null;
        this.numberOfBytes=numberOfBytes;
        this.extensions = new ArrayList<>();
    }

    public void addExtension(StringAndBytesArrayComparable extension){
        extensions.add(extension);
    }
    private String getFileTypeFromPath(){
        int dotIndex = pathToFile.lastIndexOf('.');
        String fileExtensionFromPath = pathToFile.substring(dotIndex+1);

        StringAndBytesArrayComparable extension =extensions.stream().filter(g->g.equalsPathExtension(fileExtensionFromPath)).findFirst().orElse(null);
        if(extension == null) return "undefined";
        else return extension.toString();
    }

    private String getFileTypeFromFile() throws Exception{
        firstBytesOfFile = readBytesFromFile(numberOfBytes);
        if(firstBytesOfFile ==  null){
            throw new Exception("Data was not read from file");
        }
        firstBytesOfFile = readBytesFromFile(numberOfBytes);
        StringAndBytesArrayComparable extension =extensions.stream().filter(g->g.equalsFileExtension(firstBytesOfFile)).findFirst().orElse(null);
        if(extension==null) return "undefined";
        else return extension.toString();
    }

    public FileExtensionStatus getFileExtensionStatus(){
        try {
            return new FileExtensionStatus(getFileTypeFromPath(), getFileTypeFromFile());
        }
        catch(Exception e){
            System.out.println("Error occured when reading file " + getPathToFile());
            e.printStackTrace();
            return new FileExtensionStatus();
        }
    }

}
