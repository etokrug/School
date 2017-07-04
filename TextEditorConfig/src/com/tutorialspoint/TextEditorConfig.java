package com.tutorialspoint;
import org.springframework.context.annotation.*;

/**
 * Created by William on 7/2/2017.
 */

@Configuration
public class TextEditorConfig {
    @Bean
    public TextEditor textEditor(){
        return new TextEditor(spellChecker());
    }
    @Bean
    public SpellChecker spellChecker(){
        return new SpellChecker();
    }

}
