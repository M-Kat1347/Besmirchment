package dev.mrsterner.besmirchment.common.registry;

import dev.mrsterner.besmirchment.common.Besmirchment;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;

public class BSMSounds {
    public static final SoundEvent ENTITY_GENERIC_SPIT = SoundEvent.of(Besmirchment.id("entity.generic.spit"));
    public static final SoundEvent LICH_REVIVE = SoundEvent.of(Besmirchment.id("entity.lich.revive"));

    public static final SoundEvent BEELZEBUB_AMBIENT = SoundEvent.of(Besmirchment.id("entity.beelzebub.ambient"));
    public static final SoundEvent BEELZEBUB_HURT = SoundEvent.of(Besmirchment.id("entity.beelzebub.hurt"));
    public static final SoundEvent BEELZEBUB_DEATH = SoundEvent.of(Besmirchment.id("entity.beelzebub.death"));
    public static void init(){
        BSMUtil.register(Registries.SOUND_EVENT, "entity.generic.spit", ENTITY_GENERIC_SPIT);
        BSMUtil.register(Registries.SOUND_EVENT, "entity.beelzebub.ambient", BEELZEBUB_AMBIENT);
        BSMUtil.register(Registries.SOUND_EVENT, "entity.beelzebub.hurt", BEELZEBUB_HURT);
        BSMUtil.register(Registries.SOUND_EVENT, "entity.beelzebub.death", BEELZEBUB_DEATH);
    }
}
