package dev.sefiraat.netheopoiesis;

import dev.sefiraat.netheopoiesis.api.plant.breeding.BreedResultType;
import dev.sefiraat.netheopoiesis.api.plant.breeding.BreedingPair;
import org.bukkit.block.BlockFace;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BreedingTest {

    @Test
    @DisplayName("BreedingPair should recognize both symmetrical combinations of parent IDs")
    void testBreedingPairSymmetry() {
        BreedingPair pair = new BreedingPair(null, "SEED_A", "SEED_B", 0.5, 0.2);
        assertTrue(pair.isBreedPossible("SEED_A", "SEED_B"));
        assertTrue(pair.isBreedPossible("SEED_B", "SEED_A"));
        assertFalse(pair.isBreedPossible("SEED_A", "SEED_C"));
        assertFalse(pair.isBreedPossible("SEED_C", "SEED_B"));
    }

    @Test
    @DisplayName("BreedingPair should recognize self-breeding combinations")
    void testSelfBreedingPair() {
        BreedingPair pair = new BreedingPair(null, "SEED_A", "SEED_A", 0.5, 0.2);
        assertTrue(pair.isBreedPossible("SEED_A", "SEED_A"));
        assertFalse(pair.isBreedPossible("SEED_A", "SEED_B"));
    }

    @Test
    @DisplayName("Breeding directions must contain all 4 cardinal directions")
    void testBreedingDirections() {
        Set<BlockFace> directions = Set.of(
            BlockFace.NORTH,
            BlockFace.SOUTH,
            BlockFace.EAST,
            BlockFace.WEST
        );
        assertEquals(4, directions.size());
        assertTrue(directions.contains(BlockFace.NORTH));
        assertTrue(directions.contains(BlockFace.SOUTH));
        assertTrue(directions.contains(BlockFace.EAST));
        assertTrue(directions.contains(BlockFace.WEST));
    }

    @Test
    @DisplayName("Breed chances should produce valid BreedResultType")
    void testBreedRoll() {
        BreedingPair guaranteedPair = new BreedingPair(null, "SEED_A", "SEED_B", 1.0, 1.0);
        assertEquals(BreedResultType.SUCCESS, guaranteedPair.testBreed("SEED_A", "SEED_B"));

        BreedingPair zeroPair = new BreedingPair(null, "SEED_A", "SEED_B", 0.0, 0.0);
        assertEquals(BreedResultType.FAIL, zeroPair.testBreed("SEED_A", "SEED_B"));

        BreedingPair notPair = new BreedingPair(null, "SEED_A", "SEED_B", 1.0, 1.0);
        assertEquals(BreedResultType.NOT_PAIR, notPair.testBreed("SEED_X", "SEED_Y"));
    }
}
