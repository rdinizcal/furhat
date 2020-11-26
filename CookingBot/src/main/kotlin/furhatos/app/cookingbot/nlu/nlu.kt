package furhatos.app.cookingbot.nlu



import furhatos.nlu.*
import furhatos.nlu.grammar.Grammar
import furhatos.nlu.kotlin.grammar
import furhatos.nlu.common.Number
import furhatos.util.Language



class RecipeList : ListEntity<RecipeContainer>()


class Recipe : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("chill sin carne", "scrambled eggs", "falafel", "spaghetti bolognese", "French toast" )
    }
}
class RecipeContainer(
        var recipe : Recipe? = null) : ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("@recipe")
    }

    override fun toText(): String {
        return generate("${recipe?.value}")
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

