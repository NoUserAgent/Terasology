/*
 * Copyright 2014 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.logic.permission;

import com.google.common.base.Predicate;
import org.terasology.entitySystem.entity.EntityRef;

public interface PermissionManager {
    /**
     * Allows the player to use chat commands.
     */
    static final String CHAT_PERMISSION = "chat";
    
    /**
     * Allows the player to use cheats that
     * <ul>
     *     <li>1. have no global impact.</li>
     *     <li>2. don't endanger the stability of the game</li>
     * </ul>
     * The intention is that the permission can be given to all players on a server where players focus on building and
     * not mining.
     */
    static final String CHEAT_PERMISSION = "cheat";

    /**
     * Used to indicate that something requires no permission.
     */
    static final String NO_PERMISSION = "";

    /**
     * Allows the player to edit settings of other users.
     *
     * e.g. adding permissions, renaming them etc.
     */
    static final String USER_MANAGEMENT_PERMISSION = "userManagement";

    /**
     * Allows the player to perform server maintenance tasks like stopping the server.
     */
    static final String SERVER_MANAGEMENT_PERMISSION = "serverManagement";

    /**
     * Allows the player to use debug commands which are not intended to be used on a real server.
     */
    static final String DEBUG_PERMISSION = "debug";

    /**
     * Adds specified permission to the player (client info entity).
     *
     * @param player     Player (client info entity) to add permission to.
     * @param permission Permission to add.
     */
    void addPermission(EntityRef player, String permission);

    /**
     * Checks if the specified player (client info entity) has said permission.
     * Note: Local player is considered to have all the permissions in all situations.
     *
     * @param player     Player (client info entity) to check.
     * @param permission Permission to check.
     * @return If player (client info entity) has permission.
     */
    boolean hasPermission(EntityRef player, String permission);

    /**
     * Checks if the specified player (client info entity) has permission that is accepted by the specified predicate.
     * Note: Local player is considered to have all the permissions in all situations.
     *
     * @param player              Player (client info entity) to check.
     * @param permissionPredicate Permission predicate to check against.
     * @return If player (client info entity) has permission matching the predicate.
     */
    boolean hasPermission(EntityRef player, Predicate<String> permissionPredicate);

    /**
     * Removes specified permission from the player (client info entity).
     *
     * @param player     Player (client info entity) to remove permission from.
     * @param permission Permission to remove.
     */
    void removePermission(EntityRef player, String permission);
}
