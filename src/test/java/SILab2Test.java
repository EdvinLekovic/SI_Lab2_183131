import org.graalvm.compiler.replacements.SnippetTemplate;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    SILab2 siLab2 = new SILab2();
    @Test
    public void MultipleConditions() {
        //------MULTIPLE CONDITION 1------
        // user.getUsername()!=null && user.getEmail()!=null && !allUsers.contains(user.getUsername())
        //1.(F && X && X) i tuka go imame razgranuvanjeto B-K
        assertFalse(siLab2.function(new User(null,null,null),null));
        //2.(T && F && X) tuka povtorno go imame istoto razgranuvanje
        assertFalse(siLab2.function(new User("Edvin",null,null),null));
        //3.(T && T && F) povtorno istoto razgranuvanje
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@students.finki.ukim.mk"), Arrays.asList("Edvin","Sarko","Marko")));
        //4.(T && T && T) tuka e vekje ispolnet uslovot taka da kje navlezeme vo ramkite na ovoj uslov i razgranuvanjeto e B-C1
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
        //------MULTIPLE CONDITION 2------
        //atChar && dotChar
        //1.(F && X) i tuka razgranuvanjeto e I-K
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
        //2.(T && F) i tuka e istoto razgranuvanje
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@gmailcom"),Collections.emptyList()));
        //3 (T && T) ovde ni se menuva razgranuvanjeto vo I-J
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Sarko","Darko","Marko")));
    }

    @Test
    public void EveryBranch(){
        //1. So ovoj assert gi opfakjame slednive granki: A-B , B-C1 , C1-C2 , C2-D , C2-I , D-E , E-F , F-G , G-H , H-C3 , C3-C2 и I-J i programata zavrsuva kako tocna
        assertTrue(siLab2.function(new User("Edvin", "SuperSum123", "edvin.lekovikj@students.finki.ukim.mk"), Arrays.asList("Darko","Sarko","Marko")));
        //2. So ovoj assert ja opfakjame samo grankata A-K
        assertFalse(siLab2.function(null, null));
        //3. Od ovoj primer gi razgranuvame grankite: A-B i B-K
        assertFalse(siLab2.function(new User("Edvin",null,null),null));
        //4. Vo ovoj primer gi razgranuvame grankite: A-B , B-C1 , C1-C2 , C2-D , C2-I , D-F , F-H, H-C3 , C3-C2 i I-K
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
    }
}