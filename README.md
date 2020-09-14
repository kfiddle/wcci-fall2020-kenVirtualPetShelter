# wcci-fall2020-kenVirtualPetShelter


The VirtualPet class has been updated here to include instance variables for "description", and "assessment". The new version also includes additional constructors, one which takes "name" and "description", and also one which takes all of the necessary attribute variables for the game.

The VirtualPetShelter class has a HashMap of VirtualPets, and includes all methods for interacting with the VirtualPet class, in addition to the display method, the tick method for updates variables at the end of each game loop, feeding, watering, petting, playing methods, and a method which calculates the average assessment score of the entire shelter.

The VirtualPetShelterApp class includes these methods...

exitGame()  
capitalize(), which capitalizes the first letter of a name and keeps the remainder in lower case
possessiveVersion(), which returns a string of the possessive version of a name
yesOrNoVerify(), deals with user entry to a yes or no question 
validInteger(), which takes an int for range, and returns a valid response from user
displayTime()
feedPet(), calls various feeding methods
mainMenuDisplay()
specifPetOptionsMenu()
go(), which houses the main loop and concluding statement
main()
