import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.webwalker.threads.ITester;
import com.webwalker.threads.ThreadInterupt;

/**
 * 
 */

/**
 * @author Administrator
 * 
 */
public class MyJava {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String url_regexp = "([^\\\\/]+\\.\\w+)$";
		Pattern pattern = Pattern.compile(url_regexp);
		// pattern.matches(regularExpression, url)
		Matcher matcher = pattern
				.matcher("http://spm.shengpay.com/apk/ShengPay-release.apk");

		if (matcher.find()) {
			System.out.println(matcher.group());
		}

		ITester tester = new ThreadInterupt();
		// tester = new ABasicThread();
		// tester = new ShareVarliable();
		// tester = new ThreadShareData();
		// tester = new ThreadJoin();
		// tester = new ThreadSynchronized();
		// tester = new ThreadDeadLock();
		// tester = new ProductorConsumer();
		// tester = new ThreadPoolExecutors();
		// tester = new CallableFuture();
		// tester = new ThreadPoolGroup();
		// tester = new SuspendResume();
		// tester = new SleepLock();
		// tester = new ThreadYield();.
		// tester = new ThreadLock();
		// tester = new LockPerformanceTest();
		//
		// tester.Test();

		// long d1 = System.nanoTime();
		// new MyJava().t2();
		// System.out.println(System.nanoTime() - d1);

		// new Others().test();
	}

	public void t1() {
		for (int i = 0; i < 1000000; i++) {
			t3(i);
		}
	}

	public void t3(int i) {
		System.out.println(i * 100);
	}

	public void t2() {
		for (int i = 0; i < 1000000; i++) {
			Class<?> classType = this.getClass();
			Object invokeOperation;
			try {
				invokeOperation = classType.newInstance();
				Method addMethod = classType.getMethod("t3",
						new Class[] { int.class });
				Object result = addMethod.invoke(invokeOperation,
						new Object[] { i });
			} catch (Exception e) {

			}
		}
	}
}