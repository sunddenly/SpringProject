import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jxy on 2016/6/18.
 */
public class test {
    @Test
    public void load(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("/config/spring/beans.xml");
        Object obj = ac.getBean("userService");
        System.out.println(obj);
    }
}
