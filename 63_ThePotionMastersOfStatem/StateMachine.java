public class StateMachine {
    private Potion currentPotion;

    public StateMachine() {
        currentPotion = Potion.WATER;
    }

    public void addIngredient(Ingredient ingredient) {
        currentPotion = switch (currentPotion) {
            case WATER -> (ingredient == Ingredient.STARDUST ? Potion.ELIXIR : Potion.RUINED_POTION);
            case ELIXIR -> {
                Potion result;
                if (ingredient == Ingredient.SNAKE_VENOM) {
                    result = Potion.POISON_POTION;
                } else if (ingredient == Ingredient.DRAGON_BREATH) {
                    result = Potion.FLYING_POTION;
                } else if (ingredient == Ingredient.SHADOW_GLASS) {
                    result = Potion.INVISIBILITY_POTION;
                } else if (ingredient == Ingredient.EYESHINE_GEM) {
                    result = Potion.NIGHT_SIGHT_POTION;
                } else {
                    result = Potion.RUINED_POTION;
                }
                yield result;
            }
            case NIGHT_SIGHT_POTION -> (ingredient == Ingredient.SHADOW_GLASS ? Potion.CLOUDY_BREW : Potion.RUINED_POTION);
            case POISON_POTION, FLYING_POTION -> Potion.RUINED_POTION;
            case INVISIBILITY_POTION -> (ingredient == Ingredient.EYESHINE_GEM ? Potion.CLOUDY_BREW : Potion.RUINED_POTION);
            case CLOUDY_BREW -> (ingredient == Ingredient.STARDUST ? Potion.WRAITH_POTION: Potion.RUINED_POTION);
            case WRAITH_POTION, RUINED_POTION -> currentPotion;
        };
    }

    public Potion getCurrentPotion() {
        return currentPotion;
    }

    public void startOver() {
        currentPotion = Potion.WATER;
    }
}
