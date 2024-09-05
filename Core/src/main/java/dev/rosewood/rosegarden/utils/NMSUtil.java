package dev.rosewood.rosegarden.utils;

import org.bukkit.Bukkit;

public final class NMSUtil {

    private static final int VERSION_NUMBER;
    private static final int MINOR_VERSION_NUMBER;
    private static final boolean IS_PAPER;
    private static final boolean IS_FOLIA;

    static {
        String bukkitVersion = Bukkit.getBukkitVersion();
        String[] parts = bukkitVersion.split("-")[0].split("\\.");

        // Kiểm tra độ dài của mảng trước khi truy cập phần tử
        if (parts.length >= 2) {
            VERSION_NUMBER = Integer.parseInt(parts[1]);
            MINOR_VERSION_NUMBER = parts.length >= 3 ? Integer.parseInt(parts[2]) : 0;
        } else {
            VERSION_NUMBER = 0; // Hoặc giá trị mặc định khác nếu không thể xác định được phiên bản
            MINOR_VERSION_NUMBER = 0;
            Bukkit.getLogger().warning("Cannot determine Bukkit version, defaulting to 0.");
        }

        IS_PAPER = ClassUtils.checkClass("com.destroystokyo.paper.PaperConfig");
        IS_FOLIA = ClassUtils.checkClass("io.papermc.paper.threadedregions.RegionizedServer");
    }

    private NMSUtil() {

    }

    public static int getVersionNumber() {
        return VERSION_NUMBER;
    }
    public static int getMinorVersionNumber() {
        return MINOR_VERSION_NUMBER;
    }
    public static boolean isPaper() {
        return IS_PAPER;
    }
    public static boolean isFolia() {
        return IS_FOLIA;
    }

}
