package furhatos.app.cookingbot.knowledgebase

class Step (id: Int, body: String, quantities : List<String>) {
    var id          = id-1
    var body        = body
    var quantities    = quantities

    // tips for specific states?
}

class QuantifiedStep(id: Int, quantities: List<String>){
    var id          = id-1
    var quantities  = quantities
}


class RecipeDesc (name: String, desc: String, prepTime: String,  cookTime: String, level: String, size: String,  steps: List<Step>){

    var name        = name
    var desc        = desc
    var prepTime    = prepTime
    var cookTime    = cookTime
    var level       = level
    var size        = size
    var steps       = steps

    // We also need to add the ingredients here. How?
}

var cccStep1 : Step = Step(1, "Prepare your vegetables. Chop 1 large onion into small dice, about 5mm square. The easiest way to do this is to cut the onion in half from root to tip, peel it and slice each half into thick matchsticks lengthways, not quite cutting all the way to the root end so they are still held together. Slice across the matchsticks into neat dice.", listOf<String>("1 large onion"))
var cccStep2 : Step = Step(2, "Cut 1 red pepper in half lengthways, remove stalk and wash the seeds away, then chop. Peel and finely chop 2 garlic cloves.", listOf<String>("1 red pepper", "2 garlic cloves"))
var cccStep3 : Step = Step(3, "Start cooking. Put your pan on the hob over a medium heat. Add 1 tbsp oil and leave it for 1-2 minutes until hot (a little longer for an electric hob).", listOf<String>("1 tbsp of oil"))
var cccStep4 : Step = Step(4, "Add the onion and cook, stirring fairly frequently, for about 5 minutes, or until the onion is soft, squidgy and slightly translucent.", listOf<String>())
var cccStep5 : Step = Step(5, "Tip in the garlic, red pepper, 1 heaped tsp hot chilli powder or 1 level tbsp mild chilli powder, 1 tsp paprika and 1 tsp ground cumin.", listOf<String>("1 heaped tsp hot chilli powder", "1 level tbsp mild chilli powder", "1 tsp ground cumin" , "1 tsp paprika"))
var cccStep6 : Step = Step(6, "Give it a good stir, then leave it to cook for another 5 minutes, stirring occasionally.", listOf<String>())
var cccStep7 : Step = Step(7, "Brown 500g lean minced beef. Turn the heat up a bit, add the meat to the pan and break it up with your spoon or spatula. The mix should sizzle a bit when you add the mince.", listOf<String>("500g lean minced beef"))
var cccStep8 : Step = Step(8, "Keep stirring and prodding for at least 5 minutes, until all the mince is in uniform, mince-sized lumps and there are no more pink bits. Make sure you keep the heat hot enough for the meat to fry and become brown, rather than just stew.", listOf<String>())
var cccStep9 : Step = Step(9, "Make the sauce. Crumble 1 beef stock cube into 300ml hot water. Pour this into the pan with the mince mixture.", listOf<String>("1 beef stock cube", "300ml hot water"))
var cccStep10 : Step = Step(10, "Add a 400g can of chopped tomatoes. Tip in ½ tsp dried marjoram, 1 tsp sugar and add a good shake of salt and pepper. Squirt in about 2 tbsp tomato purée and stir the sauce well.", listOf<String>("400g can of chopped tomatoes"))
var cccStep11 : Step = Step(11, "Simmer it gently. Bring the whole thing to the boil, give it a good stir and put a lid on the pan. Turn down the heat until it is gently bubbling and leave it for 20 minutes.", listOf<String>())
var cccStep12 : Step = Step(12, "Check on the pan occasionally to stir it and make sure the sauce doesn’t catch on the bottom of the pan or isn’t drying out. If it is, add a couple of tablespoons of water and make sure that the heat really is low enough. After simmering gently, the saucy mince mixture should look thick, moist and juicy.", listOf<String>())
var cccStep13 : Step = Step(13, "Drain and rinse a 410g can of red kidney beans in a sieve and stir them into the chilli pot. Bring to the boil again, and gently bubble without the lid for another 10 minutes, adding a little more water if it looks too dry.", listOf<String>())
var cccStep14 : Step = Step(14, "Taste a bit of the chilli and season. It will probably take a lot more seasoning than you think.", listOf<String>())
var cccStep15 : Step = Step(15, "Now replace the lid, turn off the heat and leave your chilli to stand for 10 minutes before serving. This is really important as it allows the flavours to mingle.", listOf<String>())
var cccStep16 : Step = Step(16, "Serve with soured cream and plain boiled long grain rice.", listOf<String>())
var cccStepsList = listOf<Step>(cccStep1,cccStep2,cccStep3,cccStep4,cccStep5,cccStep6,cccStep7,cccStep8,cccStep9,cccStep10,cccStep11,cccStep12,cccStep13,cccStep14,cccStep15,cccStep16)

var chilliConCarneRecipe : RecipeDesc = RecipeDesc("Chilli con Carne", "This great chilli recipe has to be one of the best dishes to serve to friends for a casual get-together. An easy sharing favourite that uses up store cupboard ingredients.", "10 min",  "1 hour", "Easy", "4 people", steps=cccStepsList)
