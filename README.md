---------- Sanity ----------

Mvn clean install Trystan's AsciiPanel first, then clean install this project to get the dependencies all nice.  

http://trystans.blogspot.com.br/2011/08/roguelike-tutorial-03-scrolling-through.html - so far.

Dear Jim, 

To run the project, execute the main(String[] args) in AppMainTest. I am using a test file as a runner, please forgive me, for I know what I have done...

This guy's code is shocking, so I am going through and applying some best practices to it. 

Genuinely some stuff made my poor head hurt so I wanted to clean some of it up and take ownership of some of the patterns so that I can learn better (learn good?).

Basic code layout is thus:

We have AppMain: this deals with running the JFrame and updating what screen we see when we press buttons. This was very cryptically written to start with, so
I broke out the functionality into different parts, you can see what needs to be done to start it up and what steps need to be taken to redraw the crap that's in our screens.

Which leads me onto Screens, these are in a package together, an implement the Screen interface. This is done so that in AppMain I can say Screen = screen.respondToUserInput(blah)
AppMain doesn't care about what screen it shows, it just knows to show whatever is returned. Simple. The screen interface has displayOutput and respondToUser input as methods. They
Do what they say on the tin. Ronseal code so far. 

Then we have the map package. This is where I had to get my hands dirty and rip apart some of his objects and change access levels on lots of Objects and create some new ones to 
manage some responsiblities. And so I did this so that our project can start to take shape a little neater, I want us to start defining how we think about the code and layouts and to 
be comfortable making bolder moves when it comes to fiddling around with the real guts of map creation and what our world looks and feels like. 

Rambling aside: map package has four classes. WorldBuilder, World, Tile, DefaultAutomata. It has one interface: LandscapeAutomata. WorldBuilder is the only constructable object outside
of the package and this is for encapsulation purposes. I don't want any other object to be able to create a world other than worldbuilder, I also don't want another other object to contain
tiles than my world <--- this is just logical, where else would Tiles go? I went for a encapsulated builder (he did too) because our world is going to be a lot more complicated and this
retains the access levels that I want for this package but is also infinitely extensible as things get more and more complex. 

Finally LandscapeAutomata and it's implementation DefaultAutomata. This will get better names, but they generate the map. I split these out of his world builder in the tutorial because I hate
his code, it's messy, it's arrow shaped (cyclomatically complex), it's badly labeled, it's shockingly formatted on the tutorial. However I am going at a rate of knots, so I don't want to 
sit and relearn all the cellular automata theory and algorithms I used to know. I will do that, just not now. His code also creates caves that don't lead anywhere, which make for a prettttty
busted game so far. I hoiked out LandscapeAutomata, so that when we replace this shit, it doesn't break any of the other code, we just implement the interface again and voila, nice clean maps. 

Finally finally, the code as it stands can't scroll like he says that it does. I got tired and copypasta his guff off of the page which means, I wasn't concentrating and so it's both my fault 
and his. Mainly his. Have a read through the tutorial link at the top, and fix my mistake please.


I give this dude a hard time but really he's a'ite. He's definitely taught me a thing or two and what he speaks about in his tutorial are the right things(tm) to be teaching newer Java programmers
I'm just an access and formatting and pattern Nazi from too many late evenings wondering why everything is fucked.

Good luck weary traveller. x
