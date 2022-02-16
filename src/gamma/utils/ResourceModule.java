package gamma.utils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import sierra.injection.SAIBinder;
import sierra.injection.SAIModule;

public class ResourceModule implements SAIModule {

	public ResourceModule() {
		super();
	}

	@Override
	public void configure(SAIBinder binder) {
		final AtomicInteger launcherInstance = new AtomicInteger(0);
		binder.bind(Integer.class).named("Launcher Instance").toSupplier(launcherInstance::incrementAndGet);

		binder.bind(Random.class).toSingleton(Random.class);
	}

}
