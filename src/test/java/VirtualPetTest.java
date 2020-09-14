import org.junit.Assert;
import org.junit.Test;


public class VirtualPetTest {
    VirtualPet testPet1 = new VirtualPet("grace", "is very sweet");
    VirtualPet testPet2 = new VirtualPet("azaneth", 12, "is a demon");
    VirtualPet testPet3 = new VirtualPet("sophie", 5, "is also very sweet", 9, 11, 20, 15, 8);
    VirtualPet testPet4 = new VirtualPet("scamper", 20, "is a twit", 18, 17, 5, 10, 25);

    // test the new constructors and also makes sure age will initialize other variables

    @Test
    public void testCreatingPetObjectConstructors() {
        Assert.assertEquals(9, testPet3.getHunger());
        Assert.assertEquals("grace", testPet1.getName());
        Assert.assertEquals("is very sweet", testPet1.getDescription());
        Assert.assertEquals(12, testPet2.getAge());
        Assert.assertEquals(17, testPet4.getThirst());
    }

    //tests of new methods

    @Test
    public void testingNewWaterMethod() {
        testPet3.giveWater(2);
        Assert.assertEquals(3, testPet3.getThirst());
    }

    @Test
    public void testingAssessmentCalculation(){
        Assert.assertEquals(75, testPet4.getAssessment());
        Assert.assertEquals(60, testPet2.getAssessment());
    }

    // retest original methods

    @Test
    public void testIftheBasicFeedingPetWorks() {

        testPet3.feed(5);
        Assert.assertEquals(25, testPet3.getHunger());
        Assert.assertEquals(25, testPet3.getVigilance());
    }

    @Test
    public void letsGiveDryFoodByCallingFeedMethod() {

        testPet4.feedDryFood(3);
        Assert.assertEquals(15, testPet4.getHunger());
        Assert.assertEquals(-4, testPet4.getVigilance());
    }


    @Test
    public void sameTestButWithWetFood() {

        testPet3.feedWetFood(3);
        Assert.assertEquals(0, testPet3.getHunger());
        Assert.assertEquals(-20, testPet3.getVigilance());
    }


    @Test
    public void sameTestButWithTreat() {

        testPet4.feedTreat(3);
        Assert.assertEquals(12, testPet4.getHunger());
        Assert.assertEquals(-23, testPet4.getVigilance());
        Assert.assertEquals(16, testPet4.getFatigue());

    }
    @Test
    public void testGiveWaterToSpecificPet() {
        testPet3.giveWater(4);
        Assert.assertEquals(3, testPet3.getThirst());

    }
    @Test
    public void testThePettingMethod() {

        testPet3.stroke();
        Assert.assertEquals(5, testPet3.getVigilance());
    }


    // the two hunting method tests

    @Test
    public void testMouseOrBirdHunting() {
        testPet1.setAge(2);
        testPet1.hunt();
        Assert.assertEquals(0, testPet1.getHunger());
    }

    @Test
    public void testPetToy() {
        testPet1.setAge(3);
        testPet1.play();
        Assert.assertEquals(15, testPet1.getVigilance());
    }


}
