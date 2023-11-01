package com.resolver.utils;

import java.io.File;
import java.net.URL;

/**
 * A utility class for working with resource files.
 */
public class FileUtil {
	   /**
     * Get a file object for a resource by its name.
     *
     * @param resourceName The name of the resource file, including its path if needed.
     * @return A File object representing the resource file, or null if the resource is not found.
     */
    public static File getResourceFile(String resourceName) {
    	
    	// Get the URL of the resource.
        URL resourceUrl = FileUtil.class.getResource(resourceName);
        // Convert the URL to a file path.
        if (resourceUrl != null) {
            String filePath = resourceUrl.getFile();
            return new File(filePath);
        } else {
        	//resouce not found
            return null;
        }
    }
}