/**
    This file contains greeting procedure intents.
 */

package furhatos.app.cookingbot.nlu



import furhatos.app.cookingbot.knowledgebase.Step
import furhatos.nlu.ComplexEnumEntity
import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.nlu.common.Number
import furhatos.util.Language




class CookingDesire() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I want to cook", "let's make dinner", "I want to make a dish", "I want to prepare a meal")
    }
}
class Food : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("dinner", "food", "meal", "breakfast")
    }
}

class GiveRateDesire(var food : Food? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I want to rate my @food", "rate","rank", "Let's give a score")
    }
}


class FindRecipeDesire() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I don't know what to make yet", "I want to find a recipe", "let's make dinner plans")
    }
}

