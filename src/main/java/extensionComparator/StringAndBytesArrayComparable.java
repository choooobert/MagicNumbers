package extensionComparator;

public interface StringAndBytesArrayComparable<Type> {
    boolean equalsPathExtension(String pathExtension);
    boolean equalsFileExtension(Type firstBytesOfFile);
}
