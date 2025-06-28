package src.enums;

/**
 * Enumerates the available character classes in the game.
 * 
 * <p> This enum defines the three core class types a player can choose from:
 * <ul>
 *   <li> {@code MAGE} - Masters of Arcane Spells </li>
 *   <li> {@code ROGUE} - Agile and Cunning Fighters </li>
 *   <li> {@code WARRIOR} - Resilient Melee combatants </li>
 * </ul>
 * 
 * Each constant overrides {@code toString()} to return a clean, user-friendly display name
 * used in menus and character views.</p>
 */
public enum ClassName {
    MAGE {
        public String toString() {
            return "Mage";
        }
    },

    ROGUE {
        public String toString() {
            return "Rouge";
        }
    },

    WARRIOR {
        public String toString() {
            return "Warrior";
        }
    }
}
