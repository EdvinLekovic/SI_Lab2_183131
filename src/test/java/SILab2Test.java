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
        //1. A-B , B-C1 , C1-C2 , C2-D , D-E , E-F , F-G , G-C3 , C3-C2 , C2-I , I-J
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
        //2. A-K
        assertFalse(siLab2.function(null,null));
        //3. A-B , B-K
        assertFalse(siLab2.function(new User("Edvin","superSum123",null),Collections.emptyList()));
        //4. A-B , B-C1 , C1-C2 , C2-D , D-F , F-C3 , C2-I , I-K
        assertFalse(siLab2.function(new User("Edvin","SuperSUm123","edvinlekovikj"),Arrays.asList("Darko","Vlatko","Ratko")));
    }
}