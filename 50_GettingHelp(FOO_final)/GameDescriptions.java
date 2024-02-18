public class GameDescriptions {
    public final String getGameDescription() {
        return ANSI.DESCRIPTION + """
        *************************************  THE FOUNTAIN OF OBJECTS  *************************************
        -----------------------------------------------------------------------------------------------------
        * You enter the Cavern of Objects, a maze of rooms filled with dangerous pits in search of the 
        Fountain of Objects. Light is visible only in the entrance, and no other light is seen anywhere in 
        the caverns. You must navigate the Caverns with your other senses.
        
        * Find the Fountain of Objects, activate it, and return to the entrance. 
        
        * Look out for pits. You will feel a breeze if a pit is in an adjacent room. 
        If you enter a room with a pit, you will die.
        
        * Maelstroms are violent forces of sentient wind. Entering a room with one could transport you to any 
        other location in the caverns. You will be able to hear their growling and groaning in nearby rooms.
        
        * Amaroks roam the caverns. Encountering one is certain death, but you can smell their rotten stench 
        in nearby rooms.
        
        * You carry with you a bow and a quiver of arrows. You can use them to shoot monsters in the caverns 
        but be warned: you have a limited supply.
        """ + ANSI.RESET;
    }
    
    public final String getCommandDescriptions() {
        return ANSI.DESCRIPTION + """
        -----------------------------------------------------------------------------------------------------
        Available commands:
        * move north - you will move one room to the north
        * move south - you will move one room to the south
        * move east - you will move one room to the east
        * move west - you will move one room to the west
        * shoot north - shoots an arrow into the room to the north and kills any monster present in that room
        * shoot south - shoots an arrow into the room to the south and kills any monster present in that room
        * shoot east - shoots an arrow into the room to the east and kills any monster present in that room
        * shoot west - shoots an arrow into the room to the west and kills any monster present in that room
        * enable fountain - enables the fountain of objects
        """ + ANSI.RESET; 
    }
}