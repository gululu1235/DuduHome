import com.duduhome.simpleweb.data.NoteDaoMySQLImpl;
import org.junit.Test;

public class NoteDaoMySQLImplTest {
    @Test
    public void test() throws Exception {
        NoteDaoMySQLImpl noteDao = new NoteDaoMySQLImpl("root", "1234", "localhost:3306", "simpleweb", "notes");
        noteDao.start();
        System.out.println(noteDao.queryNoteByContent("test", null));
        noteDao.stop();
    }
}
