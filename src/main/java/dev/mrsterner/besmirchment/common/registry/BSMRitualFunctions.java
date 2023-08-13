package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.ritualfunction.ColorRitualFunction;
import dev.mrsterner.besmirchment.common.ritualfunction.ReachLichdomRitualFunction;
import moriyashiine.bewitchment.api.registry.RitualFunction;
import moriyashiine.bewitchment.common.registry.BWRegistries;

public class BSMRitualFunctions {
    public static final RitualFunction COLOR = new ColorRitualFunction();
    public static final RitualFunction REACH_LICHDOM = new ReachLichdomRitualFunction();

    public static void init(){
        BSMUtil.register(BWRegistries.RITUAL_FUNCTION, "color", COLOR);
        BSMUtil.register(BWRegistries.RITUAL_FUNCTION, "reach_lichdom", REACH_LICHDOM);
    }
}
