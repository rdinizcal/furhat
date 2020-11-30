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

class PreviousStep() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("previous step", "previous", "back", "backwards")
    }
}

class NextStep() : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("next step", "next", "forward", "yes")
//
    }
}

class OtherStep(
        var count : Number? = Number(1),
        var step : Step? = null) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("step @count", "@count")
    }

    //override fun toText(): String {
    //    return generate("$count " + if (count?.value == 1) fruit?.value else "${fruit?.value}" + "s")
    //}
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
        return listOf("Chilli con", "Spaghetti", "Baked falafel", "scrambled eggs","French toast")
    }
}

class orderrecipe(var recipes : recipeList1? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@recipes", "I want to cook @recipes", "I would like to cook @recipes")
    }
}

/* Deprecated
class RequestOptions: Intent() {
override fun getExamples(lang: Language): List<String> {
return listOf("What options do you have?",
        "What fruits do you have?",
        "What are the alternatives?",
        "What do you have?")
}
}


class FruitList : ListEntity<QuantifiedFruit>()

class QuantifiedFruit(
var count : Number? = Number(1),
var fruit : Fruit? = null) : ComplexEnumEntity() {
override fun getEnum(lang: Language): List<String> {
return listOf("@count @fruit", "@fruit")
}

override fun toText(): String {
return generate("$count " + if (count?.value == 1) fruit?.value else "${fruit?.value}" + "s")
}
}

class Fruit : EnumEntity(stemming = true, speechRecPhrases = true) {
override fun getEnum(lang: Language): List<String> {
return listOf("banana", "orange", "apple", "cherimoya")
}
}


class BuyFruit(var fruits : FruitList? = null) : Intent() {
override fun getExamples(lang: Language): List<String> {
return listOf("@fruits", "I want @fruits", "I would like @fruits", "I want to buy @fruits")
}
}
*/
