package filter;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Logger;

public class getText {
    public String loadid(){ // 평문을 읽음
        String id = "";

        FileChannel fileChannel = null;
        Path path = Paths.get("/home/jisang/admin/WEB-INF/id.txt");

        try {
            fileChannel = FileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            Charset charset = Charset.defaultCharset();

            int byteCount;

            while (true) {
                byteCount = fileChannel.read(byteBuffer);
                if (byteCount == -1) break;
                byteBuffer.flip();
                id += charset.decode(byteBuffer).toString();
                byteBuffer.clear();
            }
        }
        catch(IOException e) {
            Logger.getLogger("파일 오픈 오류");
        }
        finally {
            try{
                if(fileChannel != null)fileChannel.close();
            }
            catch (IOException ex){
                Logger.getLogger("파일 오픈 오류");
            }
        }

        return id;
    }
    public String loadpw(){ // 평문을 읽음
        String password = "";

        FileChannel fileChannel = null;
        Path path = Paths.get("/home/jisang/admin/WEB-INF/password.txt");

        try {
            fileChannel = FileChannel.open(path, StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            Charset charset = Charset.defaultCharset();
            int byteCount;

            while (true) {
                byteCount = fileChannel.read(byteBuffer);
                if (byteCount == -1) break;
                byteBuffer.flip();
                password += charset.decode(byteBuffer).toString();
                byteBuffer.clear();
            }
        }
        catch(IOException e) {
            Logger.getLogger("파일 오픈 오류");
        }
        finally {
            try{
                if(fileChannel != null)fileChannel.close();
            }
            catch (IOException ex){
                Logger.getLogger("파일 오픈 오류");
            }
        }
        return password;
    }
}
