
package org.bukkit.permissions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Holds information about a permission attachment on a {@link Permissable} object
 */
public class PermissionAttachment {
    private PermissionRemovedExecutor removed;
    private TreeMap<String, Boolean> permissions = new TreeMap<String, Boolean>();

    /**
     * Sets an object to be called for when this attachment is removed from a {@link Permissable}. May be null.
     *
     * @param ex Object to be called when this is removed
     */
    public void setRemovalCallback(PermissionRemovedExecutor ex) {
        removed = ex;
    }

    /**
     * Gets the class that was previously set to be called when this attachment was removed from a {@link Permissable}. May be null.
     *
     * @return Object to be called when this is removed
     */
    public PermissionRemovedExecutor getRemovalCallback() {
        return removed;
    }

    /**
     * Gets a copy of all set permissions and values contained within this attachment.
     *
     * This map may be modified but will not affect the attachment, as it is a copy.
     *
     * @return Copy of all permissions and values expressed by this attachment
     */
    public Map<String, Boolean> getPermissions() {
        return (Map<String, Boolean>)permissions.clone();
    }

    /**
     * Sets a permission to the given value, by its fully qualified name.
     *
     * A value of "null" will remove the permission override.
     *
     * @param name Name of the permission
     * @param value New value of the permission
     */
    public void setPermission(String name, Boolean value) {
        if (value == null) {
            permissions.remove(name);
        } else {
            permissions.put(name, value);
        }
    }

    /**
     * Sets a permission to the given value.
     *
     * A value of "null" will remove the permission override.
     *
     * @param perm Permission to set
     * @param value New value of the permission
     */
    public void setPermission(Permission perm, Boolean value) {
        setPermission(perm.getName(), value);
    }
}
