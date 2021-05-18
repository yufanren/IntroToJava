package divisors;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.*;

public class ThreadedMaxDivisors implements Runnable {

	private long min;
	private long max;
	private int id;
	private int numThreads;
	private Entry<Long, Long> result;
	
	public ThreadedMaxDivisors(long min, long max, int id, int numThreads) {
		this.min = min;
		this.max = max;
		this.id = id;
		this.numThreads = numThreads;
	}

	@Override
	public void run() {
		result = maxDivisors(id, numThreads);
	}

	public Entry<Long, Long> maxDivisors(int id, int numThreads)
	{
		long maxDivisors = 0;
		long numFound = 0;
		for (long num = this.min + id; num <= this.max; num += numThreads) {
			int divisors = CountDivisors.countDivisors(num);
			if (divisors >= maxDivisors) {
				maxDivisors = divisors;
				numFound = num;
			}
		}
		return new AbstractMap.SimpleEntry<Long,Long>(numFound, maxDivisors);
	}

	public static void main(String[] args) {

		final int NUM_THREADS = 10;
		long min = 100_000;
		long max = 200_000;
		
		//Set<Thread> threadSet = new HashSet<Thread>();
		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
		long startTime = System.currentTimeMillis();

		ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

		for (int i = 0; i < NUM_THREADS; i++) {
			ThreadedMaxDivisors thread = new ThreadedMaxDivisors(min, max, i, NUM_THREADS);
			executor.execute(thread);
			divisorsSet.add(thread);
		}

		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
  		System.out.println("Execution interrupted! " + e.getMessage());
  		System.exit(-1);
		}
		/* join() tells a thread to wait until it's complete before the rest of the code and proceed.
		 * if we do that for all the threads, then then we can get the results of the threads once
		 * all of them are done
		 *//*
		for (Thread t: threadSet) {
			try {
				t.join();
				System.out.print("Done");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		// at this point, all threads have been completed, since we
		// called the "join()" method on all the threads we created,
		// which forces the code to wait until the thread is finished
		// before we continue
		Entry<Long, Long> threadedResult = new AbstractMap.SimpleEntry<Long, Long>(Long.MIN_VALUE, Long.MIN_VALUE);
		for (ThreadedMaxDivisors tmd : divisorsSet) {
			// presumably you've recorded the results of
			// each ThreadedMaxDivisors run. Pick
			// the largest number with the largest number of
			// divisors
			long currentCount = tmd.result.getValue();
			if (currentCount > threadedResult.getValue() ||
							(currentCount == threadedResult.getValue() && tmd.result.getKey() > threadedResult.getKey())) {
				threadedResult = new AbstractMap.SimpleEntry<Long, Long>(tmd.result.getKey(), tmd.result.getValue());
			}
		}

		System.out.println("\n" + threadedResult.getKey() + "=" + threadedResult.getValue());
		long endTime = System.currentTimeMillis();
		System.out.println("Threaded elapsed time: " + (endTime - startTime));
		startTime = System.currentTimeMillis();
		Entry<Long,Long> e = CountDivisors.maxDivisors(min, max);
		
		long number = e.getKey();
		long numDivisors = e.getValue();
		
		System.out.println("\n" + number + "=" + numDivisors);
		endTime = System.currentTimeMillis();
		
		System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
	}
}
