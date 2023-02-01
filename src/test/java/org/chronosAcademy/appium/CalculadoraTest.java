package org.chronosAcademy.appium;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    private DriverFactory driverFactory;

    @BeforeEach
    public void beforeEach() throws MalformedURLException{
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android", "Nexus 4","uiautomator2",
                "com.android.calculator2", "com.android.calculator2.Calculator");
        driverFactory.setDriver();
    }
    @AfterEach
    public void afterEach(){
        driverFactory.getDriver().quit();
    }

    //@Order(2) ordenar os testes
    @Test
    public void validarMultiplicacao(){

        driverFactory.getDriver().findElement(MobileBy.id("digit_7")).click();
        driverFactory.getDriver().findElement(MobileBy.id("op_mul")).click();
        driverFactory.getDriver().findElement(MobileBy.id("digit_9")).click();
        driverFactory.getDriver().findElement(MobileBy.id("eq")).click();
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();

        assertEquals("63", resultado);
    }
    @Test
    public void validarSoma(){
        clickId("digit_7");
        clickId("op_add");
        clickId("digit_9");
        clickId("eq");

        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
        assertEquals("16", resultado);
    }
    @Test
    public void validarDivisao(){
        clickId("digit_6");
        clickId("op_div");
        clickId("digit_2");
        clickId("eq");

        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
        assertEquals("3", resultado);
    }

    public void clickId(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();
    }
    public void resultadoMensagem(){

    }

}
