package com.mathpar.learning.secretmanager.services;

public interface PropertiesProvider {
    /**
     * This method returns a property value by given key in given namespace
     * @param namespace - namespace to fetch properties from
     * @param propertyKey - key for the property
     * @return fetched property or null if no such property was found in namespace
     */
    String getProperty(String namespace, String propertyKey);

    /**
     * This method returns content of a namespace as raw String
     * @param namespace namespace to return
     * @return raw content of a namespace
     */
    String getNamespace(String namespace);
}
