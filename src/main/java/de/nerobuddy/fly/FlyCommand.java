package de.nerobuddy.fly;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static de.nerobuddy.fly.Data.getFlyList;
import static de.nerobuddy.fly.Data.getPrefix;

/**
 * @author m_wei
 * @project FlyPlugin
 * @created 31.08.2022 - 15:08
 */

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (!(sender instanceof Player)) {
            setTargetFly(sender, args);
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("fly.use")) {
            player.sendMessage(getPrefix() + "§cYou do not have permission to use that command!");
            return true;
        }
        if (!(args.length == 0 || args.length == 1)) {
            sender.sendMessage(getPrefix() + "§6Usage /fly <player>");
            return true;
        } else {
            setTargetFly(sender, args);
        }
        return true;
    }

    private void setTargetFly(final CommandSender sender, final String[] args) {
        Player player;
        UUID uuid;
        if (args.length == 0) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(getPrefix() + "§6Usage /fly <player>");
                return;
            }
            player = (Player) sender;
            uuid = player.getUniqueId();
            if (!getFlyList().contains(uuid)) {
                player.setAllowFlight(true);
                player.setFlying(true);
                getFlyList().add(uuid);
                player.sendMessage(getPrefix() + "§6Flymode §aactivated§6!");
            } else {
                player.setAllowFlight(false);
                player.setFlying(false);
                getFlyList().remove(uuid);
                player.sendMessage(getPrefix() + "§6Flymode §4deactivated§6!");
            }
        } else {
            player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage(getPrefix() + "§cThe player §3" + args[0] + "§c could not be found!");
            } else {
                uuid = player.getUniqueId();
                if (!getFlyList().contains(uuid)) {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    getFlyList().add(uuid);
                    player.sendMessage(getPrefix() + "§6Flymode §aactivated§6!");
                } else {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    getFlyList().remove(uuid);
                    player.sendMessage(getPrefix() + "§6Flymode §4deactivated§6!");
                }
            }
        }

    }

}
