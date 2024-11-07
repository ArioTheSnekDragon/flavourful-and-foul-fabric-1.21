package net.atsderg.flavourfulandfoul.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent TESTING_FOOD = new FoodComponent.Builder().nutrition(8).saturationModifier(0.4f)
            .statusEffect((new StatusEffectInstance(StatusEffects.BLINDNESS, 40)), 0.85f).build();

}
