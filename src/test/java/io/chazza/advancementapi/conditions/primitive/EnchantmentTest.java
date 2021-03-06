package io.chazza.advancementapi.conditions.primitive;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.gson.Gson;

public class EnchantmentTest {
    private static final Gson gson = new Gson();
    private Enchantment underTest;

    @Test
    public void testEnchantment_GIVEN_Enchantment_THEN_ExpectJsonToBeWithEnchantment() {
        underTest = Enchantment.builder("minecraft:looting").build();

        String json = gson.toJson(underTest.toJson());
        assertThat(json, is("{\"enchantment\":\"minecraft:looting\"}"));
    }

    @Test
    public void testEnchantment_GIVEN_Levels_THEN_ExpectJsonToBeWithLevels() {
        underTest = Enchantment.builder(Range.builder()).build();

        String json = gson.toJson(underTest.toJson());
        assertThat(json, is("{\"levels\":1}"));
    }

    @Test
    public void testEnchantment_GIVEN_BasicAddEnchantment_THEN_ExpectJsonToBeWithEnchantment() {
        underTest = Enchantment.builder(Range.builder()).enchantment("minecraft:looting").build();

        String json = gson.toJson(underTest.toJson());
        assertThat(json, is("{\"enchantment\":\"minecraft:looting\",\"levels\":1}"));
    }

    @Test
    public void testEnchantment_GIVEN_BasicAddLevels_THEN_ExpectJsonToBeWithLevels() {
        underTest = Enchantment.builder("minecraft:looting").levels(Range.builder()).build();

        String json = gson.toJson(underTest.toJson());
        assertThat(json, is("{\"enchantment\":\"minecraft:looting\",\"levels\":1}"));
    }
}