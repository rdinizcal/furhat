/**
 * This file contains the definitions of a recipe and its steps. Also, the instantiation of 5 recipes.
 * @author: dinizr@chalmers.se; shamisa.shoja@liu.se
 */

package furhatos.app.cookingbot.knowledgebase

class Step (id: Int, body: String) {
    var id      = id-1
    var body    = body
    // tips for specific states?
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

var cccStep1 : Step = Step(1, "Prepare your vegetables. Chop 1 large onion into small dice, about 5mm square. The easiest way to do this is to cut the onion in half from root to tip, peel it and slice each half into thick matchsticks lengthways, not quite cutting all the way to the root end so they are still held together. Slice across the matchsticks into neat dice.")
var cccStep2 : Step = Step(2, "Cut 1 red pepper in half lengthways, remove stalk and wash the seeds away, then chop. Peel and finely chop 2 garlic cloves.")
var cccStep3 : Step = Step(3, "Start cooking. Put your pan on the hob over a medium heat. Add 1 tbsp oil and leave it for 1-2 minutes until hot (a little longer for an electric hob).")
var cccStep4 : Step = Step(4, "Add the onion and cook, stirring fairly frequently, for about 5 minutes, or until the onion is soft, squidgy and slightly translucent.")
var cccStep5 : Step = Step(5, "Tip in the garlic, red pepper, 1 heaped tsp hot chilli powder or 1 level tbsp mild chilli powder, 1 tsp paprika and 1 tsp ground cumin.")
var cccStep6 : Step = Step(6, "Give it a good stir, then leave it to cook for another 5 minutes, stirring occasionally.")
var cccStep7 : Step = Step(7, "Brown 500g lean minced beef. Turn the heat up a bit, add the meat to the pan and break it up with your spoon or spatula. The mix should sizzle a bit when you add the mince.")
var cccStep8 : Step = Step(8, "Keep stirring and prodding for at least 5 minutes, until all the mince is in uniform, mince-sized lumps and there are no more pink bits. Make sure you keep the heat hot enough for the meat to fry and become brown, rather than just stew.")
var cccStep9 : Step = Step(9, "Make the sauce. Crumble 1 beef stock cube into 300ml hot water. Pour this into the pan with the mince mixture.")
var cccStep10 : Step = Step(10, "Add a 400g can of chopped tomatoes. Tip in ½ tsp dried marjoram, 1 tsp sugar and add a good shake of salt and pepper. Squirt in about 2 tbsp tomato purée and stir the sauce well.")
var cccStep11 : Step = Step(11, "Simmer it gently. Bring the whole thing to the boil, give it a good stir and put a lid on the pan. Turn down the heat until it is gently bubbling and leave it for 20 minutes.")
var cccStep12 : Step = Step(12, "Check on the pan occasionally to stir it and make sure the sauce doesn’t catch on the bottom of the pan or isn’t drying out. If it is, add a couple of tablespoons of water and make sure that the heat really is low enough. After simmering gently, the saucy mince mixture should look thick, moist and juicy.")
var cccStep13 : Step = Step(13, "Drain and rinse a 410g can of red kidney beans in a sieve and stir them into the chilli pot. Bring to the boil again, and gently bubble without the lid for another 10 minutes, adding a little more water if it looks too dry.")
var cccStep14 : Step = Step(14, "Taste a bit of the chilli and season. It will probably take a lot more seasoning than you think.")
var cccStep15 : Step = Step(15, "Now replace the lid, turn off the heat and leave your chilli to stand for 10 minutes before serving. This is really important as it allows the flavours to mingle.")
var cccStep16 : Step = Step(16, "Serve with soured cream and plain boiled long grain rice.")
var cccStepsList = listOf<Step>(cccStep1,cccStep2,cccStep3,cccStep4,cccStep5,cccStep6,cccStep7,cccStep8,cccStep9,cccStep10,cccStep11,cccStep12,cccStep13,cccStep14,cccStep15,cccStep16)

var chilliConCarneRecipe : RecipeDesc = RecipeDesc("Chilli con Carne", "This great chilli recipe has to be one of the best dishes to serve to friends for a casual get-together. An easy sharing favourite that uses up store cupboard ingredients.", "10 min",  "1 hour", "Easy", "4 people", steps=cccStepsList)

// Perfect scrambled eggs recipe

var pseStep1 : Step = Step(1, "Lightly whisk 2 large eggs, 6 tbsp single cream or full cream milk and a pinch of salt together until the mixture has just one consistency.")
var pseStep2 : Step = Step(2, "Heat a small non-stick frying pan for a minute or so, then add a knob of butter and let it melt. Don’t allow the butter to brown or it will discolour the eggs.")
var pseStep3 : Step = Step(3, "Pour in the egg mixture and let it sit, without stirring, for 20 seconds. Stir with a wooden spoon, lifting and folding it over from the bottom of the pan.")
var pseStep4 : Step = Step(4, "Let it sit for another 10 seconds then stir and fold again.")
var pseStep5 : Step = Step(5, "Repeat until the eggs are softly set and slightly runny in places. Remove from the heat and leave for a moment to finish cooking.")
var pseStep6 : Step = Step(6, "Final step: Give a final stir and serve the velvety scramble without delay.")
var pseStepsList = listOf<Step>(pseStep1,pseStep2,pseStep3,pseStep4,pseStep5,pseStep6)

var PerfectscrambledeggsRecipe : RecipeDesc = RecipeDesc("Perfect scrambled eggs", "Perfect scrambled egg is a quick breakfast packed with protein, courtesy of Bill Granger.", "20 min", "20 min" , "Easy", "" ,steps=pseStepsList)

// Baked falafel

var bfStep1 : Step = Step(1, "Heat oven to 200C/180C fan/gas 6 and line two baking sheets with baking parchment. Tip the chickpeas, ground cumin, ground coriander, the cayenne pepper, onion, garlic, sesame seeds, baking powder, parsley stalks and 1 tbsp water into a food processor. Blitz until combined but not smooth (you want the falafel to have some texture, rather than being the consistency of hummus).")
var bfStep2 : Step = Step(2, "Final step: Season to taste, then roll into 18 evenly sized balls. Flatten each ball into a disc shape and arrange on the baking sheets, then brush the tops with 1 tbsp of the oil. Bake for 20 mins until golden and crisp, turning halfway through cooking.")
var bfStepsList = listOf<Step>(bfStep1,bfStep2)

var BakedfalafelRecipe : RecipeDesc = RecipeDesc("Baked falafel", "The baked falafel balls are ideal for a healthy lunch. Serve with a fresh tabbouleh salad or stuffed inside a pitta for a filling veggie dish", "20 min", "20 min" , "Easy", "6 people" ,steps=bfStepsList)

// Spaghetti

var spStep1 : Step = Step(1, "Put a large saucepan on a medium heat and add 1 tbsp olive oil.")
var spStep2 : Step = Step(2, "Add 4 finely chopped bacon rashers and fry for 10 mins until golden and crisp.")
var spStep3 : Step = Step(3, "Reduce the heat and add the 2 onions, 2 carrots, 2 celery sticks, 2 garlic cloves and the leaves from 2-3 sprigs rosemary, all finely chopped, then fry for 10 mins. Stir the veg often until it softens.")
var spStep4 : Step = Step(4, "Increase the heat to medium-high, add 500g beef mince and cook stirring for 3-4 mins until the meat is browned all over.")
var spStep5 : Step = Step(5, "Add 2 tins plum tomatoes, the finely chopped leaves from ¾ small pack basil, 1 tsp dried oregano, 2 bay leaves, 2 tbsp tomato purée, 1 beef stock cube, 1 deseeded and finely chopped red chilli (if using), 125ml red wine and 6 halved cherry tomatoes. Stir with a wooden spoon, breaking up the plum tomatoes.")
var spStep6 : Step = Step(6, "Bring to the boil, reduce to a gentle simmer and cover with a lid. Cook for 1 hr 15 mins stirring occasionally, until you have a rich, thick sauce.")
var spStep7 : Step = Step(7, "Add the 75g grated parmesan, check the seasoning and stir.")
var spStep8 : Step = Step(8, "When the bolognese is nearly finished, cook 400g spaghetti following the pack instructions.")
var spStep9 : Step = Step(9, "Final step: Drain the spaghetti and either stir into the bolognese sauce, or serve the sauce on top. Serve with more grated parmesan, the remaining basil leaves and crusty bread, if you like.")

var spStepsList = listOf<Step>(spStep1,spStep2,spStep3,spStep4,spStep5,spStep6,spStep7,spStep8,spStep9)

var spaghettiRecipe : RecipeDesc = RecipeDesc("Spaghetti", "Our best ever spaghetti bolognese is super easy and a true Italian classic with a meaty, chilli sauce.", "25 min",  "1 hour and 50 min", "Easy", "6 people", steps=spStepsList)

// French Toast

var ftStep1 : Step = Step(1, "Whisk together the eggs, milk, cream, vanilla and cinnamon. Lay the brioche slices in a single layer in a shallow dish and pour the egg mixture over them. Allow to soak for 2-3 mins, then carefully turn over and soak for 2 mins more.")
var ftStep2 : Step = Step(2, "Heat 1 tbsp of the vegetable oil and butter in a non-stick frying pan over a medium heat until foaming. Carefully lift 2 slices of the soaked brioche out of the dish and add to the frying pan. Fry for 3 mins on each side, until golden and crisp, then place on a wire rack over a baking tray in a warm oven while you repeat with the remaining slices.")
var ftStep3 : Step = Step(3, "Final step: Serve dusted in icing sugar and scattered with fresh berries, if you like.")

var ftStepsList = listOf<Step>(ftStep1,ftStep2,ftStep3)
//var ftStepsList = listOf<Step>(ftStep1,ftStep2,finalStep)

var FrenchToastRecipe : RecipeDesc = RecipeDesc("French Toast", "French toast is a classic breakfast dish has plenty of names and just as many options for toppings.", "5 min", "15 min" , "Easy", "4 people" ,steps=ftStepsList)
