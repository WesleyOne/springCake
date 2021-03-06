package io.github.wesleyone.spring.core.c5.c4;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author http://wesleyone.github.io/
 */
public class MyAspectTest {

    @Test
    public void aopTest() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("io.github.wesleyone.spring.core.c5.c4");
        TargetObjectInterface myTargetObject = applicationContext.getBean(TargetObjectInterface.class);
        String sayReturn = myTargetObject.say("wesleyOne");
        Assert.assertEquals("Hello,wesleyOne bro.", sayReturn);
    }

    @Test
    public void aopExceptionTest() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext("io.github.wesleyone.spring.core.c5.c4");
        TargetObjectInterface myTargetObject = applicationContext.getBean(TargetObjectInterface.class);
        try {
            myTargetObject.say(new RuntimeException("fake exception"));
            Assert.fail();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
            Assert.assertEquals("fake exception", throwable.getMessage());
        }
    }
}
