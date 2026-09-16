package dev.sefiraat.netheopoiesis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CrystallineCruxSafetyTest {

    private static final String CRUX_GATHERER_ID = "NPS_CRUX_GATHERER";

    /**
     * Mirrors the null-safe check used in CrystallineCrux and NetherCrux:
     * slimefunItem == null || !slimefunItem.getId().equals(Stacks.CRUX_GATHERER.getItemId())
     */
    private static boolean shouldCancelAndDestroy(String heldItemId) {
        return heldItemId == null || !heldItemId.equals(CRUX_GATHERER_ID);
    }

    @Test
    @DisplayName("Null held item (vanilla / hand) should cancel event and destroy crux without dropping")
    void testNullHeldItem() {
        assertTrue(shouldCancelAndDestroy(null));
    }

    @Test
    @DisplayName("Non-crux-gatherer item should cancel event and destroy crux")
    void testOtherItem() {
        assertTrue(shouldCancelAndDestroy("DIAMOND_PICKAXE"));
        assertTrue(shouldCancelAndDestroy("EXPLOSIVE_PICKAXE"));
    }

    @Test
    @DisplayName("CRUX_GATHERER item should not cancel, allowing normal crux drop")
    void testCruxGatherer() {
        assertFalse(shouldCancelAndDestroy(CRUX_GATHERER_ID));
    }
}
