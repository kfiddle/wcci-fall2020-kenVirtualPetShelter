import org.junit.Assert;
import org.junit.Test;

public class VirtualPetShelterTest {

    VirtualPetShelter testingShelter = new VirtualPetShelter();

    VirtualPet test1 = new VirtualPet("sandy", 11, "loves to gnaw hair");
    VirtualPet test2 = new VirtualPet("zed", 2, "is a siamese athlete");
    VirtualPet test3 = new VirtualPet("jackie", 11, "eats all day", 10, 12, 15, 20, 5);

    @Test
    public void testingAddAPet() {
        VirtualPet homelessTestCase = new VirtualPet("sophie", "eats alot");
        testingShelter.add(homelessTestCase);
        Assert.assertEquals(1, testingShelter.pets.size());
        Assert.assertEquals("eats alot", testingShelter.pets.get("sophie").getDescription());
    }

    @Test
    public void testingTickMethod() {
        testingShelter.add(test1);
        testingShelter.add(test2);
        testingShelter.tick();
        Assert.assertEquals(24, test2.getHunger());
    }

    @Test
    public void testingAdoption() {
        testingShelter.add(test1);
        testingShelter.adopt("sandy");
        Assert.assertEquals(0, testingShelter.pets.size());
    }

    @Test
    public void testingFeedAllPets() {
        testingShelter.add(test1);
        testingShelter.add(test2);
        testingShelter.feedAll(3);
        Assert.assertEquals(7, test1.getHunger());
        Assert.assertEquals(17, test2.getHunger());
    }

    @Test
    public void testingWaterAllPets() {
        testingShelter.add(test1);
        testingShelter.add(test2);
        testingShelter.waterAll(2);
        Assert.assertEquals(11, test1.getThirst());
        Assert.assertEquals(16, test2.getThirst());
    }

    @Test
    public void testGiveWaterToSpecificPet() {
        testingShelter.add(test2);
        testingShelter.add(test3);
        testingShelter.waterSpecificPet("zed");
        testingShelter.waterSpecificPet("jackie");
        Assert.assertEquals(10, test3.getThirst());
        Assert.assertEquals(13, test2.getThirst());
    }

    @Test
    public void testStrokePet() {
        testingShelter.add(test2);
        testingShelter.add(test3);
        test2.stroke();
        test3.stroke();
        Assert.assertEquals(5, test2.getHuntDesire());
        Assert.assertEquals(5, test3.getVigilance());
    }

    @Test
    public void testingPlayWithPet() {
        testingShelter.add(test1);
        testingShelter.playWith("sandy");
        Assert.assertEquals(5, test1.getVigilance());
        Assert.assertEquals(0, test1.getHuntDesire());
    }

    @Test
    public void testingPetNameExists() {
        testingShelter.add(test1);
        Assert.assertEquals(true, testingShelter.confirmName("sandy"));
        Assert.assertEquals(false, testingShelter.confirmName("larry"));
    }


}







