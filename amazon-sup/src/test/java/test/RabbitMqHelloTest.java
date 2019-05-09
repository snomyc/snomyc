package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.snomyc.AmazonApplication;
import com.snomyc.base.mq.hello.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AmazonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;
    

    @Test
    public void hello() throws Exception {
    	for (int i=0; i<1000000; i++) {
    		helloSender.send();
		}
    }
    
    @Test
	public void contextLoads() throws Exception{
		System.out.println("hello web");
	}

}