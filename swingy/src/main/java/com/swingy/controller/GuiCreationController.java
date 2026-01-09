package com.swingy.controller;

import static com.swingy.utils.Constants.*;

import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import com.swingy.model.Characters;
import com.swingy.model.CharactersFactory;

public class GuiCreationController {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static String createHero(Game rpg, HeroCreationRequest request) {

        Set<ConstraintViolation<HeroCreationRequest>> violations = validator.validate(request);

        if (!violations.isEmpty()) {
            // Retourne le message de la première erreur
            return violations.iterator().next().getMessage();
        }

        String inputName = request.getInputName();

        // Validation métier supplémentaire
        if (rpg.heroExists(inputName) || inputName.equalsIgnoreCase("x")) {
            return FORBIDDEN_CHAR;  // Ou un message plus spécifique
        }

        String characterClass = switch (request.getSelectedClass()) {
            case "Warrior" -> WARRIOR_CLASS;
            case "Mage" -> MAGE_CLASS;
            case "Archer" -> ARCHER_CLASS;
            case "Paladin" -> PALADIN_CLASS;
            case "Assassin" -> ASSASSIN_CLASS;
            default -> "";
        };

        Characters newHero = CharactersFactory.getInstance().newCharacters(HERO_TYPE, inputName, characterClass);
        String att = Integer.toString(newHero.getAttack());
        String def = Integer.toString(newHero.getDefense());
        String hp = Integer.toString(newHero.getMaxHitPoint());

        rpg.registerHeroName(inputName);
        rpg.getListAvaible().add(newHero);

        return "<html><div align='center'>"
            + "NAME<br/>"
            + "<b style='font-size: 25px'>" + inputName + "</b><br/><br/>"
            + "CLASS<br/>"
            + "<b style='font-size: 25px'>" + request.getSelectedClass() + "</b><br/><br/>"
            + "ATT<br/>"
            + "<b style='font-size: 25px'>" + att + "</b><br/><br/>"
            + "DEF<br/>"
            + "<b style='font-size: 25px'>" + def + "</b><br/><br/>"
            + "HP<br/>"
            + "<b style='font-size: 25px'>" + hp + "</b>"
            + "</div></html>";
    }
}
