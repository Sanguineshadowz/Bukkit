
package org.bukkit.permissions;

import org.bukkit.Bukkit;

/**
 * Represents a unique permission that may be attached to a {@link Permissable}
 */
public class Permission {
    private final String name;
    private final String[] children;
    private Boolean defaultValue;

    public Permission(String name) {
        this(name, new String[0]);
    }

    public Permission(String name, String[] children) {
        this.name = name;
        this.children = children;
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
     * Gets the unique fully qualified names of the child permissions contained within this permission
     *
     * @return Names of all children permissions
     */
    public String[] getChildrenNames() {
        return children;
    }

    /**
     * Gets the children of this permission
     *
     * @return Permission children
     */
    public Permission[] getChildren() {
        Permission[] result = new Permission[children.length];
        
        for (int i = 0; i < children.length; i++) {
            result[i] = Bukkit.getServer().getPluginManager().getPermission(children[i]);
        }

        return result;
    }

    /**
     * Gets the default value of this permission. This may be null.
     *
     * @return Default value of this permission.
     */
    public Boolean getDefault() {
        return defaultValue;
    }
}
