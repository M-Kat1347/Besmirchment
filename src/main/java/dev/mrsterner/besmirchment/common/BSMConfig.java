package dev.mrsterner.besmirchment.common;

import eu.midnightdust.lib.config.MidnightConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.RequiresRestart;


public class BSMConfig extends MidnightConfig {
    @Entry
    public static boolean enableFinalBroom = true;
    @Entry
    public static boolean enableWitchyDye = true;
    @Entry
    public static boolean enableEliteCoffin = true;
    @Entry
    public static boolean enableLovePotion = true;
    @Entry
    public static boolean enableWerepyrism = true;
    @Entry
    public static boolean enableSunscreen = true;
    @Entry
    public static boolean enableTamableDemons = true;
    @Entry
    public static boolean enableLichdom = true;
        @Entry
        public static int werepyreWeight = 10;
        @Entry
        public static int werepyreMinGroupCount = 1;
        @Entry
        public static int werepyreMaxGroupCount = 1;
        @Entry
        public static boolean enableBeelzebub = true;
        @Entry
        public static int villagerFamiliarReputationBase = 20;
        @Entry
        public static float chickenFamiliarEggChance = 0.005F;
        @Entry
        public static boolean universalFamiliars = true;

}
