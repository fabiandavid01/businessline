package co.com.bancolombia.portal.domain.bussinesline.exception;

import org.junit.Assert;
import org.junit.Test;

import co.com.bancolombia.portal.domain.bussinesline.exception.CleanArchitectureException;

public class CleanArchitectureExceptionTest {

    @Test
    public void cleanArchitectureExceptionConstructorTest() {
        CleanArchitectureException exception = new CleanArchitectureException();
        Assert.assertNotNull(exception);
    }

    @Test
    public void cleanArchitectureExceptionMessageTest() {
        CleanArchitectureException exception = new CleanArchitectureException("");
        Assert.assertNotNull(exception);
    }

    @Test
    public void cleanArchitectureExceptionMessageTrowableTest() {
        CleanArchitectureException exception = new CleanArchitectureException("", new Exception().getCause());
        Assert.assertNotNull(exception);
    }

    @Test
    public void cleanArchitectureExceptionTrowableTest() {
        CleanArchitectureException exception = new CleanArchitectureException(new Exception().getCause());
        Assert.assertNotNull(exception);
    }


}
