package de.nerobuddy.fly;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

/**
 * @author m_wei
 * @project FlyPlugin
 * @created 31.08.2022 - 15:04
 */

public final class Fly extends JavaPlugin {

    private static Fly instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        Objects.requireNonNull(getCommand("fly")).setExecutor(new FlyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Fly getInstance() {
        return instance;
    }
}
