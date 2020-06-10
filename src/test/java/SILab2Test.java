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
        //3. (T && T) ovde ni se menuva razgranuvanjeto vo I-J
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Sarko","Darko","Marko")));
    }

    @Test
    public void EveryBranch(){
        //1. A-B1 , B1-B2 , B2-B3 , B3-C1 , C1-C2 , C2-D ,C2-I1 , D-E , E-F , F-G , G-H , H-C3 , C3-C2 , I1-I2 , I2-J
        assertTrue(siLab2.function(new User("Edvin", "SuperSum123", "edvin.lekovikj@students.finki.ukim.mk"), Arrays.asList("Darko","Sarko","Marko")));
        //2. A-K
        assertFalse(siLab2.function(null, null));
        //3. A-B1 , B1-K
        assertFalse(siLab2.function(new User(null,null,null),Collections.emptyList()));
        //4. A-B1 , B1-B2 , B2-K
        assertFalse(siLab2.function(new User("Edvin",null,null),Collections.emptyList()));
        //5. A-B1 , B1-B2 , B2-B3 , B3-K
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Edvin","Darko","Sarko")));
        //6. A-B1 , B1-B2 , B2-B3 , B3-C1 , C1-C2 , C2-D , C2-I1 , D-F , F-H , C3-C2 , I1-K
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
        //7. A-B1 , B1-B2 , B2-B3 , B3-C1 , C1-C2 , C2-D , C2-I1 , D-E , E-F , F-H , H-C3 , C3-C2 , I1-I2 , I2-K
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvin@lekovikj"),Collections.emptyList()));
    }
}