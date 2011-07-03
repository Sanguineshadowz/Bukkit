
package org.bukkit.permissions;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a unique permission that may be attached to a {@link Permissible}
 */
public class Permission {
    private final String name;
    private final Map<String, Boolean> children = new HashMap<String, Boolean>();
    private boolean defaultValue;
    private String description;

    public Permission(String name) {
        this.name = name.toLowerCase();
    }

    public Permission(String name, Map<String, Boolean> children) {
        this(name);
        this.children.putAll(children);
    }

    /**
     * Returns the unique fully qualified name of this Permission
     *
     * @return Fully qualified name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the children of this permission.
     *
     * If you adjust this map, you must call {@link Permissible#recalculatePermissions()} on any {@link Permissible} objects that contain this permission!
     *
     * @return Permission children
     */
    public Map<String, Boolean> getChildren() {
        return children;
    }

    /**
     * Gets the default value of this permission.
     *
     * @return Default value of this permission.
     */
    public boolean getDefault() {
        return defaultValue;
    }

    /**
     * Sets the default value for this permission.
     *
     * @param value New default value
     */
    public void setDefault(boolean value) {
        this.defaultValue = value;
    }

    /**
     * Gets a brief description of this permission, if set
     *
     * @return Brief description of this permission
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the brief description of this permission.
     * 
     * @param value New description
     */
    public void setDescription(String value) {
        if (value == null) {
            this.description = "";
        } else {
            this.description = value;
        }
    }

    /**
     * Loads a Permission from a map of data, usually used from retrieval from a yaml file.
     *
     * The data may contain the following keys:
     * default: Boolean true or false. If not specified, false.
     * children: Map<String, Boolean> of child permissions. If not specified, empty list.
     * description: Short string containing a very small description of this description. If not specified, empty string.
     *
     * @param name Name of the permission
     * @param data Map of keys
     * @return Permission object
     */
    public static Permission loadPermission(String name, Map<String, Object> data) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        Permission result = new Permission(name);


        if (data.containsKey("default")) {
            try {
                result.setDefault((Boolean)data.get("default"));
            } catch (ClassCastException ex) {
                throw new IllegalArgumentException("'default' key is of wrong type", ex);
            }
        }

        if (data.containsKey("children")) {
            try {
                result.getChildren().putAll((Map<String, Boolean>)data.get("children"));
            } catch (ClassCastException ex) {
                throw new IllegalArgumentException("'children' key is of wrong type", ex);
            }
        }

        if (data.containsKey("description")) {
            try {
                result.setDescription((String)data.get("description"));
            } catch (ClassCastException ex) {
                throw new IllegalArgumentException("'description' key is of wrong type", ex);
            }
        }

        return result;
    }
}
