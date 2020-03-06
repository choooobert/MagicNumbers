package extensionComparator;

import java.util.Arrays;
import java.util.List;

public class Extension implements  StringAndBytesArrayComparable<byte[]> {
    private String pathExtension;
    private List<byte[]> firstBytesOfFiles;

    public Extension(String pathExtension, List<byte[]> firstBytesOfFiles) {
        this.pathExtension = pathExtension;
        this.firstBytesOfFiles = firstBytesOfFiles;
    }

    @Override
    public boolean equalsPathExtension(String pathExtension) {
        return this.pathExtension.equals(pathExtension);
    }

    @Override
    public boolean equalsFileExtension(byte[] firstBytesOfFile) {
        if(pathExtension.equals("txt")){
            for(byte t : firstBytesOfFile){
                if(t<32 || t>126) return false;
            }
            return true;
        }
        return firstBytesOfFiles.stream().anyMatch(g -> Arrays.equals(g, Arrays.copyOfRange(firstBytesOfFile,0,g.length)));
    }

//    @Override
//    public boolean equals(Extension extension){
//        return this.pathExtension.equals(extension.pathExtension) &&
//                for ();
//    }

    @Override
    public String toString() {
        return pathExtension;
    }
}
