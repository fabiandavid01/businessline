package app.demo.technical.logs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.com.bancolombia.portal.bussinesline.technical.logs.LoggerAdapter;

public class LoggerAdapterTest {

    LoggerAdapter adapter;

    @Before
    public void init() {
        adapter = new LoggerAdapter();
    }

    @Test
    public void setLoggerTest() {
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterDebugMessageTest() {
        adapter.debug("");
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterErrorMessageTest() {
        adapter.error("");
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterErrorMessageWithExceptionTest() {
        adapter.error("", new Exception(""));
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterInfoMessageTest() {
        adapter.info("");
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterWarnMessageWithExceptionTest() {
        adapter.warn("", new Exception(""));
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterWarnMessageTest() {
        adapter.warn("");
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterFatlaMessageWithExceptionTest() {
        adapter.fatal("", new Exception(""));
        Assert.assertNotNull(adapter);
    }

    @Test
    public void loggerAdapterFatalMessageTest() {
        adapter.fatal("");
        Assert.assertNotNull(adapter);
    }
}
