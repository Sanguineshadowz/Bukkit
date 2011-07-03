
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

    public Permission(String name) {
        this.name = name;
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
}
