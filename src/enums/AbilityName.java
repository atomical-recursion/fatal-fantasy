package src.enums;

/**
 * Enumerates the display names of all abilities used in the game.
 * 
 * <p> Each constant overrides {@code toString()} to return a user-friendly
 * name, which is displayed in menus, battle prompts, and character screens. </p>
 * 
 * <p> Abilities are grouped by class: Mage, Rogue, Warrior, and Common Abilities. </p>
 */
public enum AbilityName {
    // Mage Abilities
    ARCANE_BOLT {
        public String toString() {
            return "Arcane Bolt";
        }
    },

    ARCANE_BLAST {
        public String toString() {
            return "Arcane Blast";
        }
    },

    MANA_CHANNEL {
        public String toString() {
            return "Mana Channel";
        }
    },

    LESSER_HEAL {
        public String toString() {
            return "Lesser Heal";
        }
    },

    ARCANE_SHIELD {
        public String toString() {
            return "Arcane Shield";
        }
    },

    // Rogue Abilites
    SHIV {
        public String toString() {
            return "Shiv";
        }
    },

    BACKSTAB {
        public String toString() {
            return "Backstab";
        }
    },

    FOCUS {
        public String toString() {
            return "Focus";
        }
    },

    SMOKE_BOMB {
        public String toString() {
            return "Smoke Bomb";
        }
    },

    SNEAK_ATTACK {
        public String toString() {
            return "Sneak Attack";
        }
    },

    // Warrior Abilities
    CLEAVE {
        public String toString() {
            return "Cleave";
        }
    },

    SHIELD_BASH {
        public String toString() {
            return "Shield Bash";
        }
    },

    IRONCLAD_DEFENSE {
        public String toString() {
            return "Ironclad Defense";
        }
    },

    BLOODLUST {
        public String toString() {
            return "Bloodlust";
        }
    },

    RALLYING_CRY {
        public String toString() {
            return "Rallying Cry";
        }
    },

    // Common Abilites
    DEFEND {
        public String toString() {
            return "Defend";
        }
    },

    RECHARGE {
        public String toString() {
            return "Recharge";
        }
    }
}
