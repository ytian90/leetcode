package lintcode.systemdesign.chapter7;

import java.util.HashMap;
import java.util.Map;

/**
 * 566. GFS Client
 */
public class GFSClient extends BaseGFSClient{
    public int chunkSize;
    public Map<String, Integer> chunkNum;

    public GFSClient(int chunkSize) {
        this.chunkSize = chunkSize;
        this.chunkNum = new HashMap<>();
    }

    public String read(String filename) {
        if (!chunkNum.containsKey(filename)) {
            return null;
        }
        StringBuffer content = new StringBuffer();
        for (int i = 0; i < chunkNum.get(filename); i++) {
            String sub_content = readChunk(filename, i);
            if (sub_content != null) {
                content.append(sub_content);
            }
        }
        return content.toString();
    }

    public void write(String filename, String content) {
        int length = content.length();
        int num = (length - 1) / chunkSize + 1;
        chunkNum.put(filename, num);
        for (int i = 0; i < num; i++) {
            int start = i * chunkSize;
            int end = i == num - 1 ? length : (i + 1) * chunkSize;
            String sub_content = content.substring(start, end);
            writeChunk(filename, i, sub_content);
        }
    }
}

class BaseGFSClient {
    private Map<String, String> chunk_list;
    public BaseGFSClient() {}
    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return null;
    }
    public void writeChunk(String filename, int chunkIndex, String content) {
          // Write a chunk to GFS
    }
}

