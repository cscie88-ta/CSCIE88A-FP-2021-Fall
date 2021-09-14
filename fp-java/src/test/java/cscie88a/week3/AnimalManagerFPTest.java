package cscie88a.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalManagerFPTest {

    @Test
    public void testTrainForTricksNotFP_concrete(){
        Cat myCat = new Cat("Sneaky");
        boolean result = AnimalManagerFP.trainForTricksNotFP(myCat);
        assertFalse(result);

        myCat.setGoodMood(true);
        result = AnimalManagerFP.trainForTricksNotFP(myCat);
        assertTrue(result);
    }

    @Test
    public void testTrainForTricksNotFP_anonymous(){
        boolean result = AnimalManagerFP.trainForTricksNotFP(
                new ITrainable() {
                    @Override
                    public boolean doTrick(String trickName) {
                        System.out.println("anonymous ITrainable - will do the trick " + trickName);
                        return true;
                    }
                });
        assertTrue(result);
    }

    /**
     * the regular implementation way
     */
    @Test
    public void testTrainToRun_concrete(){
        CatFP sneaky = new CatFP("Sneaky");
        boolean result = AnimalManagerFP.trainToRun(sneaky);
        assertFalse(result);
    }

    /**
     * the anonymous class way
     */
    @Test
    public void testTrainToRun_anonymous(){
        boolean result = AnimalManagerFP.trainToRun(
                new ITrainableFP() {
                    @Override
                    public boolean doTrick(String trickName) {
                        System.out.println("I hate running!");
                        return false;
                    }
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation
     * of the ITrainableFP interface;
     * as close to the class syntax as possible
     */
    @Test
    public void testTrainToRun_lambda1(){
        boolean result = AnimalManagerFP.trainToRun(
                (String trickName) -> {
                    System.out.println("I hate running!");
                    return false;
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation of the ITrainableFP interface;
     * simplifying syntax: omitting brackets and type for a single method argument
     */
    @Test
    public void testTrainToRun_lambda2(){
        boolean result = AnimalManagerFP.trainToRun(
                trickName -> {
                    System.out.println("I hate running!");
                    return false;
                }
        );
        assertFalse(result);
    }

    /**
     * the first Lambda function - as an implementation of the ITrainableFP interface;
     * simplifying syntax: one line body
     */
    @Test
    public void testTrainToRun_lambda3(){
        boolean result = AnimalManagerFP.trainToRun(
                trickName -> false
        );
        assertFalse(result);
    }

}