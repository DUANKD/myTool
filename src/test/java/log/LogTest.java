package log;

import com.mytool.model.TestModel;
import com.mytool.model.TestModelOver;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author duankd
 * @ClassName LogTest
 * @date 2021-09-27 17:44:18
 */
public class LogTest {
    @Test
    public void over() {
        Logger logger= LoggerFactory.getLogger(LogTest.class);
        Logger infoLog1= LoggerFactory.getLogger("infoLog1");
        Logger infoLog2= LoggerFactory.getLogger("infoLog2");
        TestModel testModel = new TestModel();
        testModel.setContext("123");
        testModel.setLongNumber(1234L);
        logger.info("logger->"+testModel);
        infoLog1.info("infoLog1->"+testModel);
        infoLog2.info("infoLog2->"+testModel);
    }
}
