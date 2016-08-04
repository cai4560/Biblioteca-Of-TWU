import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BaseResource {
    protected PrintStream console = null;
    protected ByteArrayOutputStream bytes = null;

    @Before
    public void setUp() throws Exception {
        bytes = new ByteArrayOutputStream();    // 分配空间
        console = System.out;                   // 获取System.out 输出流的句柄
        System.setOut(new PrintStream(bytes));  // 将原本输出到控制台Console的字符流 重定向 到 bytes
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(console);
    }
}
