
package org.bukkit.permissions;

import java.util.Map;
import java.util.TreeMap;

/**
 * Holds information about a permission attachment on a {@link Permissible} object
 */
public class PermissionAttachment {
    private PermissionRemovedExecutor removed;
    private final TreeMap<String, Boolean> permissions = new TreeMap<String, Boolean>();
    private final Permissible Permissible;

    public PermissionAttachment(Permissible Permissible) {
        this.Permissible = Permissible;
    }

    /**
     * Sets an object to be called for when this attachment is removed from a {@link Permissible}. May be null.
     *
     * @param ex Object to be called when this is removed
     */
    public void setRemovalCallback(PermissionRemovedExecutor ex) {
        removed = ex;
    }

    /**
     * Gets the class that was previously set to be called when this attachment was removed from a {@link Permissible}. May be null.
     *
     * @return Object to be called when this is removed
     */
    public PermissionRemovedExecutor getRemovalCallback() {
        return removed;
    }

    /**
     * Gets the Permissible that this is attached to
     *
     * @return Permissible containing this attachment
     */
    public Permissible getPermissible() {
        return Permissible;
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
     * Sets a permission to the given value, by its fully qualified name
     *
     * @param name Name of the permission
     * @param value New value of the permission
     */
    public void setPermission(String name, boolean value) {
        permissions.put(name.toLowerCase(), value);
        Permissible.recalculatePermissions();
    }

    /**
     * Sets a permission to the given value
     *
     * @param perm Permission to set
     * @param value New value of the permission
     */
    public void setPermission(Permission perm, boolean value) {
        setPermission(perm.getName(), value);
        Permissible.recalculatePermissions();
    }

    /**
     * Removes the specified permission from this attachment.
     *
     * If the permission does not exist in this attachment, nothing will happen.
     *
     * @param name Name of the permission to remove
     */
    public void unsetPermission(String name) {
        permissions.remove(name.toLowerCase());
        Permissible.recalculatePermissions();
    }

    /**
     * Removes the specified permission from this attachment.
     *
     * If the permission does not exist in this attachment, nothing will happen.
     *
     * @param perm Permission to remove
     */
    public void unsetPermission(Permission perm) {
        unsetPermission(perm.getName());
        Permissible.recalculatePermissions();
    }
}
