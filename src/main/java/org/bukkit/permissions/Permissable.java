
package org.bukkit.permissions;

/**
 * Represents an object that may be assigned permissions
 */
public interface Permissable {
    /**
     * Checks if this object contains an override for the specified permission, by fully qualified name
     *
     * @param name Name of the permission
     * @return true if the permission is set, otherwise false
     */
    public boolean hasPermission(String name);

    /**
     * Checks if this object contains an override for the specified {@link Permission}
     *
     * @param perm Permission to check
     * @return true if the permission is set, otherwise false
     */
    public boolean hasPermission(Permission name);

    /**
     * Gets the value of the specified permission, if set.
     *
     * If a permission override is not set on this object, the default value of the permission will be returned.
     *
     * @param name Name of the permission
     * @return Value of the permission
     */
    public Boolean getPermission(String name);

    /**
     * Gets the value of the specified permission, if set.
     *
     * If a permission override is not set on this object, the default value of the permission will be returned
     *
     * @param perm Permission to get
     * @return Value of the permission
     */
    public Boolean getPermission(Permission name);

    /**
     * Adds a new {@link PermissionAttachment} with a single permission by name and value
     *
     * @param name Name of the permission to attach
     * @param value Value of the permission. If null, it will not be added and the attachment will be empty.
     *
     * @return The PermissionAttachment that was just created
     */
    public PermissionAttachment addAttachment(String name, Boolean value);

    /**
     * Adds a new empty {@link PermissionAttachment} to this object
     *
     * @return The PermissionAttachment that was just created
     */
    public PermissionAttachment addAttachment();

    /**
     * Removes the given {@link PermissionAttachment} from this object
     *
     * @param attachment Attachment to remove
     * @throws IllegalArgumentException Thrown when the specified attachment isn't part of this object
     */
    public void removeAttachment(PermissionAttachment attachment);
}
