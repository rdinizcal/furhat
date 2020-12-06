/**
 * This file contains select recipe level intents.
 */

package furhatos.app.cookingbot.nlu

import furhatos.app.cookingbot.knowledgebase.*
import furhatos.nlu.*
import furhatos.nlu.grammar.Grammar
import furhatos.nlu.kotlin.grammar
import furhatos.nlu.common.Number
import furhatos.util.Language
import furhatos.nlu.*


class RecipeList : ListEntity<Recipe1>()

class Recipe1 : EnumEntity(stemming = true, speechRecPhrases = true) {

    override fun getEnum(lang: Language): List<String> {
        return listOf(chilliConCarneRecipe.desc, BakedfalafelRecipe.desc, PerfectscrambledeggsRecipe.desc) // Insert here other Recipes
    }
}
class Recipe2 : EnumEntity(stemming = true, speechRecPhrases = true) {

    override fun getEnum(lang: Language): List<String> {
        return listOf(spaghettiRecipe.desc, FrenchToastRecipe.desc)
    }
}

class Recipe3 : EnumEntity(stemming = true, speechRecPhrases = true) {

    override fun getEnum(lang: Language): List<String> {
        return listOf(spaghettiRecipe.desc) // suggestion recipe
    }
}

class FindRecipe(var recipes : RecipeList? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@fruits", "I want @fruits", "I would like @fruits", "I want to buy @fruits")
    }
}

class RequestOptions: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("What options do you have?",
                "What recipes do you have?",
                "What do you suggest?")
    }
}

class recipeList1 : ListEntity<Quantifiedrecipe>()

class Quantifiedrecipe(
        var reciper : Recipesr? = null) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("@reciper", "I want @reciper", "I would like @reciper", "I want to make @reciper")
    }

    override fun toText(): String {
        return generate(reciper?.value)
    }
}

class Recipesr : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("Chilli con carne", "Spaghetti", "Baked falafel", "scrambled eggs","French toast")
    }
}

class orderrecipe(var recipes : recipeList1? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@recipes", "I want to cook @recipes", "I would like to cook @recipes")
    }
}