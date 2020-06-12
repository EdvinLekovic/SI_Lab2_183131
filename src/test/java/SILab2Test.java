import org.graalvm.compiler.replacements.SnippetTemplate;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
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
        //1. A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-E ; D-F ; E-F ; F-G ; F-H ; G-H ; H-C3 ; C3-C2 ; I1-I2 ; I2-J ; J-L
        assertTrue(siLab2.function(new User("Edvin","SuperSum123","edvin.lekovikj@students.finki.ukim.mk"),Collections.emptyList()));
        //2. A0,A1-K ; K-L
        assertFalse(siLab2.function(null,null));
        //3. A0,A1-B1 ; B1-K ; K-L
        assertFalse(siLab2.function(new User(null,null,null),null));
        //4. A0,A1-B1 ; B1-B2 ; B2-K ; K-L
        assertFalse(siLab2.function(new User("Edvin","SuperSum123",null),null));
        //5. A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-K ; K-L
        assertFalse(siLab2.function(new User("Edvin","SuperSUm123","edvin.lekovikj@students.finki.ukim.mk"),Arrays.asList("Edvin","Darko","Sarko")));
        //6. A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-F ; F-H ; H-C3 ; C3-C2 ; I1-K ; K-L
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj"),Collections.emptyList()));
        //7. A0,A1-B1 ; B1-B2 ; B2-B3 ; B3-C0,C1 ; C0,C1-C2 ; C2-D ; C2-I1 ; D-E ; D-F ; E-F ; F-H ; H-C3 ; C3-C2 ; I1-I2 ; I2-K ; K-L
        assertFalse(siLab2.function(new User("Edvin","SuperSum123","edvinlekovikj@studentsfinkiukimmk"), Arrays.asList("Darko","Sarko","Marko")));
    }
}