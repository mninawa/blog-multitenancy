package se.callista.blog.service.multi_tenancy.util;

import de.invesdwin.instrument.DynamicInstrumentationLoader;

public final class DynamicInstrumentationLoaderUtils {

    private DynamicInstrumentationLoaderUtils() {}

    private static boolean loaded = false;

    public static void ensureLoaded() {
        if (!loaded) {
            DynamicInstrumentationLoader.waitForInitialized(); //dynamically attach java agent to jvm if not already present
            DynamicInstrumentationLoader.initLoadTimeWeavingContext(); //weave all classes before they are loaded as beans
            loaded = true;
        }
    }
}
