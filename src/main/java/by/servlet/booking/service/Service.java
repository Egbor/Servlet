package by.servlet.booking.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Service {
	protected static ExecutorService executorService = Executors.newFixedThreadPool(10);
}
