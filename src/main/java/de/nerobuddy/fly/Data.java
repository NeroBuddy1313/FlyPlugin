package de.nerobuddy.fly;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author m_wei
 * @project FlyPlugin
 * @created 31.08.2022 - 15:14
 */

public final class Data {

    private Data() {
    }

    private static final String PREFIX = "§8[§6Fly§8] ";
    private static final List<UUID> FLY_LIST = new ArrayList<>();

    public static String getPrefix() {
        return PREFIX;
    }

    public static List<UUID> getFlyList() {
        return FLY_LIST;
    }
}
