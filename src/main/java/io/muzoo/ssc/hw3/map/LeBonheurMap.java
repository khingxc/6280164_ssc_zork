package io.muzoo.ssc.hw3.map;

public class LeBonheurMap {

    public Room currentRoom;

    private Room outside, cafe, auditorium, musicLibrary, musicStore, guitarRoom, drumRoom, singingRoom, adminRoom
            ,hallWay, chillRoom, vanishingRoom1, vanishingRoom2, meetingRoom1, meetingRoom2, guitarMakingRoom;

    public void createRooms(){

        // create the rooms
        outside = new Room("outside the main entrance of Le Bonheur Music Academy.");
        cafe = new Room("in the cafe named Le Rythme. This cafe decoration is based on musical theme with chill music~");
        auditorium = new Room("in the auditorium for anyone who wants to show their skills off! All is welcome!");
        musicLibrary = new Room("in the music library. This place collects tons of music sheets you may need. Check'em out!");
        musicStore = new Room("in the music store. There are lots of quality music instruments you need. You can try'em out!");
        guitarRoom = new Room("in the guitar room where you can practice, learn, and consult for improvements from professionals.");
        drumRoom = new Room ("in the drum room where you can practice, learn, and consult for improvements from professionals.");
        singingRoom = new Room("in the singing room where you can practice, learn, and consult for improvements from professionals.");
        adminRoom = new Room("in the admin office. You can ask for staffs' help here!");

        //first floor

        //outside
        outside.setExits("east", musicStore);
        outside.setExits("south",auditorium);
        outside.setExits("west",cafe);

        //cafe
        cafe.setExits("east", outside);

        //music store
        musicStore.setExits("west",outside);

        //auditorium
        auditorium.setExits("north",outside);
        auditorium.setExits("east", adminRoom);
        auditorium.setExits("south",singingRoom);
        auditorium.setExits("west",musicLibrary);

        //music library
        musicLibrary.setExits("east", auditorium);

        //admin room
        adminRoom.setExits("west",auditorium);

        //singing room
        singingRoom.setExits("north",auditorium);
        singingRoom.setExits("east", drumRoom);
        singingRoom.setExits("west",guitarRoom);

        //guitar room
        guitarRoom.setExits("east", singingRoom);

        //drum room
        drumRoom.setExits("west", singingRoom);

    }
}
