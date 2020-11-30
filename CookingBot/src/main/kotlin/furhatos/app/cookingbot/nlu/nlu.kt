package furhatos.app.cookingbot.nlu



import furhatos.nlu.*
import furhatos.nlu.grammar.Grammar
import furhatos.nlu.kotlin.grammar
import furhatos.nlu.common.Number
import furhatos.util.Language



class RecipeList : ListEntity<RecipeContainer>()


class Recipe : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("chili con carne", "scrambled eggs", "falafel", "spaghetti bolognese", "French toast" )
    }
}


var chili = CompleteRecipe( )

class CompleteRecipe(
        var recipe : Recipe? = null,
        var ingredients : IngredientsList? =null,
        var procedure : Procedure? =null): ComplexEnumEntity() {
    override fun getEnum(lang: Language): List<String> {
        return listOf("@recipe")
    }
    override fun toText(): String {
        return generate("${recipe?.value}")
    }
    fun goThruIng(): String {
        return generate("${ingredients?.value}")
    }
    fun goThruProc(): String {
        return generate("${procedure?.value}")
    }
}

class Ingredients(var product : String) : EnumEntity(){
    override fun toText(): String {
        return generate("${product?.value}")
    }
}
class IngredientsList : ListEntity<Ingredients>()

class Instruction(var instruc : String) :  EnumEntity(){
    override fun toText(): String {
        return generate("${instruc?.value}")
    }
}
class Procedure : ListEntity<Instruction>()




class Ingrients : EnumEntity(stemming = true, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("chili con carne", "scrambled eggs", "falafel", "spaghetti bolognese", "French toast" )
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



class FindRecipe(var recipe : Recipe? = null) : Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@recipe", "I want @recipe", "I would like to make @recipe", "let's make @recipe")
    }
}



class RequestOptions: Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("What options do you have?",
                "What recipes do you have?",
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

