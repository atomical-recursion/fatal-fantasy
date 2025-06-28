package src.enums;

/**
 * Enumerates the class descriptions used in the game for MAGE, ROGUE, and WARRIOR.
 * 
 * <p> Each class description provides a short summary of the class's combat style
 * and strengths. These are used in menus and character detail screens to
 * help players understand their choices. </p>
 * 
 * <p> This enum overrides {@code toString()} to return class descriptions. </p>
 */
public enum ClassDescription {
    MAGE {
        public String toString() {
            return "Mages command arcane energies, specializing in powerful spells and mystical manipulation.";
        }
    },

    ROGUE {
        public String toString() {
            return "Rogues are agile and tricky, relying on precision and debilitating opponents.";
        }
    },

    WARRIOR {
        public String toString() {
            return "Warriors are tough, focusing on direct combat and robust defense.";
        }
    }
}
