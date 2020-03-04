public class FileExtension {
    private byte[] GIF_EXTENSION_1 = "GIF87a".getBytes();
    private byte[] GIF_EXTENSION_2 = "GIF89a".getBytes();
    private byte[] JPG_EXTENSION   = new byte[]{(byte) 0xff, (byte) 0xd8, (byte) 0xff};
    private final String pathToFile;

    public FileExtension(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
