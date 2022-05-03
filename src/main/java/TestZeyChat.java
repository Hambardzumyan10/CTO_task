import Models.ExercisesLogics;
import Models.UtilsZeyChat;
import org.testng.annotations.*;

public class TestZeyChat
{
    UtilsZeyChat ZeyChat;
    ExercisesLogics logics;
    @BeforeMethod
    public void BeforeMethod() throws InterruptedException {
        ZeyChat=new UtilsZeyChat();
        ZeyChat.LoginToZeyChat();
    }
    @Test
    public void LoginToTheSystemAndCompareDashboard() throws InterruptedException { //first Exercises
        logics=new ExercisesLogics();
        logics.Ex1();
    }
    @Test
    public void DashboardActiveButtonsOrNot() throws InterruptedException { //two and three Exercises
        logics=new ExercisesLogics();
        logics.Ex2AndEx3();
    }
    @Test
    public void PersonalAccountAndAvatarVisibleOrNot() throws InterruptedException { //Four Exercises
        logics=new ExercisesLogics();
        logics.Ex4();
    }
    @Test
    public void KarenPageIsDisplayed() throws InterruptedException { //Five Exercises
        logics=new ExercisesLogics();
        logics.Ex5();
    }


    @Test
    public void NegativeTest() throws InterruptedException { //Five Exercises
        logics=new ExercisesLogics();
        logics.NegativeTests();
    }
    @AfterMethod
    public void Close(){


    }
}