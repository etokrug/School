package com.tutorialspoint;

/**
 * Created by William on 7/2/2017.
 */
public class TextEditor {
    private SpellChecker spellChecker;

    // Setter for DI

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside of setSpellChecker");
        this.spellChecker = spellChecker;
    }

    // Get the spellChecker

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }
    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
