package src.enums;

/**
 * Enumerates textual descriptions for each ability in the game.
 * 
 * <p> Each constant in this enum overrides {@code toString()} to return a
 * description of what the ability does in combat.
 * These descriptions are used throughout the UI for player reference. </p>
 * 
 * <p> Grouped by class: Mage, Rogue, Warrior, and Common Abilities. </p>
 */
public enum AbilityDescription {
    // Mage Abilities
    ARCANE_BOLT {
        public String toString() {
            return "Launch a basic magical projectile that deals 20 arcane damage to the target.";
        }
    },

    ARCANE_BLAST {
        public String toString() {
            return "Unleash a burst of fiery energy, dealing 65 arcane damage to the target.";
        }
    },

    MANA_CHANNEL {
        public String toString() {
            return "Draw upon ambient magical energy to restore your own. Restores 15 EP.";
        }
    },

    LESSER_HEAL {
        public String toString() {
            return "Weave a minor healing spell to mend your wounds. Restores 40 HP.";
        }
    },

    ARCANE_SHIELD {
        public String toString() {
            return "Conjure a protective barrier of mystical energy around yourself. You do not take any damage for the round.";
        }
    },

    // Rogue Abilites
    SHIV {
        public String toString() {
            return "A quick, precise stab that deals 20 physical damage.";
        }
    },

    BACKSTAB {
        public String toString() {
            return "Strike a vital point and deal 35 points of physical damage.";
        }
    },

    FOCUS {
        public String toString() {
            return "Take a moment to concentrate, restoring your mental energy. Restores 10 EP.";
        }
    },

    SMOKE_BOMB {
        public String toString() {
            return "Throw a smoke bomb, making you harder to hit. You have a 50% chance of evading any incoming attacks in the current round.";
        }
    },

    SNEAK_ATTACK {
        public String toString() {
            return "You rely on your agility to evade your opponent, taking no damage from any of their attacks, while you deal 45 physical damage to them.";
        }
    },

    // Warrior Abilities
    CLEAVE {
        public String toString() {
            return "A sweeping strike that deals 20 physical damage.";
        }
    },

    SHIELD_BASH {
        public String toString() {
            return "Slam your shield into the opponent, dealing 35 physical damage.";
        }
    },

    IRONCLAD_DEFENSE {
        public String toString() {
            return "Brace yourself, effectively taking no damage for the current round.";
        }
    },

    BLOODLUST {
        public String toString() {
            return "Tap into your inner fury, restoring a small amount of health. Restores 30 HP.";
        }
    },

    RALLYING_CRY {
        public String toString() {
            return "Let out a powerful shout, inspiring yourself and recovering 12 EP.";
        }
    },

    // Common Abilites
    DEFEND {
        public String toString() {
            return "Take a stance and take half of the damage.";
        }
    },

    RECHARGE {
        public String toString() {
            return "Take a rest to recover 5 EP.";
        }
    }
}
