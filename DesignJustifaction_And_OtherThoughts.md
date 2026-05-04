# Design Justification 

One alternative design I considered was a case switch for the player-command input. I ultimately decided against it because whil i did brief research I felt I didn't wqite understand it enough to implement it. I chose an if tree structure because I felt more comfortable with it. 
As well I made puzzle its own class despite the box being an item in technicality because I did not want to create a whole new section being 'pick-up able' and I felt for this one instance it might be better. Now this does limit the exstensiblity of that specific class but for this project it worked, however an alternative could have been making it extend item or structure the class itself differently. 
I also made Door it's own class because it did not share most traits with other items in the class, however I understand I could have done that and have it extend the item class(which would technically still be it's own class) but I felt that unnecessary. 

# Exstensibility Thoughts 
I wasn't sure where to include this but I wanted to justify why I am leaving in classes that are not currently used in this game. There are classes: Opponent, Trader, Weapon, and AreaSpecial that are not used. My intention when creating this game was to make the world much richer and fuller of challenges, fights, and trading. However, time did not allow this but by the time I figured that out I had already shelled out the classes. Part of this project is the exstensibility of it, and if it posisble for someone to pick this up. I feel that by leaving these in I am fitting that requirement because someone could see the space that was left for these add ins and add them in at their own will and I think that is important. 
I have left these in the annotated architecture diagram because they technically do exist and have relationships even if in the current gameloop model they are not referenced. 
Aswell, I understand I harcoded a lot of what goes into this game, like the move counter and a little bit of how the puzzle box is constructed but I do believe those would not be hard to change and therefore still leaves this code exstensible. 

