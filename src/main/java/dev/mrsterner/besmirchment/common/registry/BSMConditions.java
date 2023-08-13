package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.BSMConfig;
import dev.mrsterner.besmirchment.common.Besmirchment;
import vazkii.patchouli.api.PatchouliAPI;

@SuppressWarnings("ConstantConditions")
public class BSMConditions {
    public static void init(){
        PatchouliAPI.get().setConfigFlag("bsm_final_broom", BSMConfig.enableFinalBroom);
        PatchouliAPI.get().setConfigFlag("bsm_witchy_dye", BSMConfig.enableWitchyDye);
        PatchouliAPI.get().setConfigFlag("bsm_elite_coffin", BSMConfig.enableEliteCoffin);
        PatchouliAPI.get().setConfigFlag("bsm_love_potion", BSMConfig.enableLovePotion);
        PatchouliAPI.get().setConfigFlag("bsm_universal_familiars", BSMConfig.universalFamiliars);
        PatchouliAPI.get().setConfigFlag("bsm_werepyres_spawn", BSMConfig.werepyreWeight > 0);
        PatchouliAPI.get().setConfigFlag("bsm_werepyrism", BSMConfig.enableWerepyrism);
        PatchouliAPI.get().setConfigFlag("bsm_beelzebub", BSMConfig.enableBeelzebub);
        PatchouliAPI.get().setConfigFlag("bsm_tamable_Demons", BSMConfig.enableTamableDemons);
        PatchouliAPI.get().setConfigFlag("bsm_sunscreen", BSMConfig.enableSunscreen);
        PatchouliAPI.get().setConfigFlag("bsm_lichdom", BSMConfig.enableLichdom);
        //BSMUtil.register(RecipeConds.RECIPE_CONDITION, "bsm_config", RecipeCondsUtil.stringParam(BSMConditions::getOption));
    }

    public static boolean getOption(String key){
        return switch (key) {
            case "final_broom" -> BSMConfig.enableFinalBroom;
            case "witchy_dye" -> BSMConfig.enableWitchyDye;
            case "elite_coffin" -> BSMConfig.enableEliteCoffin;
            case "love_potion" -> BSMConfig.enableLovePotion;
            case "universal_familiars" -> BSMConfig.universalFamiliars;
            case "sunscreen" -> BSMConfig.enableSunscreen;
            case "lichdom" -> BSMConfig.enableLichdom;
            case "beelzebub" -> BSMConfig.enableBeelzebub;
            default -> false;
        };
    }
}
