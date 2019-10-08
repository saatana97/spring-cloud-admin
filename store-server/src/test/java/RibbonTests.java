import cn.saatana.store.StoreServerApplication;
import cn.saatana.store.TestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StoreServerApplication.class})
public class RibbonTests {
	@Autowired
	private TestController test;

	@Test
	public void test1() throws InterruptedException {
		long start = System.currentTimeMillis();
		int coreSize = 5;
		int maxSize = 1000;
		int live = 60;
		int count = maxSize * 1;
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(count);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(coreSize, maxSize, live, TimeUnit.SECONDS, queue);
		final CountDownLatch cdl = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			tpe.execute(() -> {
				System.out.println(test.index(System.currentTimeMillis() + ""));
				cdl.countDown();
			});
		}
		cdl.await();
		System.out.println("测试结束：" + (System.currentTimeMillis() - start));
	}

}
