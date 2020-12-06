/**
 * This file contains general level intents.
 */
package furhatos.app.cookingbot.nlu

import furhatos.nlu.Intent
import furhatos.util.Language


class GeneralOptions: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("What options do I have?",
                "What can I do?",
                "What do you suggest?",
                "which options do I have?",
                "options")
    }
}