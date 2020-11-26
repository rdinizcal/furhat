package furhatos.app.cookingbot.nlu



import furhatos.app.cookingbot.knowledgebase.*
import furhatos.nlu.*
import furhatos.nlu.grammar.Grammar
import furhatos.nlu.kotlin.grammar
import furhatos.nlu.common.Number
import furhatos.util.Language

class RecipeList : ListEntity<Recipe>()

class Recipe : EnumEntity(stemming = true, speechRecPhrases = true) {

    override fun getEnum(lang: Language): List<String> {
        return listOf(chilliConCarneRecipe.name) // Insert here other Recipes
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

class IngredientQuantity(var name: String) {}

class RequestQuantity(var quantifiedStep: QuantifiedStep? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("How many @ingredientQuantity ?", "How much @ingredient ?")
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
