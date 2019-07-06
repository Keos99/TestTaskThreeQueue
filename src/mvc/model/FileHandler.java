package mvc.model;

import java.io.File;
import java.util.List;

public interface FileHandler {
    File getFilePath(String path);
    List<Integer> processFileToIntegerList(File file);
    List<String> processFileToStringList(File file);

}
